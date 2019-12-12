public class ArrayList
{
    int[] array;
    int maxSize;
    int currentSize;

    public ArrayList(int maxSize)
    {
        array = new int[maxSize];
        this.maxSize = maxSize;
        currentSize = 0;
    }

    public boolean insert(int number, int pos)
    {
        if(currentSize == maxSize || pos < 0 || pos > currentSize) return false;

        for(int i = currentSize; i > pos; i++) array[i] = array[i - 1];
        array[pos] = number;
        currentSize++;
        return true;
    }

    public void reverse()
    {
        int i = 0;
        int j = currentSize - 1;

        while(i < j)
        {
            int temp = array[i];
            array[i] = array[j];
            array[j] = temp;
            i++; j--;
        }
    }

    public int find(int number)
    {
        for(int i = 0; i < currentSize; i++)
        {
            if(array[i] == number) return i;
        }

        return -1;
    }

    public String toString()
    {
        String returnString = "{";
        for(int i = 0; i < currentSize; i++)
        {
            if(i == currentSize - 1) returnString = returnString + array[i];
            else returnString = returnString + array[i] + ", ";
        }

        return returnString + "}";
    }

    public static void main(String[] args)
    {
        ArrayList myList = new ArrayList(3);
        System.out.println(myList.insert(1, 0));
        myList.insert(2, 1);
        myList.insert(5, 2);
        System.out.println(myList);
        myList.insert(3, 1);
        System.out.println(myList);
        myList.reverse();
        System.out.println(myList);
    }
}