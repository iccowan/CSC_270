// Mage Class is a Job

public class Mage extends Job
{
   /*
   *  Mage Constructor:
   *  Constructs the mage job.
   *  Inputs:
   *     null
   */
   
   public Mage()
   {
      name = "MAGE";
   }
   
   /*
   *  attack() method:
   *  Calculates the correct attack value dependent on the value, hero, and being a mage.
   *  Inputs:
   *     int val
   *     Hero hero
   *  Outputs:
   *     int attackValue
   */
   public int attack(int val, Hero hero)
   {
      return hero.getDEX() + hero.getINT() * val;
   }
}