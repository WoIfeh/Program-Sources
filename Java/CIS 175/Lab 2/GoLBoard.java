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
        this(new GoLRandomInitializer(2));
    }

    // Creates a new GoLBoard initialized by the provided initializer
    public GoLBoard(GoLInitializer myInitializer) {
        this.gameBoard = myInitializer.getCellArray();
    }

    // Method(s) ---------------------------------------------------------------
    
    // Updates the board for the next round by calling the updateCell method 
    // of the individual cells, passing a GoLNeighborhood to them. Returns the 
    // updated board
    public GoLBoard nextRound() {
        
        GoLBoard updatedBoard = new GoLBoard();
        GoLNeighborhood cNeighborhood;

        // Update the round count
        this.currentRound++;

        // Reset the births/deaths counter
        this.lastRoundBirths = 0;
        this.lastRoundDeaths = 0;
        
        // Create a copy of the board
        updatedBoard.gameBoard = this.gameBoard;

        for (int row = 0; row < 20; row++) {
            for (int column = 0; column < 20; column++) {
                // Grab the neighbors of the cell
                cNeighborhood = new 
                GoLNeighborhood(updatedBoard.getNeighbors(row,column, updatedBoard));

                // Update the cell based on the neighbors
                if (updatedBoard.getCell(row,column).updateCell(cNeighborhood)) {
                    this.lastRoundBirths++;
                    updatedBoard.gameBoard[row][column] = new GoLCell(true);
                } else {
                    this.lastRoundDeaths++;
                    updatedBoard.gameBoard[row][column] = new GoLCell(false);
                }
                
            }
        }
        
        return updatedBoard;
    }

    // Returns the cell at the specified coordinates
    public GoLCell getCell(int x, int y) {
        return gameBoard[x][y];
    }

    // Returns a copy of the current board
    public GoLBoard copyBoard() {
        int numRows = this.gameBoard.length;
        int numColumns = this.gameBoard[0].length;
        GoLCell[][] boardCopy = new GoLCell[numRows][numColumns];
        GoLBoard tempBoard = new GoLBoard();

        // Loop through original board, and create a duplicate
        for (int row = 0; row <= numRows - 1; row++)
            for (int column = 0; column <= numColumns - 1; column++)
                boardCopy[row][column] = this.gameBoard[row][column];
                    tempBoard.gameBoard = boardCopy;

        return tempBoard;
    }

    // Re-initializes the board
    public GoLBoard reset() {
        GoLBoard tempBoard = new GoLBoard();
        return tempBoard;
    }

    // Re-initializes the board with the provided GoLInitializer
    public GoLBoard reset(GoLInitializer myInitializer) {
        GoLBoard tempBoard = new GoLBoard(myInitializer);
        tempBoard.gameBoard = myInitializer.getCellArray();
        return tempBoard;
    }  

    // Determines the neighborhood of a cell
    public GoLCell[][] getNeighbors(int xPos, int yPos, GoLBoard cellBoard) {
        GoLCell[][] cCells = new GoLCell[3][3];

        // Set the cell's state in the neighborhood
        cCells[1][1] = new GoLCell(cellBoard.getCell(xPos, yPos).isAlive());

        // Above Left Neighbor
        try { cCells[0][0] = new GoLCell((cellBoard.getCell(xPos - 1, yPos - 1).isAlive()) ? true : false);
        } catch (IndexOutOfBoundsException e) {}
        // Above Neighbor
        try { cCells[0][1] = new GoLCell((cellBoard.getCell(xPos, yPos - 1).isAlive()) ? true : false);
        } catch (IndexOutOfBoundsException e) {}
        // Above Right Neighbor
        try { cCells[0][2] = new GoLCell((cellBoard.getCell(xPos + 1, yPos - 1).isAlive()) ? true : false);
        } catch (IndexOutOfBoundsException e) {}
        // Left Neighbor
        try { cCells[1][0] = new GoLCell((cellBoard.getCell(xPos - 1, yPos).isAlive()) ? true : false);
        } catch (IndexOutOfBoundsException e) {}
        // Right Neighbor
        try { cCells[1][2] = new GoLCell((cellBoard.getCell(xPos + 1, yPos).isAlive()) ? true : false);
        } catch (IndexOutOfBoundsException e) {}
        // Bottom Left Neighbor
        try { cCells[2][0] = new GoLCell((cellBoard.getCell(xPos - 1, yPos + 1).isAlive()) ? true : false);
        } catch (IndexOutOfBoundsException e) {}
        // Bottom Neighbor
        try { cCells[2][1] = new GoLCell((cellBoard.getCell(xPos, yPos + 1).isAlive()) ? true : false);
        } catch (IndexOutOfBoundsException e) {}
        // Bottom Right Neighbor
        try { cCells[2][2] = new GoLCell((cellBoard.getCell(xPos + 1, yPos + 1).isAlive()) ? true : false);
        } catch (IndexOutOfBoundsException e) {}
        
        // ** DEBUG: Prints out a neighborhood 
        // for (int roww = 0; roww < 3; roww++) {
        //     for (int columnn = 0; columnn < 3; columnn++) {
        //         System.out.print(" " + cCells[roww][columnn] + " ");
        //     }
        //     System.out.println(""); 
        // }
        return cCells;
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