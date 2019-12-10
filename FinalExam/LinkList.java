public class LinkList<T>
{
    Node<T> dummy;

    public LinkList() // 0(1) time complexity
    {
        dummy = new Node(null);
        dummy.next = dummy;
        dummy.prev = dummy;
    }

    private LinkList(Node<T> node) // 0(1) time complexity
    {
        dummy = node;
    }

    public void append(T val) // 0(1) time complexity
    {
        Node<T> newNode = new Node<T>(val);
        newNode.next = dummy;
        newNode.prev = dummy.prev;
        dummy.prev.next = newNode;
        dummy.prev = newNode;
    }

    public void reverse() // 0(n) time complexity
    {
        if(isEmpty()) return;
        Node<T> nextSwitch = dummy;
        do
        {
            Node<T> temp = nextSwitch.next;
            nextSwitch.next = nextSwitch.prev;
            nextSwitch.prev = temp;
            nextSwitch = nextSwitch.prev;
        } while(nextSwitch != dummy);
    }

    public LinkList<T> shallowCopy() { return new LinkList<T>(dummy); } // 0(1) time complexity

    public LinkList<T> deepCopy() // 0(n) time complexity
    {
        LinkList<T> copy = new LinkList<T>();
        Node<T> current = dummy.next;
        while(current != dummy)
        {
            copy.append(current.val);
            current = current.next;
        }

        return copy;
    }

    public boolean isEmpty() { return dummy.next == dummy; } // 0(1) time complexity
}

class Node<T>
{
    Node<T> next = null;
    Node<T> prev = null;
    T val;

    public Node(T val)
    {
        this.val = val;
    }
}