public class MemoryManager
{
   protected MemoryAllocation head;
    
   protected final String Free = "Free";


    /* size- how big is the memory space.  
     *  Allways assume the position starts at 0
     *
     */
   public MemoryManager(long size)
   {
      MemoryAllocation dummy = new MemoryAllocation(true, "Dummy", -1, 0, null, null);
      MemoryAllocation empty = new MemoryAllocation(false, Free, 0, size, dummy, dummy);
      dummy.next = empty;
      dummy.prev = empty;
      head = dummy;
   }

    /**
       takes the size of therequested memory and a string of the process requesting the memory
       returns a memory allocation that satisfies that request, or
       returns null if the request cannot be satisfied.
     */
    
   public MemoryAllocation requestMemory(long size, String requester)
   {
      // Start at the node directly after dummy node
      MemoryAllocation start = head.next;
      
      // Loop until we reach the dummy node
      while(start != head)
      {
         // Check and make sure the checked position meets the conditions to be allocated
         if(start.allocated == false && start.len >= size)
         {
            start.allocated = true;
            start.owner = requester;
            
            // If the length is greater than the requested size, we need to create a new empty allocation
            if(start.len > size)
            {
               MemoryAllocation newEmpty = new MemoryAllocation(false, Free, start.pos + size, start.len - size, start.next, start);
               start.next.prev = newEmpty;
               start.len = size;
               start.next = newEmpty;
            }
            
            return start;
         }
         start = start.next;
      }
      
      return null;
   }


    /**
       takes a memoryAllcoation and "returns" it to the system for future allocations.
       Assumes that memory allocations are only returned once.       

     */
   public void returnMemory(MemoryAllocation mem)
   {
      mem.allocated = false;
      mem.owner = Free;
      MemoryAllocation memNext = mem.next;
      MemoryAllocation memPrev = mem.prev;
      
      // Check for combining
      if(memNext.allocated == false)
      {
         mem.len += memNext.len;
         mem.next = memNext.next;
         memNext.next.prev = mem;
         
         // Get rid of memNext linkings
         memNext.next = null;
         memNext.prev = null;
      }
      
      if(memPrev.allocated == false)
      {
         mem.len += memPrev.len;
         mem.pos = memPrev.pos;
         mem.prev = memPrev.prev;
         memPrev.prev.next = mem;
         
         // Get rid of memPrev linkings
         memPrev.next = null;
         memPrev.prev = null;
      }
   }
}
