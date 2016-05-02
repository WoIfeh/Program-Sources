/*
 * ############################################################################
 * Name: Billy Hart
 * Date: Tue Apr 12 15:44:23 2016 - Fri Apr 15 21:28:43 2016
 * Description: This class implements a model for the neighborhood of an 
 * individual cell.
 * ############################################################################
*/

// Includes
import java.util.*;

public class GoLDisplay {
    
    // Instance Variables
   private char LIFE_CHAR  = '0', 
                DEATH_CHAR = '-';

    // Constructor(s) ---------------------------------------------------------

    public GoLDisplay() {
        //
    }

    // Method(s) --------------------------------------------------------------
    // Outputs the current board along with round number, births and deaths
    public void displayBoard(GoLBoard gameBoard) {

        // Print the current round number
        System.out.println("--------------- Round " + 
                           gameBoard.getCurrentRound() + " ---------------");

        // Print current births and deaths
        System.out.println("Births: " + gameBoard.getBirths() + " Deaths: " + 
                           gameBoard.getDeaths());

        // Print the contents of each cell
        for (int row = 0; row < 20; row++) {
            for (int column = 0; column < 20; column++) {
                System.out.print((gameBoard.getCell(row, column).isAlive()) ? LIFE_CHAR : DEATH_CHAR);
            }
            System.out.println("");
          }
    }

}