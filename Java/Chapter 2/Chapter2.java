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

		// Start tracking user input
		Scanner userInput = new Scanner(System.in);

		// Request information about users meal & store it
		System.out.print("Enter the charge for the meal: $");
		charge = userInput.nextFloat();

		// Calculate Tax, Tip, and Total
		tax		= charge * taxPercentage;
		tip 	= (charge + tax) * tipPercentage;
		total 	= charge + tax + tip;

		// Display calculations to user
		System.out.println("- - - - - - - - - - - - - - - - - - -\n");
		System.out.print("Meal Charge..$");
		System.out.println(charge);
		System.out.print("Tax..........$");
		System.out.println(tax);
		System.out.print("Tip..........$");
		System.out.println(tip);
		System.out.print("Total........$");
		System.out.println(total);


		// Exit
		System.exit(0);
	}
}
