// Ian Cowan
// TestList

import IntList.IntList;

public class TestList
{
   // Tests the IntList class
   private static void testIntList()
   {
      // Create a new list of maxLength 5
      IntList myList1 = new IntList(3);
      IntList myList2 = new IntList(6);
      IntList myList3 = new IntList(15);
      
      // Test IntList.maxSize()
      assert myList1.getMaxSize() == 3 : "myList1 maxSize should be 3 not " + myList1.getMaxSize();
      assert myList2.getMaxSize() == 6 : "myList2 maxSize should be 6 not " + myList2.getMaxSize();
      assert myList3.getMaxSize() == 15 : "myList3 maxSize should be 15 not " + myList3.getMaxSize();
      
      // Test IntList.length()
      assert myList1.length() == 0 : "myList1 length should be 0 not " + myList1.length();
      assert myList2.length() == 0 : "myList2 length should be 0 not " + myList2.length();
      assert myList3.length() == 0 : "myList3 length should be 0 not " + myList3.length();
      
      // Test IntList.getPos()
      assert myList1.getPos(1) == -1 : "myList1 getPos(1) should be -1 not " + myList1.getPos(1);
      assert myList2.getPos(3) == -1 : "myList2 getPos(3) should be -1 not " + myList2.getPos(3);
      assert myList3.getPos(6) == -1 : "myList3 getPos(6) should be -1 not " + myList3.getPos(6);
      
      // Now, test insertions
      assert myList1.insertBefore(3, 0) : "myList1 insertBefore(3, 0) should return true not false";
      assert (! myList2.insertBefore(2, 3)) : "myList2 insertBefore(2, 3) should return false not true";
      assert (! myList3.insertBefore(50, 17)) : "myList3 insertBefore(50, 17) should return false not true";
      
      // Test Lengths again
      assert myList1.length() == 1 : "myList1 length should be 1 not " + myList1.length();
      assert myList2.length() == 0 : "myList2 length should be 0 not " + myList2.length();
      assert myList3.length() == 0 : "myList3 length should be 0 not " + myList3.length();
      
      // Insert some other values for testing
      myList1.insertBefore(7, 1);
      myList2.insertBefore(5, 0);
      myList3.insertBefore(10, 0);
      
      // Test Inserting into other positions
      assert myList1.insertBefore(5, 1) : "myList1 insertBefore(5, 1) should return true not false";
      assert (! myList1.insertBefore(50, 0)) : "myList1 insertBefore(50, 0) should return true not false";
      assert myList2.insertBefore(52, 0) : "myList2 insertBefore(52, 0) should return true not false";
      assert (! myList3.insertBefore(10, 9)) : "myList3 insertBefore(10, 9) should return false not true";
      
      // Test lengths again after inserting more values
      assert myList1.length() == 3 : "myList1 length() should be 3 not " + myList1.length();
      assert myList2.length() == 2 : "myList2 length() should be 2 not " + myList2.length();
      assert myList3.length() == 1 : "myList3 length() should be 1 not " + myList3.length();
      
      // Now get those values back
      assert myList1.getPos(0) == 3 : "myList1 getPos(0) should be 5 not " + myList1.getPos(0);
      assert myList1.getPos(1) == 5 : "myList1 getPos(1) should be 5 not " + myList1.getPos(1);
      assert myList1.getPos(2) == 7 : "myList1 getPos(2) should be 3 not " + myList1.getPos(2);
      assert myList1.getPos(3) == -1 : "myList1 getPos(3) should be -1 not " + myList1.getPos(3);
      assert myList2.getPos(0) == 52 : "myList2 getPos(0) should be 52 not " + myList2.getPos(0);
      assert myList3.getPos(1) == -1 : "myList2.getPos(1) should be -1 not " + myList3.getPos(1);
      assert myList3.getPos(16) == -1 : "myList3 getPos(16) should be -1 not " + myList3.getPos(16);
      assert myList3.getPos(-1) == -1 : "myList3 getPos(-1) should be -1 not " + myList3.getPos(-1);
      
      // Remove some values
      assert myList1.remove(1) : "myList1 remove(1) should return true not false";
      assert (! myList1.remove(2)) : "myList1 remove(2) should return false not true";
      assert (! myList2.remove(3)) : "myList2 remove(3) should return false not true";
      assert myList3.remove(0) : "myList3 remove(0) should return true not false";
      assert (! myList1.remove(10)) : "myList1 remove(4) should return false not true";
      assert (! myList1.remove(-1)) : "myList remove(-1) should return false not true";
      
      // Check the maxSize again. Should not have changed
      assert myList1.getMaxSize() == 3 : "myList1 getMaxSize() should be 3 not " + myList1.getMaxSize();
      assert myList2.getMaxSize() == 6 : "myList2 getMaxSize() should be 6 not " + myList2.getMaxSize();
      assert myList3.getMaxSize() == 15 : "myList3 getMaxSize() should be 15 not " + myList3.getMaxSize();
      
      // Check the data after the remove
      assert myList1.getPos(0) == 3 : "myList1 getPos(0) should be 5 not " + myList1.getPos(0);
      assert myList1.getPos(1) == 7 : "myList1 getPos(1) should be 7 not " + myList1.getPos(1);
      assert myList1.getPos(2) == -1 : "myList1 getPos(2) should be -1 not " + myList1.getPos(2);
      assert myList3.getPos(0) == -1 : "myList2 getPos(0) should be -1 not " + myList3.getPos(0);
      
      // Check the lengths of the lists after removing data
      assert myList1.length() == 2 : "myList1 length() should be 2 not " + myList1.length();
      assert myList2.length() == 2 : "myList2 length() should be 2 not " + myList2.length();
      assert myList3.length() == 0 : "myList3 length() should be 0 not " + myList3.length();
   }
   
   // Main
   public static void main(String[] args)
   {
      testIntList();
      
      System.out.println("Everything tested successfully!");
   }
}