// World of Heros Test

public class TestHero
{
   // Turns the integer values into a hero
   public static Object[] createHero(int hero, int job)
   {
      // Set the defaults
      int STR = 20;
      int DEX = 20;
      int INT = 20;
      
      // Get the hero name and update values
      String heroName = "";
      switch(hero)
      {
         case 0:
            heroName = "ELF";
            DEX = 25;
            break;
            
         case 1:
            heroName = "DWARF";
            STR = 25;
            break;
            
         case 2:
            heroName = "ROBOT";
            INT = 25;
            break;
      }
      
      // Get the job name
      String jobName = "";
      switch(job)
      {
         case 0:
            jobName = "WARRIOR";
            break;
         
         case 1:
            jobName = "ARCHER";
            break;
         
         case 2:
            jobName = "MAGE";
            break;
      }
      
      // Create the hero
      HeroInterface newHero = HeroFactory.createHero(heroName, jobName);
      
      // Return the important information
      // {Hero Object: HeroInterface, Strength: int, Dexterity: int, Intelligence: int, Race Name: String, Job Name: String}
      Object[] returnArray = {newHero, STR, DEX, INT, heroName, jobName};
      return returnArray;
   }
   
   // Calculate the appropiate attack based on the hero
   public static int attackCalc(int STR, int DEX, int INT, String jobName, int val)
   {
      // Calculate based on job
      int damage = 0;
      switch(jobName)
      {
         case "WARRIOR":
            damage = STR * val + DEX;
            break;
            
         case "ARCHER":
            damage = (DEX * 3 * val) / 2;
            break;
            
         case "MAGE":
            damage = DEX + INT * val;
            break;
      }
      
      return damage;
   }
   
   public static void main(String[] args)
   {
      // Set variables for testing
      int numRace = 3;
      int numJob = 3;
      
      // Make sure the races and jobs are checking correctly
      assert HeroFactory.createHero("ELF", "RANDOMSTRING") == null : "ELF RANDOMSTRING should return null not an object";
      assert HeroFactory.createHero("RANDOMSTRING", "WARRIOR") == null : "RANDOMSTRING WARRIOR should return null not an object";
      
      // Loop through the races and jobs
      for(int i = 0; i < numRace; i++)
      {
         for(int j = 0; j < numJob; j++)
         {
            Object[] heroInfo = createHero(i, j);
            
            // Get the hero info separately
            HeroInterface hero = (HeroInterface) heroInfo[0];
            int STR = (int) heroInfo[1];
            int DEX = (int) heroInfo[2];
            int INT = (int) heroInfo[3];
            String heroName = (String) heroInfo[4];
            String jobName = (String) heroInfo[5];
            
            // Now, test the hero
            assert hero.getRaceName() == heroName : "The name of hero (" + i + ", " + j + ") should be " + heroName + " not " + hero.getRaceName();
            assert hero.getJobName() == jobName : "The name of hero (" + i + ", " + j + ")'s job should be " + jobName + " not " + hero.getJobName();
            assert hero.getSTR() == STR : "The strength of hero " + heroName + " " + jobName + " should be " + STR + " not " + hero.getSTR();
            assert hero.getDEX() == DEX : "The dexterity of hero " + heroName + " " + jobName + " should be " + DEX + " not " + hero.getDEX();
            assert hero.getINT() == INT : "The intelligence of hero " + heroName + " " + jobName + " should be " + INT + " not " + hero.getINT();
            
            // Calculate the attack and test attack values
            int heroAttack1 = attackCalc(STR, DEX, INT, jobName, 1);
            int heroAttack5 = attackCalc(STR, DEX, INT, jobName, 5);
            int heroAttack13 = attackCalc(STR, DEX, INT, jobName, 13);
            assert hero.attack(1) == heroAttack1 : "The attack1 of hero " + heroName + " " + jobName + " should be " + heroAttack1 + " not " + hero.attack(1);
            assert hero.attack(5) == heroAttack5 : "The attack5 of hero " + heroName + " " + jobName + " should be " + heroAttack5 + " not " + hero.attack(5);
            assert hero.attack(13) == heroAttack13 : "The attack13 of hero " + heroName + " " + jobName + " should be " + heroAttack13 + " not " + hero.attack(13);
         }
      }
   }
}