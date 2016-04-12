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
    public int numRows    = 20, 
               numColumns = 20;

    private char LIFE_CHAR  = '0', 
                 DEATH_CHAR = ' ';

    private char[][] genOne = new char[numRows][numColumns];

    private int currentRound;
    private int lastRoundBirths,
                lastRoundDeaths;


    // Constructor(s) ----------------------------------------------------------

    // Calls the overloaded constructor below with the default 
    // GoLRandomInitializer
    // public GoLBoard() {
    //     
    // }

    // Creates a new GoLBoard initialized by the provided initializer ::: GoLInitializer myInitializer
    public GoLBoard() {

      Random randomLifeOrDeath = new Random(2);

      // Give life to random cells in the board
      for (int row = 0; row < numRows; row++)
        for (int column = 0; column < numColumns; column++)
          this.genOne[row][column] = randomLifeOrDeath.nextBoolean() ? 
            LIFE_CHAR : DEATH_CHAR;
    }

    // Method(s) ---------------------------------------------------------------
    
    // Updates the board for the next round by calling the updateCell method 
    // of the individual cells, passing a GoLNeighborhood to them. Returns the 
    // updated board
    // public GoLBoard nextRound() {
    //     //
    // }
    
    // // Returns the cell at the specified coordinates
    // public GoLCell getCell(int x, int y) {
    //     //
    // }

    // // Returns a copy of the current board
    // public GoLBoard copyBoard() {
    //     //
    // }

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

    // Returns the array of the board?
    public char[][] getBoardArray() {
        return this.genOne;
    }

}