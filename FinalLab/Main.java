import java.util.concurrent.TimeUnit;
import java.lang.OutOfMemoryError;

public class Main
{
   // Tests the IDS
   public static void testIDS()
   {
      // Run this for length 1-14
      for(int i = 1; i <= 14; i++)
      {
         long totalTime = 0;
         long totalNodesVisited = 0;
         long totalLengthOfQueueStack = 0;

         System.out.println("--- Length " + i + " ---");

         try
         {
            for (int j = 0; j < 5; j++)
            {
               TheLock lock = new TheLock("Ian" + j, i);
               UnlockTree unlock = new UnlockTree();
                 
               // Record the time and unlock the lock
               long start = System.nanoTime();
               Node unlockNode = unlock.IDS(lock);
               long end = System.nanoTime();
   
               long diff = end - start;
   
               // Add all of the stuff together
               totalTime += diff;
               totalNodesVisited += unlock.nodeVisits;
               totalLengthOfQueueStack += unlock.queueStackLen;
            }
   
            // Print the information
            long avgTime = totalTime / 5;
            System.out.println("Average Time (ms): " + TimeUnit.NANOSECONDS.toMillis(avgTime));
            System.out.println("Average Time (sec): " + TimeUnit.NANOSECONDS.toSeconds(avgTime));
            System.out.println("Average Node Visits: " + totalNodesVisited / 5);
            System.out.println("Average Length of Queue/Stack: " + totalLengthOfQueueStack / 5);
         }
         catch(OutOfMemoryError e)
         {
            // If the system runs out of memory, let's simply
            // print a statement and then advise the garbage
            // collector that it should run
            System.out.println("Out of Memory");
            System.gc();
         }
      }
   }

   // Test DLS
   public static void testDLS()
   {
      // Run for lengths 1-14
      for(int i = 1; i <= 14; i++)
      {
         long totalTime = 0;
         long totalNodesVisited = 0;
         long totalLengthOfQueueStack = 0;

         System.out.println("--- Length " + i + " ---");

         try
         {
            for (int j = 0; j < 5; j++)
            {
               TheLock lock = new TheLock("Ian" + j, i);
               UnlockTree unlock = new UnlockTree();
               
               // Record the time and unlock the lock
               long start = System.nanoTime();
               Node unlockNode = unlock.DLS(lock, i);
               long end = System.nanoTime();
   
               long diff = end - start;
   
               // Add all of the stuff together
               totalTime += diff;
               totalNodesVisited += unlock.nodeVisits;
               totalLengthOfQueueStack += unlock.queueStackLen;
            }
   
            // Print the information
            long avgTime = totalTime / 5;
            System.out.println("Average Time (ms): " + TimeUnit.NANOSECONDS.toMillis(avgTime));
            System.out.println("Average Time (sec): " + TimeUnit.NANOSECONDS.toSeconds(avgTime));
            System.out.println("Average Node Visits: " + totalNodesVisited / 5);
            System.out.println("Average Length of Queue/Stack: " + totalLengthOfQueueStack / 5);
         }
         catch(OutOfMemoryError e)
         {
            // If the system runs out of memory, let's simply
            // print a statement and then advise the garbage
            // collector that it should run
            System.out.println("Out of Memory");
            System.gc();
         }
      }
   }

   // Test BFS
   public static void testBFS()
   {
      for(int i = 1; i <= 14; i++)
      {
         long totalTime = 0;
         long totalNodesVisited = 0;
         long totalLengthOfQueueStack = 0;

         System.out.println("--- Length " + i + " ---");
         
         try
         {
            for (int j = 0; j < 5; j++)
            {
               TheLock lock = new TheLock("Ian" + j, i);
               UnlockTree unlock = new UnlockTree();
   
               long start = System.nanoTime();
               Node unlockNode = unlock.BFS(lock);
               long end = System.nanoTime();
   
               long diff = end - start;
   
               // Add all of the stuff together
               totalTime += diff;
               totalNodesVisited += unlock.nodeVisits;
               totalLengthOfQueueStack += unlock.queueStackLen;
            }
   
            // Print the information
            long avgTime = totalTime / 5;
            System.out.println("Average Time (ms): " + TimeUnit.NANOSECONDS.toMillis(avgTime));
            System.out.println("Average Time (sec): " + TimeUnit.NANOSECONDS.toSeconds(avgTime));
            System.out.println("Average Node Visits: " + totalNodesVisited / 5);
            System.out.println("Average Length of Queue/Stack: " + totalLengthOfQueueStack / 5);
         }
         catch(OutOfMemoryError e)
         {
            // If the system runs out of memory, let's simply
            // print a statement and then advise the garbage
            // collector that it should run
            System.out.println("Out of Memory");
            System.gc();
         }
      }
   }

   // Test BFS for an arbitrary lengthed lock
   public static void arbBFS()
   {
      try
      {
         TheLock lock = new TheLock("Ian");
         UnlockTree unlock = new UnlockTree();
   
         long start = System.nanoTime();
         Node unlockNode = unlock.BFS(lock);
         long end = System.nanoTime();
   
         long diff = end - start;
   
         // Get all of the information
         long totalTime = diff;
         long totalNodesVisited = unlock.nodeVisits;
         long totalLengthOfQueueStack = unlock.queueStackLen;
   
         // Print the information
         System.out.println("--- Length " + unlockNode.pathLen() + " ---");
         System.out.println("Average Time (ms): " + TimeUnit.NANOSECONDS.toMillis(totalTime));
         System.out.println("Average Time (sec): " + TimeUnit.NANOSECONDS.toSeconds(totalTime));
         System.out.println("Average Node Visits: " + totalNodesVisited);
         System.out.println("Average Length of Queue/Stack: " + totalLengthOfQueueStack);
      }
      catch(OutOfMemoryError e)
      {
         // If the system runs out of memory, let's simply
         // print a statement and then advise the garbage
         // collector that it should run
         System.out.println("Out of Memory");
         System.gc();
      }
   }

   // Test IDS for a lock of arbitrary length
   public static void arbIDS()
   {
      try
      {
         TheLock lock = new TheLock("Ian");
         UnlockTree unlock = new UnlockTree();
   
         long start = System.nanoTime();
         Node unlockNode = unlock.IDS(lock);
         long end = System.nanoTime();
   
         long diff = end - start;
   
         // Get all of the information
         long totalTime = diff;
         long totalNodesVisited = unlock.nodeVisits;
         long totalLengthOfQueueStack = unlock.queueStackLen;
   
         // Print the information
         System.out.println("--- Length " + unlockNode.pathLen() + " ---");
         System.out.println("Average Time (ms): " + TimeUnit.NANOSECONDS.toMillis(totalTime));
         System.out.println("Average Time (sec): " + TimeUnit.NANOSECONDS.toSeconds(totalTime));
         System.out.println("Average Node Visits: " + totalNodesVisited);
         System.out.println("Average Length of Queue/Stack: " + totalLengthOfQueueStack);
      }
      catch(OutOfMemoryError e)
      {
         // If the system runs out of memory, let's simply
         // print a statement and then advise the garbage
         // collector that it should run
         System.out.println("Out of Memory");
         System.gc();
      }
   }

   public static void main(String[] args)
   {  
      // Run all of the tests for length 1-14
      // and output the results for each test

      System.out.println("=== BFS ===");
      testBFS();
      System.out.println();

      System.out.println("=== DLS ===");
      testDLS();
      System.out.println();

      System.out.println("=== IDS ===");
      testIDS();
      System.out.println();

      // Finally run for arbitrary lengths

      System.out.println("=== Arbitrary BFS ===");
      arbBFS();
      System.out.println();

      System.out.println("=== Arbitrary IDS ===");
      arbIDS();
      System.out.println();

   }
}