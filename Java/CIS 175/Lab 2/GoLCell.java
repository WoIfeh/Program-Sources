/*
 * #############################################################################
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
	  return true;
	}

	// Returns true if alive and false if dead
	public boolean isAlive() {
	  return this.cellStatus;
	}
}