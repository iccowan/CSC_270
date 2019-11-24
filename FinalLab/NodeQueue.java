import java.util.LinkedList;
import java.util.List;

/*
   This is the queue that we will use for
   our breadth first search. Our stack will
   extend this so we should make sure most of
   the methods can be used for both a queue
   and a stack.
   
   We will use java's linked list for this so that
   we know we will be using the most efficient data
   structure for the queue to best preserve memory.
*/

public class NodeQueue
{
   protected List<Node> nodes = new LinkedList<Node>();
   
   public NodeQueue() {}
   
   // Inserts at the end of of the list
   public void insert(Node n) { nodes.add(n); }
   
   // We always pop from the beginning of the list
   public Node pop()
   {
      Node popNode = nodes.get(0);
      nodes.remove(0);
      return popNode;
   }

   // Gets the length of the queue
   public int length() { return nodes.size(); }
   
   // Checks to see if the queue is empty
   public boolean isEmpty() { return nodes.isEmpty(); }
}