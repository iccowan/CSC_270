import java.util.Comparator;

public class PriorityQueue<T> extends Queue<T>
{
   private Comparator<T> compare;

   public PriorityQueue(Comparator<T> comp)
   {
      compare = comp;
   }

   @Override // parent push()
   public void push(T val)
   {
      // Create a node with the value
      Node<T> newNode = new Node<T>(val);
      
      // Let's make sure the queue isn't empty
      if(isEmpty())
      {
         // If it is, set the front and back to the new node
         front = newNode;
         back = newNode;
      }
      // First, let's check and see if the value is greater than the front
      else if(compare.compare(val, (T) front.getValue()) == 1 || compare.compare(val, (T) front.getValue()) == 0)
      {
         // Then replace the front with the value
         newNode.setNext(front);
         front = newNode;
      }
      // Now, check to see if the value is less than the back
      else if(compare.compare(val, (T) back.getValue()) == -1 || compare.compare(val, (T) back.getValue()) == 0)
      {
         // Then replace the back with the value
         back.setNext(newNode);
         back = newNode;
      }
      // Finally, we must loop for any other case
      else
      {
         // We can skip the front since we already checked this and this is necessary
         // so we can update the previous node
         Node<T> nextCheck = front.getNext();
         Node<T> previous = front;
         
         // Loop until we get to the back
         while(nextCheck != null)
         {
            // Loop through and if the value of the node in the queue is less than our new value,
            // insert the new node directly before that value
            if(compare.compare(val, (T) nextCheck.getValue()) == 1 || compare.compare(val, (T) nextCheck.getValue()) == 0)
            {
               // Insert into the queue in the appropiate place
               newNode.setNext(nextCheck);
               previous.setNext(newNode);
               
               // Break to prevent the node from being added in more places
               break;
            }
            
            // Prevent an infinite loop
            nextCheck = nextCheck.getNext();
            previous = previous.getNext();
         }
      }
   }
}
