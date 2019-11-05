// MaxOfThree

public class MaxOfThree
{
    public static int largest(int a, int b, int c)
    {
        if(a > b && a > c)
        {
            return a;
        }
        else if(b > a && b > c)
        {
            return b;
        }
        else
        {
            return c;
        }
    }
}