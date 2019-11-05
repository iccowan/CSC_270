// TestFillErUp

public class TestFillErUp
{
    public static int[] getCorrectArray(int len)
    {
        int n1 = 1;
        int n2 = 1;

        if(len == 1)
        {
            int[] array = {1};
            return array;
        }
        else if(len == 2)
        {
            int[] array = {1, 1};
            return array;
        }

        int[] returnArray = new int[len + 1];
        returnArray[0] = 1;
        returnArray[1] = 1;
        for(int i = 2; i <= len; i++)
        {
            int newVal = n1 + n2;
            returnArray[i] = newVal;
            if(i % 2 == 0)
            {
                n1 = newVal;
            }
            else
            {
                n2 = newVal;
            }
        }

        return returnArray;
    }

    public static void main(String[] args)
    {
        for(int i = 1; i < 20; i++)
        {
            int[] myArray = new int[i];
            int[] correctArray = getCorrectArray(i);

            for(int j : correctArray)
            {
                System.out.print(j + ",");
            }
            System.out.println();
        }
    }
}