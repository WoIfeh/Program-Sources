/*
 * ###############################################################################
 * Billy Hart
 * Chapter: 3
 * Assignment: In Class - New iPhone purchase (conditional logic handler)
 * DAte: 09/15/2015
 * Description: Prompt user with options pertaining to the purchase of a new 
 *              iPhone. It asks for a variety of options to determine which
 *				particular model is desired for the user. This includes color,
 *			    capacity, insurance, and accessories. Price is modified by 
 *			    these changing values.
 * ###############################################################################
*/

/* ## Pseudo #####################################################################
 * Ask the user "Which model are you interested in purchasing"
 * Store the result in model, and update the price
 * Ask the user "Which color iPhone are you interested in"
 * Store the result in color. Price value not affected
 * Ask the user "Which capacity are they interested in:" and list options
 * Store the result and update Price value accordingly 
 * Ask the user "Are you interested in inluding insurance"
 * Check response for potential price variable update
 * Print the user an invoice based on their selected options
 * ###############################################################################
*/

// ## Includes ################################################################### 
import java.util.Scanner;

// Description of class
public class iPhone
{
	public static void main(String[] args)
	{
		// Local Variables
		String	model;
		char    color, capacity, appleCare;
		int		price = 0;

		// Enable user input
		Scanner userInput = new Scanner(System.in);

		// Ask the user which model they are interested in purchasing
		// Store result in model
		System.out.print("Which iPhone model are you interested in " + 
			             "purchasing (6s or 6s+): ");
		model = userInput.nextLine();
		// Update price based on conditional handler
		if (model.equals("6s"))
		{
			price = 649;
		}
		else
		{
			price = 749;
		}

		// Prompt for color option and store in color
		System.out.println("\nWhich color option would you like?");
		System.out.println("S - Silver");
		System.out.println("G - Gold");
		System.out.println("X - Space Gray");
		System.out.println("R - Rose Gold");
		System.out.print("\nColor Option: ");
		// Store the result of color
		color = userInput.nextLine().toLowerCase().charAt(0);


		// Prompt and store capacity options
		System.out.println("\nHow much memory would you like?");
		System.out.println("A - 16GB");
		System.out.println("B - 64GB");
		System.out.println("C - 128GB");
		System.out.print("\nCapacity Option: ");
		capacity = userInput.nextLine().toLowerCase().charAt(0);
		// Handling pricing based on capacity
		if (capacity == 'b')
		{
			price += 100;
		}
		else
		{
			if (capacity == 'c')
			{
				price += 200;
			}
		}

		// Ask the user if they are interested in purchasing Apple Care Insurance
		System.out.print("Would you like to add extended Apple Care? (Y/N): ");
		appleCare = userInput.nextLine().charAt(0);
		//If user wants insurance, then update price
		if (appleCare == 'y' || appleCare == 'Y')
		{
			price += 129;
		}

	
		// Finally, print the user an invoice
		System.out.println("\nInvoice:");
		System.out.println("You've selected an iPhone " + model + " with ");
		switch(capacity)
		{
			case 'a':
				System.out.print("16GB.");
				break;
			case 'b':
				System.out.print("64GB.");
				break;
			case 'c':
				System.out.print("128GB.");
				break;
			default: 
				System.out.println("\nInvalid capacity given.");
				break;
		}
		System.out.print("Your color choice was ");

		// Exit
		System.exit(0);
	}
}
