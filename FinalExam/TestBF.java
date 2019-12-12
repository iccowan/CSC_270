public class TestBF
{
    public static void main(String[] args)
    {
        BloomFilter myFilter = new BloomFilter(1000);
        myFilter.insert("Newcomb");
        myFilter.insert("Ian");
        myFilter.insert("Owen");
        myFilter.insert("Katharine");

        System.out.println(myFilter.hasSeen("Thomas"));
        System.out.println(myFilter.hasSeen("Katharine"));
    }
}