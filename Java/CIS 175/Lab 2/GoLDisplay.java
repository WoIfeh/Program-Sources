/*
 * ############################################################################
 * Name: Billy Hart
 * Date: Tue Apr 12 15:44:23 2016
 * Description: This class implements a model for the neighborhood of an 
 * individual cell.
 * ############################################################################
*/

// Includes
import java.util.*;

public class GoLDisplay {
    
    // Instance Variables

    // Constructor(s) ---------------------------------------------------------

    // Creates a new display object
    public GoLDisplay() {
        //
    }

    // Method(s) --------------------------------------------------------------
    // Outputs the current board along with round number, births and deaths
    public static void displayBoard(GoLBoard gameBoard) {

        // Print the current round number
        System.out.println("--------------- Round " + 
                           gameBoard.getCurrentRound() + " ---------------");

        // Print current births and deaths
        System.out.println("Births: " + gameBoard.getBirths() + " Deaths: " + 
                           gameBoard.getDeaths());

        // Print the contents of each cell
        for (int row = 0; row < gameBoard.numRows; row++) {
            for (int column = 0; column < gameBoard.numColumns; column++) {
                System.out.print(gameBoard.getBoardArray()[row][column] + 
                                   " ");
            }
            System.out.println("");
          }
    }

}