public class FloatMaxHeap
{

   int size = 0;
   int maxSize;
   float[] array;

   public FloatMaxHeap(int size)
   {
      maxSize = size;
      array = new float[size];
   }

   public void insert(float val) throws HeapOverFlowException
   {
      if(isFull()) throw new HeapOverFlowException();
      insert(val, 0);
   }
   private void insert(float val, int i)
   {
      array[i] = val;

      while(array[(i - 1) / 2] < val)
      {
         array[i] = array[(i - 1) / 2];
         array[(i - 1) / 2] = val;
         i = (i - 1) / 2;
      }
   }

   public void removeVal(float val)
   {
      // Loop through and find the value
      // if the value cannot be found, end the method
      for(int i = 0; i < size; i++)
      {
         if(array[i] == val)
         {
            array[i] = array[size - 1];

            // Heapify
            heapifyArray(i);
            break;
         }
      }
   }

   private void heapifyArray(int i)
   {
      // Bubble down if necessary
      if(array[i] < array[(2 * i) + 1])
      {
          
      }
   }

   public boolean isFull() { return size == array.length; }

   public static void main(String[] args) throws HeapOverFlowException
   {
      FloatMaxHeap myHeap = new FloatMaxHeap(5);
      myHeap.insert(5);
      myHeap.insert(2);
      myHeap.insert(10);
      myHeap.insert(11);
      myHeap.insert(25);

      try { myHeap.insert(21); }
      catch(HeapOverFlowException e) { /* Should error, do nothing */ }

      myHeap.removeVal(2);
      myHeap.removeVal(25);

      System.out.println(CheckHeap.isMaxHeap(myHeap.array));
   }

}

class HeapOverFlowException extends Exception
{
   public HeapOverFlowException() { super(); }
   public HeapOverFlowException(String string) { super(string); }
}
