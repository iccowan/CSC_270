public class Stack
{
    class Node
    {
        int val;
        Node next;

        Node(int val)
        {
            this.val = val;
        }
    }

    class PopException extends Exception
    {
        PopException() { super(); }
        PopException(String message) { super(message); }
    }

    private Node front = null;
    private Node back = null;
    private int size = 0;

    public Stack() {}

    public void push(int val) // 0(1) time
    {
        Node newNode = new Node(val);

        if(isEmpty())
        {
            front = newNode;
            back = newNode;
        }
        else
        {
            newNode.next = front;
            front = newNode;
        }

        size++;
    }

    public int doublePop() throws PopException // 0(1) time
    {
        if(isEmpty() || front.next == null) throw new PopException();
        size -= 2;

        int val1 = front.val;
        int val2 = front.next.val;
        front = front.next.next;
        if(front == null) back = null;

        return val1 + val2;
    }

    public int sum() // 0(n) time
    {
        int total = 0;
        Node nextNode = front;

        while(nextNode != null)
        {
            total += nextNode.val;
            nextNode = nextNode.next;
        }

        return total;
    }

    public boolean isEmpty() { return size == 0; } // 0(1) time

    public static void main(String[] args) throws PopException
    {
        Stack stack = new Stack();
        stack.push(3);
        stack.push(2);
        stack.push(1);

        assert ! stack.isEmpty();

        assert stack.doublePop() == 3;
        try
        {
            stack.doublePop();
            assert false;
        }
        catch(PopException e)
        {
            assert true;
        }

        stack.push(2);
        assert stack.doublePop() == 5;
        assert stack.isEmpty();
    }
}