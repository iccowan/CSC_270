// DivByThree

public class DivByThree
{
    public static int isDivisible(int[] array, int leng)
    {
        int divisible = 1;
        for(int i = 0; i < leng; i++)
        {
            if(array[i] % 3 != 0)
            {
                divisible = 0;
            }
        }

        return divisible;
    }
}