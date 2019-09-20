// Archer Class is a Job

public class Archer extends Job
{
   /*
   *  Archer Constructor:
   *  Constructs the archer job.
   *  Inputs:
   *     null
   */
   
   public Archer()
   {
      name = "ARCHER";
   }
   
   /*
   *  attack() method:
   *  Calculates the correct attack value dependent on the value, hero, and being an archer.
   *  Inputs:
   *     int val
   *     Hero hero
   *  Outputs:
   *     int attackValue
   */
   public int attack(int val, Hero hero)
   {
      return (hero.getDEX() * 3 * val) / 2;
   }
}