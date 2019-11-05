public class IntList
{
   private int[] array;
   private int maxSize;
   private int currentSize;
   
   public IntList(int maxSize)
   {
      array = new int[maxSize];
      currentSize = 0;
      this.maxSize = maxSize;
   }
   
   public boolean append(int num)
   {
      if(currentSize == maxSize)
         return false;
      
      array[currentSize] = num;
      currentSize++;
      
      return true;
   }
   
   private int[] getArray()
   {
      return array;
   }
   
   public int getSize()
   {
      return currentSize;
   }
   
   public boolean concat(IntList that)
   {
      int[] thatArray = that.getArray();
      int thatLength = that.getSize();
      int endLength = thatLength + currentSize;
      
      if(endLength > maxSize)
         return false;
      
      for(int i = currentSize; i < endLength; i++)
      {
         array[i] = thatArray[i - currentSize];
      }
      
      currentSize = endLength;
      return true;
   }
   
   public String toString()
   {
      String returnString = "{";
      for(int i = 0; i < currentSize; i++)
      {
         returnString += array[i];
         
         if(i != currentSize - 1)
            returnString += ", ";
      }
      
      returnString += "}";
      
      return returnString;
   }
}