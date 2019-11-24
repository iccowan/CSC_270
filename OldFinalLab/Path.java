public class Path
{
    private PathNode head = null;
    private PathNode tail = null;
    private int length = 0;
    private boolean isArchive = false;
    private Path archive = null;

    public Path() { this.archive = new Path(true); }
    private Path(boolean isArchive) {
        this.isArchive = isArchive;
        if(! isArchive) archive = new Path(true);
    }

    public String pop()
    {
        if(head != null)
        {
            PathNode oldHead = head;
            head = head.next;
            oldHead.next = null;
            if(! isArchive) archive.addAction(oldHead.val);
            length--;
            return oldHead.val;
        }

        return "ENDOFPATH";
    }

    public void addAction(String val)
    {
        if(tail == null)
        {
            tail = new PathNode(val);
            head = tail;
        }
        else
        {
            PathNode oldTail = tail;
            tail = new PathNode(val);
            oldTail.next = tail;
        }
        length++;
    }

    public boolean isEmpty()
    {
        return head == null;
    }

    public int getLength()
    {
        return length;
    }

    public Path getArchive()
    {
        return archive;
    }
}

class PathNode
{
    String val;
    PathNode next = null;

    public PathNode(String val)
    {
        this.val = val;
    }
}
