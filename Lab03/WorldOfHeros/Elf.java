// Elf Class is a Hero

public class Elf extends Hero
{
   /*
   *  Elf Constructor:
   *  Constructs the Elf Hero.
   *  Inputs:
   *     Job heroJob
   */
   public Elf(Job heroJob)
   {
      job = heroJob;
      race = "ELF";
   }
   
   /*
   *  getDEX() method:
   *  Morphs the default dexterity method and returns the updated dexterity for Elf.
   *  Inputs:
   *     null
   *  Outputs:
   *     int DEX
   */
   public int getDEX()
   {
      return 25;
   }
}