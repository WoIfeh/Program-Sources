/*
 * ################################################################################
 * Name: Billy Hart
 * Chapter: 7 (Part 1)
 * Assignment: Programming Challenge #10
 * Date: 10/20/15
 * Description: Demonstrate different method calls applying to a test
 *              integer-typed array.
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
 * Create a test integer array with 10 elements
 * Assign the array elements pseudo test data from Random()
 * Display the test data to ensure its integrity
 * Demonstrate each method, by passing in a one-dimensional array as the argument
 * getTotal()   - returns the total of the values in the array
 * getAverage() - returns the average of the values in the array
 * getHighest() - returns the highest value in the array
 * getLowest()  - returns the lowest value in the array
 * ################################################################################
*/

// Includes
import java.util.Random;

public class C7_PC_10
{
    public static void main(String[] args)
    {
      // Local Variables
      final int DATA_SIZE = 10;
      int testData[] = new int[DATA_SIZE];
      int loopCounter;
      Random numberGenerator = new Random();

      // Simulated testing data
      System.out.print("Test Data...............: ");

      for (loopCounter = 0; loopCounter < DATA_SIZE; loopCounter++)
      {
        testData[loopCounter] = numberGenerator.nextInt(101);
      }

      // Display the simulated input
      for (loopCounter = 0; loopCounter < DATA_SIZE; loopCounter++)
      {
        System.out.print("[" + testData[loopCounter] + "] ");
        // Testing something out here
      }

      // New Line
      System.out.println("");

      // Print the sum of the array
      System.out.println("Sum of array............: " + GetTotal(testData));

      // Print the average of the array
      System.out.println("Average of array........: " + GetAverage(testData));

      // Print the highest value of the array
      System.out.println("Highest Value of array..: " + GetHighest(testData));

      // Print the lowest value of the array
      System.out.println("Lowest Value of array...: " + GetLowest(testData));


      // Exit
      System.exit(0);
    }


/* <------------------------------ Methods ------------------------------> */

    /* Calculate the total of the values in the array */
    public static int GetTotal(int[] arrayToSum)
    {
      //Local Variables
      int loopCounter;
      int sum = 0;

      //Loop through the array summing the totals of each int
      for (loopCounter = 0; loopCounter < arrayToSum.length; loopCounter++)
      {
        sum += arrayToSum[loopCounter];
      }

      // Return the total
      return sum;
    }


    // Calculate the average of the values in the array
    public static int GetAverage(int[] arrayToAverage)
    {
      // Return the average
      return GetTotal(arrayToAverage) / arrayToAverage.length;
    }


    // Determine the highest value in the array
    public static int GetHighest(int[] arrayToCheck)
    {
       //Local Variables
       int loopCounter;
       int highestValue = 0;

       //Loop through the array storing the highest value
       for (loopCounter = 0; loopCounter < arrayToCheck.length; loopCounter++)
       {
           if (arrayToCheck[loopCounter] > highestValue)
           {
               highestValue = arrayToCheck[loopCounter];
           }
       }

       // Return the lowest value
       return highestValue;
    }


    // Determine the highest value in the array
    public static int GetLowest(int[] arrayToCheck)
    {
       //Local Variables
       int loopCounter;
       int lowestValue = 100;

       //Loop through the array storing the lowest value
       for (loopCounter = 0; loopCounter < arrayToCheck.length; loopCounter++)
       {
           if (arrayToCheck[loopCounter] < lowestValue)
           {
               lowestValue = arrayToCheck[loopCounter];
           }
       }

       // Return the lowest value
       return lowestValue;
   }
}
