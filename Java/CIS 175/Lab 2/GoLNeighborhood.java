/*
 * #############################################################################
 * Name: Billy Hart
 * Lab: 2
 * Date: 03/15/16
 * Description: This class implements a model for the neighborhood of an 
 *              individual cell.
 * #############################################################################
*/

// Implements a model for the neighborhood of an individual cell.
public class GoLNeighborhood {

	// Instance Variables
	private GoLCell[][] cellNeighbors;

	// Constructor(s) ----------------------------------------------------------
    
	// Creates a new neighborhood using the 3x3 array provided
    public GoLNeighborhood(GoLCell[][] cellNeighbors) throws IndexOutOfBoundsException { 
		// Error check 
		if (cellNeighbors.length != 3 || cellNeighbors[0].length != 3) {
			throw new IndexOutOfBoundsException("Neighborhood must be a 3x3 array.");
		}

      this.cellNeighbors = cellNeighbors;
    }

    // Method(s) ---------------------------------------------------------------
	
	// Gets the cell at coordinates x,y in the neighborhood
	public GoLCell getCell(int x, int y) {
	  return new GoLCell(true);
	}
}