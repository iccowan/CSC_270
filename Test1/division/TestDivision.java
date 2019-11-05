// TestDivision
public class TestDivision
{
    public static void main(String[] args)
    {
        assert Division.divide(1, 2) == 0.5 : "Dividing 1/2 should return 0.5, not " + Division.divide(1, 2);
        assert Division.divide(2, 1) == 2.0 : "Dividing 2/1 should return 2.0, not " + Division.divide(2, 1);
    }
}