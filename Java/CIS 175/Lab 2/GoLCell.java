/*
 * ############################################################################
 * Name: Billy Hart
 * Lab: 2
 * Date: 03/15/16
 * Description: Creates a new cell that is alive if the parameter is true or 
 *              false otherwise
 * #############################################################################
*/

// Implements a model of an individual cell
public class GoLCell {

	// Instance Variables
	private boolean cellStatus;

	// Constructor(s) ----------------------------------------------------------
    
	// Creates a new cell that is alive if the parameter is true, or false 
	// otherwise
    public GoLCell(boolean cellStatus) {
      this.cellStatus = cellStatus;
    }

    // Method(s) ---------------------------------------------------------------
	
	// Updates the cell using the given neighborhood and returns true if alive 
	// and false if dead
	public boolean updateCell(GoLNeighborhood myNeighborhood) {
        boolean stateOfCell = false;
        int numAlive = 0;

	   // Check to see if the current cell is alive or dead
       stateOfCell = myNeighborhood.getCell(1, 1).isAlive();

       for (int row = 0; row < 3; row++)
           for (int column = 0; column < 3; column++) {
                try { if (myNeighborhood.getCell(row, column).isAlive())
                        numAlive++;
                } catch (NullPointerException e) {}
            }
           
        if (stateOfCell) {
            if (numAlive > 3 || numAlive < 2)
                stateOfCell = false;
        } else {
            if (numAlive == 3)
                stateOfCell = true;
        }

      return stateOfCell;
	}

	// Returns true if alive and false if dead
	public boolean isAlive() {
	  return this.cellStatus;
	}

    // Returns the boolean value of a cell
    public String toString() {
        return (this.cellStatus) ? "0" : "-";
    }
}