/*
   This is the main class for unlocking the lock.
   This holds all of the alogrithms for unlocking and carries
   them out in the proper way.
*/

public class UnlockTree
{

   static final int TWIST = 0;
   static final int POKE = 1;
   static final int PULL = 2;
   static final int SHAKE = 3;

   // Package accessible attributes for getting information
   long nodeVisits = 0;
   int queueStackLen = 0;
   
   public UnlockTree() {}
   
   // Performs an action using a switch statement to help on code
   private void performAction(TheLock lock, int action)
   {
      switch(action)
      {
         case TWIST:
            lock.twistIt();
            break;
         case POKE:
            lock.pokeIt();
            break;
         case PULL:
            lock.pullIt();
            break;
         case SHAKE:
            lock.shakeIt();
            break;
      }
   }
   
   // Tests the path of a node to see if it unlocks the lock
   private boolean testPath(TheLock lock, Node n)
   {
      // Reset the lock for good measure
      lock.resetLock();
      
      // Perform the action in sequence
      while(n != null)
      {
         performAction(lock, n.action);
         n = n.parent;
      }
      
      return lock.isUnlocked();
   }

   // Iterative Deepening Search
   public Node IDS(TheLock lock)
   {
      // While the lock is not solved,
      // keep trying incremetally longer combinations
      int testLength = 1;
      Node foundNode = DLS(lock, testLength);
      
      // While we don't have a solution
      while(foundNode == null)
      {
         testLength++;
         foundNode = DLS(lock, testLength);
      }

      return foundNode;
   }
   
   // Depth limited search will search for the lock's solution but only up to
   // a specified depth.
   // This has a great chance of returning null in case the maxDepth is not
   // deep enough.
   public Node DLS(TheLock lock, int maxDepth)
   {
      // Let's do depth first search but stop
      // once we hit the maxDepth
      int depth = 0;
      NodeStack stack = new NodeStack();
      for(int i = 0; i < 4; i++) stack.insert(new Node(i));

      // Keep running while there is something on the stack
      while(! stack.isEmpty())
      {
         nodeVisits++;
         Node testNode = stack.pop();
         depth = testNode.depth;
         
         // If we have found a solution, let's stop and return the node
         if(testPath(lock, testNode))
         {
            queueStackLen = stack.length();
            return testNode;
         }

         // Only add children if the depth has not been reached
         if(depth < maxDepth)
            for(int i = 0; i < 4; i++) stack.insert(new Node(i, testNode, depth + 1));
      }

      // Return null if nothing is found
      return null;
   }
   
   // Breadth First Search
   public Node BFS(TheLock lock)
   {
      // Create a queue
      NodeQueue queue = new NodeQueue();
      
      // Add children to the queue
      for(int i = 0; i < 4; i++) queue.insert(new Node(i));
      
      // Keep running while there is something on the queue
      while(! queue.isEmpty())
      {
         nodeVisits++;
         Node testNode = queue.pop();
         
         // If we find a solution, stop running and return the node
         if(testPath(lock, testNode))
         {
            queueStackLen = queue.length();
            return testNode;
         }
         
         // Add children for the current node
         for(int i = 0; i < 4; i++) queue.insert(new Node(i, testNode));
      }
      
      // If something breaks, lets return null
      return null;
   }

}

/*
   The Node class is what we will use for the
   nodes in our tree. These will store information
   and keep the tree in running order.
*/

class Node
{
   int action;
   Node parent = null;
   int depth = 1;
   
   // Three different constructors for any use
   // we may need them for
   public Node(int action)
   {
      this.action = action;
   }
   
   public Node(int action, Node parent)
   {
      this.action = action;
      this.parent = parent;
   }

   public Node(int action, Node parent, int depth)
   {
      this.action = action;
      this.parent = parent;
      this.depth = depth;
   }
   
   // Get the length of the path of the
   // solution.
   // This simply counts the number of parents
   // plus itself.
   public int pathLen()
   {
      Node n = parent;
      int pathLen = 1;
      while(n != null)
      {
         pathLen++;
         n = n.parent;
      }
      
      return pathLen;
   }
}
