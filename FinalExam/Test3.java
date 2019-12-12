public class Test3
{
    // #6, Double Link List
    public int popMax()
    {
        if(dummy.next == dummy) return Integer.MIN_VALUE;

        int maxVal = dummy.next.val;
        Node largestNode = dummy.next;
        int nextCheck = dummy.next;

        while(nextCheck != dummy)
        {
            if(nextCheck.val > maxVal)
            {
                maxVal = nextCheck.val;
                largestNode = nextCheck;
            }
            nextCheck = nextCheck.next;
        }

        Node temp = largestNode.prev;
        largestNode.prev.next = largestNode.next;
        largestNode.next.prev = temp;

        return maxVal;
    }

    // #7, Binary Search Tree
    // Let's use a counter for recursion
    class Counter
    {
        int val = 0;
        Counter() {}
    }

    public float averageLeafDepth()
    {
        if(root == null) return 0;
        if(root.left == null && root.right == null) return 1;
        Counter leafCounter = new Counter();
        Counter depthCounter = new Counter();
        float depth = LeafDepth(root, leafCounter, depthCounter);

        return depth / (float) leafCounter.val;
    }

    public float LeafDepth(Node n, Counter leafCount, Count depthCount)
    {
        if(n.left == null && n.right == null) leafCount.val++;

        int dep = 0;

        if(n.left != null)
        {
            depthCount.val++;
            dep = LeafDepth(n.left, leafCount, depthCount);
        }

        depthCount.val--;

        if(n.right != null)
        {
            depthCount.val++;
            dep += averageLeafDepth(n.right, leafCount, depthCount);
        }

        return (float) dep;
    }

    // #8, MinHeap
    public void halfMax()
    {
        // Let's find the depth of the heap
        int depth = (int) Math.log(size) / Math.log(2);
        // Now let's see how many nodes we should check since the greatest values
        // will be at the bottom of the heap
        int checkNodes = (int) Math.pow(2, depth);

        // Now find the max value
        int i = size - 1;
        int maxI = 0;
        for(int j = 0; j < checkNodes; j++)
        {
            if(array[i] > array[maxI]) maxI = i;
            i--;
        }

        array[maxI] = array[maxI] / 2;
        reheapifyUp(maxI);
    }

    public void reheapifyUp(int i)
    {
        if(i != 0 && array[i] < array[(i - 1) / 2])
        {
            swap(i, (i - 1) / 2);
            reheapifyUp((i - 1) / 2);
        }
    }

    public void swap(int i, int j)
    {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}