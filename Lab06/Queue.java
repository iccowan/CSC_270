public class Queue<T>
{
   protected Node<T> front = null;
   protected Node<T> back = null;

   public Queue()
   {
      //
   }


    /**Adds val to the end of the queue
     */
   public void push(T val)
   {
      // Create a new node
      Node<T> newNode = new Node<T>(val);
      
      // Set the back of the queue to the newNode
      // Only do this if the queue is not empty
      if(isEmpty())
      {
         front = newNode;
         back = newNode;
      }
      else
      {
         back.setNext(newNode);
         back = newNode;
      }
   }


    /**
       removes and returns the oldest value in the queue
       throws QueueUnderFlowException if the queue is empty
     */
   public T pop() throws QueueUnderFlowException
   {
      // If the queue is empty, throw an underflow exception
      if(isEmpty())
      {
         throw new QueueUnderFlowException("Cannot pop from empty queue");
      }
      
      // Get the value of the front of the queue
      T returnVal = front.getValue();
      
      // Now, set the front of the queue to the next Node
      // And remove the current front completely
      Node<T> oldFront = front;
      front = front.getNext();
      oldFront.setNext(null);
      
      return returnVal;
   }    


    /**
      returns true if the queue is empty
     */

   public boolean isEmpty()
   {
      if(front == null)
      {
         return true;
      }
      else
      {
         return false;
      }
   }
}

// Node for the links
class Node<T>
{
   private T val;
   private Node<T> next = null;
   
   // Constructor
   public Node(T val)
   {
      this.val = val;
   }
   
   // Get the next node
   public Node<T> getNext()
   {
      return next;
   }
   
   // Set the next node
   public void setNext(Node<T> n)
   {
      next = n;
   }
   
   // Get the value of the node
   public T getValue()
   {
      return val;
   }
}
