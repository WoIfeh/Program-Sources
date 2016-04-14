/*
 * ############################################################################
 * Name: Billy Hart
 * Date: Tue Apr 12 15:19:11 2016
 * Description: Implements a model for the game board
 * ############################################################################
*/

// Includes
import java.util.*;

public class GoLBoard {
    
    // Instance Variables
    protected GoLCell[][] gameBoard;
    private int currentRound;
    private int lastRoundBirths,
                lastRoundDeaths;


    // Constructor(s) ----------------------------------------------------------

    // Calls the overloaded constructor below with the default 
    // GoLRandomInitializer
    public GoLBoard() {
        this(new GoLRandomInitializer());
    }

    // Creates a new GoLBoard initialized by the provided initializer
    public GoLBoard(GoLInitializer myInitializer) {
        this.gameBoard = myInitializer.getCellArray();
    }

    // Method(s) ---------------------------------------------------------------
    
    // Updates the board for the next round by calling the updateCell method 
    // of the individual cells, passing a GoLNeighborhood to them. Returns the 
    // updated board
    // public GoLBoard nextRound() {
    //     this.currentRound++;
    // }
    
    // Returns the cell at the specified coordinates
    public GoLCell getCell(int x, int y) {
        return gameBoard[x][y];
    }

    // Returns a copy of the current board
    public GoLBoard copyBoard() {
        int numRows = this.gameBoard.length;
        int numColumns = this.gameBoard[0].length;

        // Blank board for original value comparisons
        GoLCell[][] boardCopy = new GoLCell[numRows][numColumns];

        GoLBoard tempBoard = new GoLBoard();

          // Loop through each element of the original board, and create a duplicate board
          for (int row = 0; row <= numRows - 1; row++) {
            for (int column = 0; column <= numColumns - 1; column++) {
              boardCopy[row][column] = this.gameBoard[row][column];
            }
          }

          tempBoard.gameBoard = boardCopy;

          return tempBoard;
    }

    // // Re-initializes the board
    // public GoLBoard reset() {
    //     //
    // }

    // // Re-initializes the board with the provided GoLInitializer
    // public GoLBoard reset(GoLInitializer myInitializer) {
    //     //
    // }  

    // Returns number of the current round
    public int getCurrentRound() {
        return this.currentRound;
    }

    // Returns the number of births from last round
    public int getBirths() {
        return this.lastRoundBirths;
    }

    // Returns the number of deaths from last round
    public int getDeaths() {
        return this.lastRoundDeaths;
    }

}