/*
 * ###############################################################################
 * Billy Hart
 * Chapter: 2
 * Assignment: Programming Challenge #13
 * Date: 09/08/15
 * Description: Computes the tax, tip and total on a resturant bill, provide the
 *				meal charge is entered from the user. Tax and tip are precentage
 *				base named-constants of 6.75% and 15% respectively.
 * ###############################################################################
*/

/*______- * - Grade - * -______
 |                             |
 |                             |
 |                             |
 |                             |
 |                             |
 |_____________________________|
 */

/* ## Pseudo #####################################################################
 * Display "Enter the charge for the meal: "
 * Store the users response as Charge
 * Display "Meal Charge..$" + Charge
 * Calculate Tax as Charge * 6.75%
 * Display "Tax..$" + Tax
 * Calculate Tip as (Charge + Tax) * 15%
 * Display "Tip..$" + Tip
 * Calculate Total as (Charge + Tax + Tip)
 * Display "Total..$" + Total
 * ###############################################################################
*/

// ## Includes ###################################################################
import java.util.Scanner;

// Resturant Bill Calculator
public class Chapter2
{
	// Prints reciept of the restaurant's bill including tip
	public static void main(String[] args)
	{
		// Local Variables
		float charge, tax, tip, total;
		final float taxPercentage = 0.0675F, tipPercentage = 0.15F;
		final int NEW_LINE = 1;

		// Start tracking user input
		Scanner userInput = new Scanner(System.in);

		// Request information about users meal & store it
		ConsoleWrite("Enter the charge for the meal: $", NEW_LINE);
		charge = userInput.nextFloat();

		// Calculate Tax, Tip, and Total
		tax		= charge * taxPercentage;
		tip 	= (charge + tax) * tipPercentage;
		total 	= charge + tax + tip;

		// Display calculations to user
		ConsoleWrite("- - - - - - - - - - - - - - - - - - -\n", NEW_LINE);
		ConsoleWrite("Meal Charge..$", 0);
		ConsoleWrite(charge, NEW_LINE);
		ConsoleWrite("Tax..........$", 0);
		ConsoleWrite(tax, NEW_LINE);
		ConsoleWrite("Tip..........$", 0);
		ConsoleWrite(tip, NEW_LINE);
		ConsoleWrite("Total........$", 0);
		ConsoleWrite(total, NEW_LINE);


		// Exit
		System.exit(0);
	}

	private static void ConsoleWrite(String userString, int newLineToggle) {
		if (newLineToggle == 1) {
			System.out.println(userString);
		}
		else {
			System.out.print(userString);
		}
	}

	private static void ConsoleWrite(int userNum, int newLineToggle) {
		if (newLineToggle == 1) {
			System.out.println(userNum);
		}
		else {
			System.out.print(userNum);
		}
	}

	private static void ConsoleWrite(float userFloat, int newLineToggle) {
		if (newLineToggle == 1) {
			System.out.println(userFloat);
		}
		else {
			System.out.print(userFloat);
		}
	}

}
