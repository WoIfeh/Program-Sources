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
    private int currentRound;
    private int lastRoundBirths;
    private int lastRoundDeaths;

    // Constructor(s) ----------------------------------------------------------

    // Calls the overloaded constructor below with the default 
    // GoLRandomInitializer
    public GoLBoard() {
        // this. = ;
    }

    // Created a new GoLBoard initialized by the provided initializer
    public GoLBoard(GoLInitializer myInitializer) {

    }

    // Method(s) ---------------------------------------------------------------
    
    // Updates the board for the next round by calling the updateCell method 
    // of the individual cells, passing a GoLNeighborhood to them. Returns the 
    // updated board
    public GoLBoard nextRound() {
        //
    }
    
    // Returns the cell at the specified coordinates
    public GoLCell getCell(int x, int y) {
        //
    }

    // Returns a copy of the current board
    public GoLBoard copyBoard() {
        //
    }

    // Re-initializes the board
    public GoLBoard reset() {
        //
    }

    // Re-initializes the board with the provided GoLInitializer
    public GoLBoard reset(GoLInitializer myInitializer) {
        //
    }  

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