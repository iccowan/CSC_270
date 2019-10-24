public class TestQueue
{
   // Tests the constructor, creating some queues in the process
   public static Queue<Integer> testConstructor()
   {
      // Create 3 queues and put them in an arrray
      Queue<Integer> queue1 = new Queue<Integer>();
      Queue<Integer> queue2 = new Queue<Integer>();
      Queue<Integer> queue3 = new Queue<Integer>();
      
      return queue1;
   }
   
   // Tests the push() method
   public static void testPush(Queue<Integer> q)
   {
      // Insert some values into the queue
      int i = 1;
      while(i < 100)
      {
         q.push(i);
         i = i * 2;
      }
   }
   
   // Tests the pop() method
   public static void testPop(Queue<Integer> q)
   {
      // Pop the values from the queue
      int i = 1;
      while(i < 100)
      {
         int popVal = q.pop();
         assert popVal == i : "q.pop() should return " + i + " not " + popVal;
         i = i * 2;
      }
      
      // Make sure the program throws an exception when something extra is popped
      try
      {
         q.pop();
         assert false : "q.pop() when q is empty should throw a QueueUnderFlowException";
      }
      catch(QueueUnderFlowException e)
      {
         assert true;
      }
   }
   
   // Tests the isEmpty() method
   public static void testIsEmpty(Queue<Integer> q, boolean shouldBeEmpty)
   {
      assert q.isEmpty() == shouldBeEmpty : "q.isEmpty() should return " + shouldBeEmpty + " not " + q.isEmpty();
   }

   // Run the tests
   public static void test()
   {
      Queue<Integer> q = testConstructor();
      testIsEmpty(q, true);
      testPush(q);
      testIsEmpty(q, false);
      testPop(q);
      testIsEmpty(q, true);
   }

   // Main
   public static void main(String[] args)
   {
      test();
   }
}