public class MemoryAllocation
{
    //package access-reachable by memory manager
    //but not those that would use this module
    String owner;  //which process owns this memory
    long pos;      //where does it start
    long len;      //how long is the memory

    //You might want to add additional data/methods here
    boolean allocated;
    MemoryAllocation next;
    MemoryAllocation prev;

    //feel free to alter the constructor if you need/want to
    public MemoryAllocation(boolean allocation, String owner, long pos, long len, MemoryAllocation next, MemoryAllocation prev)

    {
   	this.owner = owner;
   	this.pos = pos;
   	this.len = len;
      this.allocated = allocation;
      this.next = next;
      this.prev = prev;
    }

    public String getOwner()
    {
	   return owner;
    }

    public long getPosition()
    {
	   return pos;
    }

    public long getLength()
    {
	   return len;
    }

    public String toString()
    {
	   return "Alloc "+owner+" at "+pos+" for "+len; 
    }
}
