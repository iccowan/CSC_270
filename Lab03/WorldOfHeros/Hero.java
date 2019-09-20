// Hero Class implements the HeroInterface

class Hero implements HeroInterface
{
   // Attributes
   protected Job job;
   protected String race;
   
   /*
   *  attack() method:
   *  Takes a value and calculates the hero's attack amount based on their job and outputs this attack value.
   *  Inputs:
   *     int val
   *  Outputs:
   *     int attackValue
   */
   public int attack(int val)
   {
      return job.attack(val, this);
   }
   
   /*
   *  getSTR() method:
   *  Returns the hero's default strength value.
   *  Inputs:
   *     null
   *  Outputs:
   *     int STR
   */
   public int getSTR()
   {
      return 20;
   }
   
   /*
   *  getDEX() method:
   *  Returns the hero's default dexterity value.
   *  Inputs:
   *     null
   *  Outputs:
   *     int DEX
   */
   public int getDEX()
   {
      return 20;
   }
   
   /*
   *  getINT() method:
   *  Returns the hero's default intelligence value.
   *  Inputs:
   *     null
   *  Outputs:
   *     int INT
   */
   public int getINT()
   {
      return 20;
   }
   
   /*
   *  getRaceName() method:
   *  Returns the name of the hero's race.
   *  Inputs:
   *     null
   *  Outputs:
   *     String race
   */
   public String getRaceName()
   {
      return race;
   }
   
   /*
   *  getJobName() method:
   *  Returns the name of the hero's job.
   *  Inputs:
   *     null
   *  Outputs:
   *     String jobString
   */
   public String getJobName()
   {
      return job.toString();
   }
}