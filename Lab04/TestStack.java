// TestStack

public class TestStack
{
   public static void main(String[] args)
   {
      // Create a new stack
      IntStack myStack = new IntStack();
      
      // Make sure methods work properly on the new stack
      try
      {
         myStack.top();
         assert false : "Method top() should throw StackUnderFlowException on empty stack";
      }
      catch(StackUnderFlowException e)
      {
         assert true;
      }
      
      try
      {
         myStack.pop();
         assert false : "Method pop() should throw StackUnderFlowException on empty stack";
      }
      catch(StackUnderFlowException e)
      {
         assert true;
      }
      
      assert myStack.isEmpty() : "Method isEmpty() should return true on empty stack";
      
      // Push something to the stack
      myStack.push(2);
      myStack.push(4);
      myStack.push(8);
      
      // Make sure everything pushed correctly
      assert myStack.top() == 8 : "Method top() should return 8 not " + myStack.top();
      assert (! myStack.isEmpty()) : "Method isEmpty() should return false on a nonempty stack";
      
      // Now test popping
      myStack.pop();
      assert myStack.top() == 4 : "Method top() should return 4 not " + myStack.top();
      assert (! myStack.isEmpty()) : "Method isEmpty() should return false on a nonempty stack";
      myStack.pop();
      assert myStack.top() == 2 : "Method top() should return 4 not " + myStack.top();
      assert (! myStack.isEmpty()) : "Method isEmpty() should return false on a nonempty stack";
      myStack.pop();
      try
      {
         myStack.top();
         assert false : "Method top() should throw StackUnderFlowException on empty stack";
      }
      catch(StackUnderFlowException e)
      {
         assert true;
      }
      
      try
      {
         myStack.pop();
         assert false : "Method pop() should throw StackUnderFlowException on empty stack";
      }
      catch(StackUnderFlowException e)
      {
         assert true;
      }
      assert myStack.isEmpty() : "Method isEmpty() should return true on an empty stack";
   }
}