// Robot Class is a Hero

public class Robot extends Hero
{
   /*
   *  Robot Constructor:
   *  Constructs the Robot Hero.
   *  Inputs:
   *     Job heroJob
   */
   public Robot(Job heroJob)
   {
      job = heroJob;
      race = "ROBOT";
   }
   
   /*
   *  getINT() method:
   *  Morphs the default intelligence method and returns the updated intelligence for Robot.
   *  Inputs:
   *     null
   *  Outputs:
   *     int INT
   */
   public int getINT()
   {
      return 25;
   }
}