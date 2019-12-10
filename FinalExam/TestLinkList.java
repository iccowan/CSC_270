public class TestLinkList
{
    public static void main(String[] args)
    {
        LinkList<Integer> myList = new LinkList<Integer>();

        for(int i = 0; i < 10; i++) myList.append(i);
        System.out.println(myList);
        myList.reverse();
        System.out.println(myList);
    }
}