import java.util.Random;

public class CheckHeap
{
   public static boolean isMinHeap(float[] array)
   {
      return isMinHeap(array, 0);
   }
   
   public static boolean isMinHeap(float[] array, int i)
   {
      boolean isMinHeap = false;
      
      if(array.length >= (i * 2) + 2 && array[(i * 2) + 1] >= array[i]) isMinHeap = isMinHeap(array, (i * 2) + 1);
      else if(array.length < (i * 2) + 2) isMinHeap = true;
      else return false;
      
      if(array.length >= (i * 2) + 3 && array[(i * 2) + 2] >= array[i]) isMinHeap = isMinHeap(array, (i * 2) + 2);
      else if(array.length < (i * 2) + 3) isMinHeap = true;
      else return false;
      
      return isMinHeap;
   }
   
   public static boolean isMaxHeap(float[] array)
   {
      return isMaxHeap(array, 0);
   }
   
   public static boolean isMaxHeap(float[] array, int i)
   {
      boolean isMaxHeap = false;
      
      if(array.length >= (i * 2) + 2 && array[(i * 2) + 1] <= array[i]) isMaxHeap = isMaxHeap(array, (i * 2) + 1);
      else if(array.length < (i * 2) + 2) isMaxHeap = true;
      else return false;
      
      if(array.length >= (i * 2) + 3 && array[(i * 2) + 2] <= array[i]) isMaxHeap = isMaxHeap(array, (i * 2) + 2);
      else if(array.length < (i * 2) + 3) isMaxHeap = true;
      else return false;
      
      return isMaxHeap;
   }
   
   public static float[] generateMinHeapArray()
   {
      Random rand = new Random();
      int randomIndex = rand.nextInt(600) + 500;
      
      float[] newArray = new float[randomIndex];
      int i = 0;
      
      while(i < randomIndex)
      {
         int randomInt = rand.nextInt();
         if(i == 0)
         {
            newArray[0] = randomInt;
            i++;
         }
         else if(randomInt >= newArray[(i-1) / 2])
         {
            newArray[i] = randomInt;
            i++;
         }
      }
      
      return newArray;
   }
   
   public static float[] generateMaxHeapArray()
   {
      Random rand = new Random();
      int randomIndex = rand.nextInt(600) + 500;
      
      float[] newArray = new float[randomIndex];
      int i = 0;
      
      while(i < randomIndex)
      {
         int randomInt = rand.nextInt();
         if(i == 0)
         {
            newArray[0] = randomInt;
            i++;
         }
         else if(randomInt <= newArray[(i-1) / 2])
         {
            newArray[i] = randomInt;
            i++;
         }
      }
      
      return newArray;
   }
   
   public static void minHeapify(float[] array)
   {
      float[] newArray = new float[array.length];
      
      for(int i = 0; i < array.length; i++)
      {
         if(i == 0) newArray[0] = array[0];
         else insertIntoNewArray(array, newArray, i);
      }
      
      for(int i = 0; i < array.length; i++) array[i] = newArray[i];
   }
   
   public static void insertIntoNewArray(float[] oldArray, float[] newArray, int i)
   {
      boolean isFinished = false;
      
      while(! isFinished)
      {
         if(newArray[(i - 1) / 2] <= oldArray[i])
         {
            newArray[i] = oldArray[i];
            isFinished = true;
         }
         else
         {
            float temp = newArray[(i - 1) / 2];
            newArray[(i - 1) / 2] = oldArray[i];
            newArray[i] = temp;
            i = (i - 1) / 2;
         }
      }
   }

   public static void main(String[] args)
   {
      float[] myArray = generateMaxHeapArray();
      minHeapify(myArray);
      boolean isMinHeap;
      
      do
      {
         isMinHeap = isMinHeap(myArray);
         System.out.println(isMinHeap);
         myArray = generateMaxHeapArray();
         minHeapify(myArray);
      } while(isMinHeap);

   }
}