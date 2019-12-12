public class TestHashTable
{
    public static void main(String[] args)
    {
        StringHashTable<Integer> myTable = new StringHashTable<Integer>();
        myTable.insert("Ian", 1);
        myTable.insert("Newcomb", 100);
        myTable.insert("Katharine", 1);
        myTable.insert("Thomas", 1);
        myTable.insert("Arpit", 1);

        System.out.println(myTable.contains("Newcomb"));
        System.out.println(myTable.get("Newcomb"));
    }
}