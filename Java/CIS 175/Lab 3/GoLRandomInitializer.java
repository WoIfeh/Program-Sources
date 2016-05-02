/*
 * ############################################################################
 * Name: Billy Hart
 * Date: Tue Apr 12 15:51:34 2016 - Fri Apr 15 21:29:06 2016
 * Description: This class implements an interface for initializing a board.
 * ############################################################################
*/

// Includes
import java.util.*;

public class GoLRandomInitializer implements GoLInitializer {
    
    // Instance Variables
    private final int NUM_ROWS = 20;
    private final int NUM_COLUMNS = 20;
    private GoLCell[][] gameBoard = new GoLCell[NUM_ROWS][NUM_COLUMNS];
    

    // Constructor(s) ---------------------------------------------------------

    // Creates new GoLRandomInitializer with a random seed
    public GoLRandomInitializer() {
        Random randomLifeOrDeath = new Random();
    
        // Give life to random cells in the board
        for (int row = 0; row < this.NUM_ROWS; row++)
            for (int column = 0; column < this.NUM_COLUMNS; column++)
                this.gameBoard[row][column] = new 
                    GoLCell(randomLifeOrDeath.nextBoolean());
    }

    // Creates new GoLRandomInitializer with a given seed
    public GoLRandomInitializer(long seed) {
        Random randomLifeOrDeath = new Random(seed);
    
        // Give life to random *predicted* cells in the board
        for (int row = 0; row < this.NUM_ROWS; row++)
            for (int column = 0; column < this.NUM_COLUMNS; column++)
                this.gameBoard[row][column] = new 
                    GoLCell(randomLifeOrDeath.nextBoolean());
    }

    // Method(s) --------------------------------------------------------------

    // Returns an array of cells
    public GoLCell[][] getCellArray() {
        return gameBoard;
    }

}