/*
 * ################################################################################
 * Name: Billy Hart
 * Chapter: 4 (Part 2)
 * Assignment: Programming Challenge #11
 * Date: 10/01/15
 * Description: Displays a table of the Celsius temperatures 0 through 20 and
 *              their Fahrenheit equivalents.
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
 * For rangeOfTemperatures = 0 To 20 Step + 1
 * Display Table: Celsius       Fahrenheit
 * Display rangeOfTemp[Counter] And ConvertToFahrenheit([Counter])
 * ConvertToFahrenheit([Counter]) Formula: (9/5 * [Counter]) + 32
 * Next
 * ################################################################################
*/

public class C4_PC_11
{
    public static void main(String[] args)
    {
      // Local Variables
      int celsiusTempRange = 0, celsiusMaxTemp = 20;
      float fahrenheitEquivalent;

      // Display the header of the conversion table
      System.out.println("C°\tF°");

        do
        {
          // Convert Celsius to Fahrenheit and store it
          fahrenheitEquivalent = (9F/5F * celsiusTempRange) + 32F;

          // Display conversions as a line of celsius <tab> fahrenheit temperatures
          System.out.format("%d\t%.1f\n", celsiusTempRange, fahrenheitEquivalent);

          // Increment the range
          celsiusTempRange++;

          // Create each line of the table until max temp is reached
        } while (celsiusTempRange <= celsiusMaxTemp);

        // Exit
        System.exit(0);
    }
}

// ## Results #####################################################################