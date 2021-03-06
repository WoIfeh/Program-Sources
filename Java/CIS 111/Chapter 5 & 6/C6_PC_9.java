/*
 * ################################################################################
 * Name: Billy Hart
 * Chapter: 6
 * Assignment: Programming Challenge #9
 * Date: 10/13/15
 * Description: Demonstration of a class. Displays a list of substances that freeze and boil at a
 *                      temperature that is given by the user.
 * ################################################################################
*/

/*_____- * - Grade - * -_____
 |                           |
 |                           |
 |                           |
 |                           |
 |                           |
 |___________________________|
*/

/*
 * ## Pseudo ######################################################################
 * Ask the user for a temperature and store it in temperatureFromUser
 * Compare temperatureFromUser to boiling and freezing temperatures of Substance-Objects
 *      Create two separate string-styled lists. One for boiling, one for freezing. Assemble them
 *       based on boolean conditions returned from class file.
 * Display the different substances to the user.
 * ################################################################################
*/

// Includes
//import java.util.Scanner; << Uncomment Me

public class C6_PC_9
{
    public static void main(String[] args)
    {
      // Local Variables
      int temperatureFromUser;

      // Enable User Input
      //Scanner userInput = new Scanner(System.in); << Uncomment Me

      // Ask the user to enter a temperature
      ConsoleWrite("Enter a temperature: ", 0);

      // Simulated Input
      temperatureFromUser = 300;
      ConsoleWrite(Integer.toString(temperatureFromUser), 1);

      // Retrieve and store the temperature entered
      //temperatureFromUser = userInput.nextInt(); << Uncomment Me

      // Display a table that shows which substances freeze or boil at the provided temperature
      DisplaySubstancesThatFreezeOrBoilAt(temperatureFromUser);

      // Exit
      System.exit(0);
    }

    // Method determines if a substance or substances boil or freeze at a given temperature.
    // If they do, each substance is reported to the user.
    public static void DisplaySubstancesThatFreezeOrBoilAt(int temperatureToCheck)
    {
      //Substance objects
      SubstanceInfo ethylObject     = new SubstanceInfo("Ethyl Alcohol", -173,  172);
      SubstanceInfo oxygenObject = new SubstanceInfo("Oxygen",         -362, -306);
      SubstanceInfo waterObject   = new SubstanceInfo("Water",               32,  212);

      // Local variables
      String substancesThatBoil = "";
      String substancesThatFreeze = "";
      int grammarCounter = 0;

      // Ethyl freezing check
      if (ethylObject.isEthylFreezing(temperatureToCheck))
      {
        substancesThatFreeze += "Ethyl Alcohol";
        grammarCounter++;
      }

      // Oxygen freezing check
      if (oxygenObject.isOxygenFreezing(temperatureToCheck))
      {
        substancesThatFreeze += (grammarCounter == 1) ? ", " : " ";
        substancesThatFreeze += "Oxygen";
        grammarCounter++;
      }

      // Water freezing check
      if (waterObject.isWaterFreezing(temperatureToCheck))
      {
       substancesThatFreeze += (grammarCounter == 0) ? "" : ((grammarCounter == 1) ? " and " : ", and ");
       substancesThatFreeze += "Water";
      }

      //Reset the grammar counter
      grammarCounter = 0;

      // Ethyl boiling check
      if (ethylObject.isEthylBoiling(temperatureToCheck))
      {
        substancesThatBoil += "Ethyl Alcohol";
        grammarCounter++;
      }

      // Water boiling check
      if (waterObject.isWaterBoiling(temperatureToCheck))
      {
        substancesThatBoil += (grammarCounter == 0) ? "" : ((grammarCounter == 1) ? ", " : " ");
        substancesThatBoil += "Water";
        grammarCounter++;
      }

      // Oxygen boiling check
      if (oxygenObject.isOxygenBoiling(temperatureToCheck))
      {
       substancesThatBoil += (grammarCounter == 0) ? "" : ((grammarCounter == 1) ? " and " : ", and ");
       substancesThatBoil += "Oxygen";
      }

      // Display substances that freeze at that temperature
        if (!substancesThatFreeze.equals(""))
        {
           ConsoleWrite(substancesThatFreeze + " freeze(s) at that temperature.", 1);
        }

        // Display substances that boil at that temperature
        if (!substancesThatBoil.equals(""))
        {
          ConsoleWrite(substancesThatBoil + " boil(s) at that temperature.", 1);
        }

        // No else option needed, all interger values fall in range of freezing/boiling
    }

    // Lessens the wordiness of the System.out.print() and System.out.println() methods by
    // becoming a wrapper function that handles either case based on parameter passed.
    public static void ConsoleWrite(String userString, int newLineToggle)
    {
        if (newLineToggle == 1)
        {
            System.out.println(userString);
        }
        else
        {
          System.out.print(userString);
        }
    }
}

// ## Results #####################################################################