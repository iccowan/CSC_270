// Simple Hash Table with String as key

@SuppressWarnings("unchecked")

public class StringHashTable<T>
{
    private Node[] array = new Node[5];
    int size = 0;
    int maxSize = 5;

    public StringHashTable() {}

    public void insert(String string, T object)
    {
        int i = getHash(string, 0);
        int collisions = 0;
        while(array[i] != null)
        {
            collisions++;
            i = getHash(string, collisions);
        }

        array[i] = new Node<T>(string, object);
        size++;

        // Now, let's see if we need to expand
        if((float) size / (float) maxSize >= 0.75)
        {
            new Thread(new ExpandArray(this)).run();
        }
    }

    public void remove(String string)
    {
        int i = getHash(string, 0);
        int collisions = 0;
        while(array[i].val != string)
        {
            collisions++;
            i = getHash(string, collisions);
        }

        array[i].isDeleted = true;
    }

    public boolean contains(String string)
    {
        int i = getHash(string, 0);
        int collisions = 0;
        while(array[i] != null)
        {
            if(! array[i].isDeleted)
                if(array[i].val.equals(string))
                    return true;
            collisions++;
            i = getHash(string, collisions);
        }

        return false;
    }

    public T get(String string)
    {
        int i = getHash(string, 0);
        int collisions = 0;
        while(array[i] != null)
        {
            if(! array[i].isDeleted)
                if(array[i].val.equals(string))
                    return (T) array[i].object;
            collisions++;
            i = getHash(string, collisions);
        }

        return null;
    }

    protected void expand()
    {
        int newSize = findNextPrime(maxSize * 2);
        int oldSize = maxSize;
        maxSize = newSize;
        Node[] newArray = new Node[newSize];
        size = 0;

        for(int i = 0; i < oldSize; i++)
        {
            if(array[i] != null && (! array[i].isDeleted))
            {
                int j = getHash(array[i].val, 0);
                int collisions = 0;
                while(newArray[j] != null)
                {
                    collisions++;
                    j = getHash(array[i].val, collisions);
                }
                newArray[j] = array[i];
                size++;
            }
        }
        array = newArray;
        System.gc();
    }

    private int findNextPrime(int i)
    {
        boolean isPrime = false;
        while(! isPrime)
        {
            i++;
            boolean thisIsPrime = true;
            for(int j = 2; j < i; j++)
                if(i % j == 0) thisIsPrime = false;

            isPrime = thisIsPrime;
        }

        return i;
    }

    private int getHash(String string, int collisions) { return Math.abs(string.hashCode() + collisions) % maxSize; }

}

class Node<T>
{
    String val;
    T object;
    boolean isDeleted = false;

    Node(String val, T object)
    {
        this.val = val;
        this.object = object;
    }
}

class ExpandArray implements Runnable
{
    StringHashTable hashTable;

    public ExpandArray(StringHashTable hashTable)
    {
        this.hashTable = hashTable;
    }

    public void run()
    {
        hashTable.expand();
    }
}