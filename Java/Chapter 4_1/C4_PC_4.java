/*
 * ##################################################################
 * Name: Billy Hart
 * Chapter: 4 (Part 1)
 * Assignment: Programming Assignment 4
 * Date: 09/17/15
 * Description: Calculates the number of days user would have to
 *				work to earn a certain amount, which is provided by
 *				them. It calculates the number of required days
 *				based on a double-growth algorithm starting from
 *				a penny up to their desired amount. In the end it
 *				will output a table to display 2 columns. Column 1
 *				will hold the date, column 2 for the salary of that
 *				day. The final line of input will be a report of
 *				how many days it took to reach or exceed their input
 *				and the total pay at the end of that period. The
 *				total pay is displayed in dollar amount.
 * ##################################################################
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
 * ## Pseudo #########################################################
 * Display "How much do you need to earn: $"
 * Store input in earnAmount
 * Display "Day"          "Amount"
 * While pennyCount < earnAmount
 *	double pennyCount
 *	daycount++
 *	Display day		pennyCount  converted to $0.00 format
 * ##################################################################
*/

// Includes
import java.util.Scanner;

public class C4_PC_4
{
    public static void main(String[] args)
    {
        // Enable user input
        Scanner userInput = new Scanner(System.in);

        // Local Vars
        float userDesiredEarnedAmount, desiredAmountAsPennies;
        float currentPennyCount = 1.0F;
        int   dayNumber = 1;

        //Ask the user how much they need to earn
        System.out.print("How much do you need to earn: $");
        // Retrieve and store the value
        //userDesiredEarnedAmount = userInput.nextFloat();
        userDesiredEarnedAmount = 2000;
        // Convert input value into pennies
        desiredAmountAsPennies  = userDesiredEarnedAmount * 100.0F;

        /* Start displaying the table
           Use day one hard coded as it's a constant that we will
           start with day one with the value of 1 cent. No need
           to add conditional handling for const intital val */
        System.out.println();
        System.out.println("Day		Amount");
        System.out.println("---		------");
        System.out.println("1		$0.01");

        /* Compare pennies to pennies
           If the current count is less than or equal to what
           the user entered...*/
        while (currentPennyCount <= desiredAmountAsPennies)
       	{
        	// Then..double the value of the penny
        	currentPennyCount = currentPennyCount * 2.0F;
        	// Increment days to account for the next day
			dayNumber += 1;
			/* Display a row of the table with..
			             day      amount
			   Return amount as pennies converted back to
			   dollars before displaying it to the user */
			System.out.println(dayNumber + "		" + "$" +
							  (currentPennyCount / 100.0F));
     	}
		// Report to the user the number of days required
		System.out.println();
		System.out.println("It requires at least " + dayNumber +
			               " days to earn $" + userDesiredEarnedAmount);
        // Exit
        System.exit(0);
    }
}
