public class TestMemory
{
   public static void main(String[] args)
   {
      // Create our MemoryManager
      MemoryManager myManager = new MemoryManager(100);
      
      // Begin with some allocations
      MemoryAllocation allocation1 = myManager.requestMemory(20, "Test 1");
      MemoryAllocation allocation2 = myManager.requestMemory(17, "Test 2");
      MemoryAllocation allocation3 = myManager.requestMemory(36, "Test 3");
      
      // Test and make sure the memory allocated correctly
      assert myManager.requestMemory(50, "Should be null") == null : "Requesting an allocation of more memory than exists should return null";
      assert allocation1.getLength() == 20 : "allocation 1 length should be 20 not " + allocation1.getLength();
      assert allocation1.getPosition() == 0 : "allocation1 position should be 0 not " + allocation1.getPosition();
      assert allocation3.getLength() == 36 : "allocation 3 length should be 36 not " + allocation3.getLength();
      assert allocation3.getPosition() == 37 : "allocation3 position should be 37 not " + allocation3.getPosition();
      assert allocation1.getOwner() == "Test 1" : "allocation1 owner should be 'Test 1' not " + allocation1.getOwner();
      
      // Insert some tests of strange locations after some memory has been returned
      myManager.returnMemory(allocation2);
      MemoryAllocation allocation4 = myManager.requestMemory(10, "Test 4");
      MemoryAllocation allocation5 = myManager.requestMemory(10, "Test 5");
      
      // Make sure the positions are correct
      assert allocation4.getPosition() == 20 : "allocation4 position should be 20 not " + allocation4.getPosition();
      assert allocation5.getPosition() == 73 : "allocation5 position should be 73 not " + allocation5.getPosition();
      
      // Finally, make sure all memory will be used
      MemoryAllocation allocation6 = myManager.requestMemory(7, "Test 6");
      assert allocation6.getPosition() == 30 : "allocation6 position should be 30 not " + allocation6.getPosition();
      
      // Return the last memory block so it'll merge
      myManager.returnMemory(allocation5);
      
      // Make sure we can reinsert and we haven't lost memory at the end with merging
      MemoryAllocation allocation7 = myManager.requestMemory(27, "Test 7");
      assert allocation7 != null : "allocation7 position should be 73 not " + allocation7.getPosition();
      assert myManager.requestMemory(1, "Should be full") == null : "Memory should be full at this point";
      
      // Deallocate some memory
      myManager.returnMemory(allocation7);
      myManager.returnMemory(allocation6);
      myManager.returnMemory(allocation3);
      
      // Reallocate as one chunk
      MemoryAllocation allocation8 = myManager.requestMemory(70, "Test 8");
      assert allocation8 != null : "allocation8 position should be 30 not " + allocation8.getPosition();
      assert myManager.requestMemory(1, "Should be full") == null : "Memory should be full at this point";
   }
}