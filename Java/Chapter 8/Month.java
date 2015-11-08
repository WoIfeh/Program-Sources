/*
 * ################################################################################
 * Name: Billy Hart
 * Chapter: 8
 * Assignment: Programming Challenge #5
 * Date: 11/06/15
 * Description: Something that works with months
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
 *
 * ################################################################################
*/

// Includes
// import java.util.Scanner;

public class Month
{
 // Instance variables
    private int monthNumber;

    // Constructors
    public Month()
    {
      this.monthNumber = 1;
    }

    public Month(int monthAsDigit)
    {
      if (monthAsDigit < 1 || monthAsDigit > 12) 
      {
        this.monthNumber = 1;
      }
      else 
      {
        this.monthNumber = monthAsDigit;
      }
      
    public Month(String monthAsString)
    {
      if (monthAsString == null)
      {
        this.monthNumber = 1;
      }
      else
      {
        // Hashmap here
      }
    }

}

// ## Results #####################################################################

    