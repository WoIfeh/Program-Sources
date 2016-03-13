/*
 * ################################################################################
 * Name: Billy Hart
 * Chapter: 8
 * Assignment: Programming Challenge #5 Class File
 * Date: 11/06/15
 * Description: Month object stores month values as either strings or integers. 
 * ################################################################################
*/

/*
 * ## UML Table ###################################################################
 * Month                                                                          |
 * -------------------------------------------------------------------------------|
 * - monthNumber : int                                                            |
 * -------------------------------------------------------------------------------|
 * + Month()                                                                      |
 * + Month(String monthAsString)                                                  |
 * + Month(int monthAsDigit)                                                      |
 * + setMonthNumber(int newAssignedMonthNumber)  : void                           |
 * + getMonthNumber()                            : int                            |
 * + getMonthName()                              : String                         |
 * + toString()                                  : String                         |
 * + equals(Month)                               : boolean                        |
 * + greaterThan(Month)                          : boolean                        |
 * + lessThan(Month)                             : boolean                        |
 * ################################################################################
*/

// Includes
import java.util.Arrays;


public class Month
{
 // Instance variables
    private int monthNumber;
    private final static String[] monthList = {"January", "February", "March", 
                                               "April", "May", "June", "July", 
                                               "August", "September", "October", 
                                               "November", "December"};

    // Constructors
    public Month()
    {
      this.monthNumber = 1;
    }

    public Month(int monthAsDigit)
    {
      if (isValidMonth(monthAsDigit))
      {
        this.monthNumber = monthAsDigit;
      }
      else 
      {
        this.monthNumber = 1;
      }
    }

    public Month(String monthAsString)
    {
       // Local Variables
        int monthDigit = 1;
        int loopCounter;

        // Convert the given month to lowercase
        monthAsString = monthAsString.toLowerCase();

        // Loop through the month array until the strings match
        for (loopCounter = 0; loopCounter < monthList.length; loopCounter++) 
        {
            if (monthAsString.equals(monthList[loopCounter].toLowerCase())) 
            {
                monthDigit = loopCounter + 1;
            }
        }

        // Store the index value. If month is invalid, sets as 1
        this.monthNumber = monthDigit;
    }


    // Getters / Setters
    public void setMonthNumber(int monthAsDigit) 
    {
      if (isValidMonth(monthAsDigit))
      {
        this.monthNumber = monthAsDigit;
      }
      else 
      {
        this.monthNumber = 1;
      }
    }

    public int getMonthNumber()
    {
      return this.monthNumber;
    }

    public String getMonthName()
    {
      return monthList[this.monthNumber - 1];
    }


    // State checks and comparisons
    public String toString()
    {
      return this.getMonthName();
    }

    public boolean equals(Month monthObject)
    {
      return (this.monthNumber == monthObject.getMonthNumber());
    }

    public boolean greaterThan(Month monthObject)
    {
      return (this.monthNumber > monthObject.getMonthNumber());
    }

    public boolean lessThan(Month monthObject)
    {
      return (this.monthNumber < monthObject.getMonthNumber());
    }


    // Helper Functions
    public boolean isValidMonth(int monthAsDigit) 
    {
        // Local Variables
        boolean validMonth = true;
        final int monthRangeMinimum = 1;
        final int monthRangeMaximum = monthList.length;
        
        // Check to see if the month falls within range
        if (monthAsDigit < monthRangeMinimum || monthAsDigit > monthRangeMaximum) 
        {
            validMonth = false;
        }
        
        // Return true if it's within range, false otherwise
        return validMonth;
    }

}