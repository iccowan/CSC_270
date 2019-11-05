// TestDivByThree

public class TestDivByThree
{
    public static void main(String[] args)
    {
        int[] array1 = {3, 6, 9};
        int[] array2 = {4, 6, 9, 10};
        assert DivByThree.isDivisible(array1, 3) == 1 : "DivByThree.isDivisible({3, 6, 9}, 3) should return 1 not 0";
        assert DivByThree.isDivisible(array2, 4) == 0 : "DivByThree.isDivisible({4, 6, 9, 10}, 4) should return 0 not 1";
    }
}