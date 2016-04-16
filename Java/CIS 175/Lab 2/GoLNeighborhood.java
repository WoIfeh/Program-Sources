/*
 * #############################################################################
 * Name: Billy Hart
 * Date: 03/15/2016 - 04/15/2016
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
    public GoLNeighborhood(GoLCell[][] cellNeighbors) { 
      this.cellNeighbors = cellNeighbors;
    }

    // Method(s) ---------------------------------------------------------------
	
	// Gets the cell at coordinates x,y in the neighborhood
	public GoLCell getCell(int x, int y) {
	  return this.cellNeighbors[x][y];
	}
}