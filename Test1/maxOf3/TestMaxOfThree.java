// TestMaxOfThree

public class TestMaxOfThree
{
    public static void main(String[] args)
    {
        assert MaxOfThree.largest(1, 2, 3) == 3 : "The max of (1, 2, 3) is 3 not " + MaxOfThree.largest(1, 2, 3);
        assert MaxOfThree.largest(5, 10, 4) == 10: "The max of (5, 10, 4) is 10 not " + MaxOfThree.largest(5, 10, 4);
    }
}