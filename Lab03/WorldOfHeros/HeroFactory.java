public class HeroFactory
{
   /*
   *  createHero method:
   *  Creates a new hero based on the race name and job name provided. Outputs null if the race or job do not exist.
   *  Inputs:
   *     String raceName
   *     String jobName
   *  Outputs:
   *     HeroInterface Hero
   */
   public static HeroInterface createHero(String raceName, String jobName)
   {
      // Make sure we have good values: make them uppercase
      raceName = raceName.toUpperCase();
      jobName = jobName.toUpperCase();
      
      // Create the job instance
      Job heroJob;
      if(jobName == "WARRIOR")
      {
         heroJob = new Warrior();
      }
      else if(jobName == "ARCHER")
      {
         heroJob = new Archer();
      }
      else if(jobName == "MAGE")
      {
         heroJob = new Mage();
      }
      else
      {
         return null;
      }
      
      // Create the hero instance of HeroInterface with the job previously created
      HeroInterface hero;
      if(raceName == "ELF")
      {
         hero = new Elf(heroJob);
      }
      else if(raceName == "DWARF")
      {
         hero = new Dwarf(heroJob);
      }
      else if(raceName == "ROBOT")
      {
         hero = new Robot(heroJob);
      }
      else
      {
         return null;
      }
      
      return hero;
   }
}