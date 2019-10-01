import java.util.Stack;

public class History
{
   private Stack<Event> undo;
   private Stack<Event> redo;
   
   // Constructor
   public History()
   {
      undo = new Stack<Event>();
      redo = new Stack<Event>();
   }

    /**
       Notepad will call this function when thier text changes.

       deletion is a boolean that indicates if the action was a deletion of text or the insertion of text.
       position is the postion where the change took place
       Change is the string of characters that is the change.
     */
   public void addEvent(boolean deletion, int position, String change)
   {
      // Creates an event object and adds to the stack
      Event event = new Event((! deletion), position, change);
      
      // Reset the redo stack
      redo = new Stack<Event>();
      
      // Push the changes to the stack
      undo.push(event);
   }


    /**
       Notepad will call this function when it wishes to undo the last event.

       note is a variable to the Notepad that called this function
     */
   public void undoEvent(NotePad note)
   {
      // Get the last event and undo it
      Event lastEvent = undo.pop();
      boolean isDelete = lastEvent.isDelete();
      
      // Toggle whether the redo should be a deletion or insertion
      lastEvent.toggleDelete();
      
      // Add to the redo stack
      redo.push(lastEvent);
      
      // "Undo" the most recent change
      if(isDelete)
      {
         note.remove(lastEvent.getPos(), lastEvent.getChange().length());
      }
      else
      {
         note.insert(lastEvent.getPos(), lastEvent.getChange());
      }
   }


    /**
       Notepad will call this function when it wishes to redo the last event that was undone.
       Note that new actions should clear out events that can be "redone"
       note is a variable to the Notepad that called this function
     */
   public void redoEvent(NotePad note)
   {
   	// Get the last undo and redo it
      Event lastEvent = redo.pop();
      boolean isDelete = lastEvent.isDelete();
      
      // Allows undoing the most recent redo
      lastEvent.toggleDelete();
      undo.push(lastEvent);
      
      // "Undo" the most recent change
      if(isDelete)
      {
         note.remove(lastEvent.getPos(), lastEvent.getChange().length());
      }
      else
      {
         note.insert(lastEvent.getPos(), lastEvent.getChange());
      }
   }

    /**
       returns true if there is undo data in the History
     */
   public boolean hasUndoData()
   {
       if(undo.empty())
       {
         return false;
       }
       else
       {
         return true;
       }
   }

    /**
       returns true if there is redo data in the History
     */
   public boolean hasReDoData()
   {
       if(redo.empty())
       {
         return false;
       }
       else
       {
         return true;
       }
   }
}

// Class event to store the changes
class Event
{
   //Attributes
   private boolean delete;
   private int position;
   private String changeString;

   // Constructor
   public Event(boolean delete, int position, String changeString)
   {
      this.delete = delete;
      this.position = position;
      this.changeString = changeString;
   }
   
   // Returns whether or not the event should be deleted or not
   // true : delete
   // false : insert
   public boolean isDelete()
   {
      return delete;
   }
   
   // Gets the position of the event
   public int getPos()
   {
      return position;
   }
   
   // Gets the string of the change
   public String getChange()
   {
      return changeString;
   }
   
   // Toggles the delete from true to false or false to true
   public void toggleDelete()
   {
      delete = (! delete);
   }
   
   public String toString()
   {
      return "Event(" + delete + ", " + position + ", " + changeString + ")";
   }
}
