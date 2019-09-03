public class Exercises
{

/**This function will return the sum of the squares from 1 to n.
* For instance if the number is 5, the solution would be 1*1+2*2+3*3+4*4+5*5= 55. 
* If the value of n is less than 0, return -1
*/
   public static int squares(int n)
   {
      // Init variables
      int total = 0;
      
      // Check if n is less than 0
      if (n < 0)
         total = -1;
         
      // Loop through each number starting at 1
      // Will not run if n is less than 0
      for (int i = 1; i <= n; i++)
      {
         total += i * i;
      }
      
      return total;
   }

/**
* This function that takes an array of integers and
* an integer that describes how many numbers are in the array.  
* The function will return the index(position) in the array with the largest number.
* If the array is empty or there is an error, return -1.
* If the maximum value is not unique, return the index of the first maximuim value.
*/
   public static int maxIndex(int array[], int len)
   {
      // Init variables
      int maxIndex = -1;
      int maxValue = 0;
      
      // Make sure the array is not empty
      if (len > 0)
      {
         // Loop through the array and find the max value
         for (int i = 0; i < len; i++)
         {
            if (array[i] > maxValue)
            {
               maxValue = array[i];
               maxIndex = i;
            }
         }
      }
      
      return maxIndex;
   }

/**
* This function that takes an array of integers, 
* an integer that describes how many numbers are in the array.  
* and a target number to look for.
* This function will return true if the target number is within the array and false otherwise.
*/
   public static boolean seek(int array[], int len, int target)
   {
      // Init variables
      boolean inArray = false;
      
      // Loop through array and see if the given target is within the array
      for (int i = 0; i < len; i++)
      {
         if (array[i] == target)
            inArray = true;
      }
      
      return inArray;
   }



/**
* This function takes an integer parameter and returns the nth number in the Fibonacci 
* sequence.  The first 6 numbers of the sequence are as follows.  1,1,2,3,5,8.  Note
* that 8 is the 6th number.  Be sure that your algorithm can return the
* first and second Fibonacci numbers correctly.  You should solve this without recursion. 
* If the input is below 1, retun 0;
*/
   public static int fib(int n)
   {
      // Init variables
      int n0 = 1;
      int n1 = 1;
      int nn = 0;
      
      // Check for 1 or 2
      if (n < 1)
      {
         nn = 0;
      }
      else if (n == 1 || n == 2)
      {
         nn = 1;
      }
      else
      {
         // Run through the Fibonacci sequence
         for (int i = 3; i <= n; i++)
         {
            // Add the previous two numbers together
            nn = n0 + n1;
            
            // Decide which n (n0 or n1) to change
            if (i % 2 == 0)
            {
               n0 = nn;
            }
            else
            {
               n1 = nn;
            }
         }
      }
      
      return nn;
   }




   private static void testSquares()
   {
      assert squares(5)==55:"square 5 should be 55 not "+squares(5);
      assert squares(1)==1:"square 1 should be 1 not "+squares(1);
      assert squares(0)==0:"square 0 should be 0 not "+squares(0);
      assert squares(-10)== -1:"square -10 should be -1 not "+squares(-10);
      assert squares(-1)== -1:"square -1 should be -1 not "+squares(-1);
   
   
   }

   private static void testMaxIndex()
   {
   //Use at least 3 to check
      int [] one = {10,20,30,30};
      assert maxIndex(one,4)==2:"max Index should have been 2 not "+maxIndex(one,3);
   
      int [] two = {10,30,20};
      assert maxIndex(two,3)==1:"max Index should have been 1 not "+maxIndex(two,3);
   
      int [] three = {30,10,20};
      assert maxIndex(three,3)==0:"max Index should have been 0 not "+maxIndex(three,3);
   
   
      assert maxIndex(null,0)==-1:"max Index should have been -1 not "+maxIndex(null,0);
      
      //use a trick to reuse other arrays
      assert maxIndex(one,2)==1:"max Index should have been 1 not "+maxIndex(one,2);
   
   
      int []  five = {30,10};
      assert maxIndex(five,2)==0:"max Index should have been 0 not "+maxIndex(five,2);
   
      assert maxIndex(one,1)==0:"max Index should have been 0 not "+maxIndex(one,1);
   
   
      assert maxIndex(one,4)==2:"max Index should have been 2 not "+maxIndex(one,4);
   
   
   }
   
   public static void testSeek()
   {
      int [] one = {1,2,3,4,5};
      
      assert seek(one,5,1) : "should have found 1";
      assert seek(one,5,5) : "should have found 5";
      assert seek(one,5,3) : "should have found 3";
      assert ! seek(one,5,-10) : "should not have found -10";
   
      assert ! seek(one,0,1) : "should not have found 1";
   
   
   }




   public static void testFib()
   {
      assert fib(6)==8: "fib 6 should be 8 not "+fib(6);
      assert fib(3)==2: "fib 3 should be 2 not "+fib(3);
      assert fib(1)==1: "fib 1 should be 1 not "+fib(1);
      assert fib(9)==34: "fib 9 should be 34 not "+fib(9);
      assert fib(-1)==-0: "fib -1 should be 0 not "+fib(-1);
   
   
   }



   public static void main(String [] args)
   {
   
      testSquares();
      testFib();
      testMaxIndex();
      testSeek();
      
      
      System.out.println("It all works!");
   
   }



}
