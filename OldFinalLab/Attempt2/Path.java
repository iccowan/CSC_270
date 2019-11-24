public class Path extends Queue<String>
{
    // Just a Queue, under a different name
    // If more methods are necessary, they can now be added

    public Path() { super(); }
    public Path(Path oldPath) { super(oldPath); }

    public Path copy()
    {
        return new Path(this);
    }
}
