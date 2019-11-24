import java.util.ArrayList;

public class Queue<T>
{
    protected ArrayList<T> list = new ArrayList<T>();
    private int size = 0;

    public Queue() {}
    public Queue(Queue<T> oldQueue)
    {
        list = new ArrayList<T>(oldQueue.list);
        size = oldQueue.size;
    }

    public void add(T val)
    {
        list.add(val);
        size++;
    }

    public T pop()
    {
        T returnVal = list.get(0);
        list.remove(0);
        size--;

        return returnVal;
    }

    public int getSize() { return size; }

    public Queue<T> copy()
    {
        return new Queue<T>(this);
    }

    public boolean isEmpty() { return list.isEmpty(); }
}
