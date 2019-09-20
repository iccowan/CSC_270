// Job Class

public class Job
{
   // Attributes
   protected String name;
   
   /*
   *  attack() method:
   *  Allows attack() to be called on an object class. This gets morphed in each job subclass.
   *  If on calling attack() to any 
   */
   public int attack(int val, Hero hero) {   return 0;   }
   
   /*
   *  toString() method:
   *  Morphs the default toString() method to return the job name.
   *  Inputs:
   *     null
   *  Outputs:
   *     String jobString
   */
   public String toString()
   {
      return name;
   }
}