// Dwarf Class is a Hero

public class Dwarf extends Hero
{
   /*
   *  Dwarf Constructor:
   *  Constructs the Dwarf Hero.
   *  Inputs:
   *     Job heroJob
   */
   public Dwarf(Job heroJob)
   {
      job = heroJob;
      race = "DWARF";
   }
   
   /*
   *  getSTR() method:
   *  Morphs the default strength method and returns the updated strength for Dwarf.
   *  Inputs:
   *     null
   *  Outputs:
   *     int STR
   */
   public int getSTR()
   {
      return 25;
   }
}