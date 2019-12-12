public class BloomFilter
{
    private int[] array;
    int size;

    public BloomFilter(int size)
    {
        array = new int[size];
        this.size = size;

        for(int i = 0; i < size; i++) array[i] = 0;
    }

    public void insert(String string)
    {
        int[] hashCodes = hashCodes(string);
        for(int i = 0; i < hashCodes.length; i++) array[hashCodes[i]] = 1;
    }

    public boolean hasSeen(String string)
    {
        int[] hashCodes = hashCodes(string);
        boolean inFilter = true;

        for(int i = 0; i < hashCodes.length; i++)
            if(array[hashCodes[i]] == 0)
                inFilter = false;

        return inFilter;
    }

    private int[] hashCodes(String string)
    {
        int[] hashCodes = new int[3];
        hashCodes[0] = hash1(string);
        hashCodes[1] = hash2(string);
        hashCodes[2] = hash3(string);

        return hashCodes;
    }

    private int hash1(String string) { return Math.abs(string.hashCode()) % size; }
    private int hash2(String string) { return Math.abs((string.hashCode() * 31 / 27 * 3)) % size; }
    private int hash3(String string) { return Math.abs((string.hashCode() * 57 / 31 / 7 * 23)) % size; }
}