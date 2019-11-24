public class TestHeap
{

    public static FloatMaxHeap generateRandomHeap() throws HeapOverFlowException
    {
        float[] array = CheckHeap.generateMinHeapArray();
        FloatMaxHeap myHeap = new FloatMaxHeap(array.length);

        for(float val : array) myHeap.insert(val);

        return myHeap;
    }

    public static void main(String[] args) throws HeapOverFlowException
    {
        while(true)
        {
            FloatMaxHeap randHeap = generateRandomHeap();
            System.out.println(CheckHeap.isMaxHeap(randHeap.array));
        }
    }
}
