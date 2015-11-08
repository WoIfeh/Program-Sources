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
    }

    public Month(String monthAsString)
    {

      /* 
         Start Rant ---
         HashMap mapOfMonths = new HashMap(NUM_OF_MONTHS);
         Would have been 10x's better
         End Rant ---
      */

      if (monthAsString == null)
      {
        this.monthNumber = 1;
      }
      else
      {
       switch (monthAsString.toLowerCase())
       {
        case "january": 
                this.monthNumber = 1;
                break;
        case "february": 
                this.monthNumber = 2;
                break;
        case "march": 
                this.monthNumber = 3;
                break;
        case "april": 
                this.monthNumber = 4;
                break;
        case "may": 
                this.monthNumber = 5;
                break;
        case "june": 
                this.monthNumber = 6;
                break;
        case "july": 
                this.monthNumber = 7;
                break;
        case "august": 
                this.monthNumber = 8;
                break;                                                                                                                                                                      
        case "september": 
                this.monthNumber = 9;
                break;
        case "october": 
                this.monthNumber = 10;
                break;
        case "november": 
                this.monthNumber = 11;
                break;
        case "december": 
                this.monthNumber = 12;
                break;
        default: 
                // I set the default to 1 because all the other error handling options given set it to month 1
                this.monthNumber = 1;
                break;
       }
     }
    }

    // Getters / Setters
    public void setMonthNumber(int monthAsDigit)
    {
      if (monthAsDigit < 1 || monthAsDigit > 12) 
      {
        this.monthNumber = 1;
      }
      else 
      {
        this.monthNumber = monthAsDigit;
      }
    }

    public int getMonthNumber()
    {
      return this.monthNumber;
    }

}

// ## Results #####################################################################

    