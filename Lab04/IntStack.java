
public class IntStack
{
   private Node head = null;
   
   public IntStack()
   {
      //
   }

   //pushes val onto the stack
   public void push(int val)
   {
      // Create the new node
      Node newNode = new Node(val, head);
      
      // Sets the new node as the new head
      head = newNode;
   }

   //returns the top element from the stack
   //If the stack is empty, it will throw a StackUnderFlowException.
   public int top() throws StackUnderFlowException
   {
      // If the stack is empty, throw an exception
      if(head == null)
      {
         throw new StackUnderFlowException("Cannot get the top of an empty stack.");
      }
      
      // Return the value of the head Node
      return head.getData();
   }


    //returns the top element from the stack
    //removes the top element from the stack
    //If the stack is empty, it will throw a StackUnderFlowException.
   public int pop() throws StackUnderFlowException
   {
      // If the stack is empty, throw an exception
      if(head == null)
      {
         throw new StackUnderFlowException("Cannot pop an empty stack.");
      }
      
      // Temp store the new head and disconnect the current head from the rest of the world
      Node newTop = head.getNext();
      head.removeNext();
      int val = head.getData();
      head = newTop;
      
      return val;
   }
   
    //reports if the stack is empty
   public boolean isEmpty()
   {
       // Return true if head is null, false if anything else
       if(head == null)
       {
         return true;
       }
       else
       {
         return false;
       }
   }
}

class Node
{
   // Attributes
   private int data;
   private Node next;
   
   // Constructor without a next node
   public Node(int d, Node n)
   {
      data = d;
      next = n;
   }
   
   // Get the Node's data
   public int getData()
   {
      return data;
   }
   
   // Get the next Node in the sequence
   public Node getNext()
   {
      return next;
   }
   
   // Remove links to another Node
   public void removeNext()
   {
      next = null;
   }
}
