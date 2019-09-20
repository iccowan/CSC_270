// Warrior Class is a Job

public class Warrior extends Job
{
   /*
   *  Warrior Constructor:
   *  Constructs the warrior job.
   *  Inputs:
   *     null
   */
   
   public Warrior()
   {
      name = "WARRIOR";
   }
   
   /*
   *  attack() method:
   *  Calculates the correct attack value dependent on the value, hero, and being a warrior.
   *  Inputs:
   *     int val
   *     Hero hero
   *  Outputs:
   *     int attackValue
   */
   public int attack(int val, Hero hero)
   {
      return hero.getSTR() * val + hero.getDEX();
   }
}