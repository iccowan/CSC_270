import java.util.LinkedList;
import java.util.List;

/*
   Stack for out depth limited search.
   This will extend the queue we've already
   written and will simply insert into
   a different location than the queue.
*/

public class NodeStack extends NodeQueue
{
   // Insert into the stack. Since this is a stack,
   // we want to insert at the beginning rather
   // than the end (LIFO) to preserve the stack format.
   @Override
   public void insert(Node n) { nodes.add(0, n); }
}