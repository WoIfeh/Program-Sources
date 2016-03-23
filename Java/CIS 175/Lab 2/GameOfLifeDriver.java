/*
 * #############################################################################
 * Name: Billy Hart
 * Lab: 2
 * Date: 03/15/16 - 
 * Description: Tests all the functionality of GoL
 * #############################################################################
*/

public class GameOfLifeDriver {

	public static void main(String[] args) {
			
	}

	public static int testGoLCell() {

		int passingTests = 0;


		// updateCel()

			// Neighborhood that's empty
			try {
				updateCell(new GoLNeighborhood(new GoLCell[0][0]));
			} catch (EmptyObjectException error) {
			    System.err.println("EmptyObjectException: " + e.getMessage());
			}

			// Neighborhood that doesn't contain cells

			// Neighborhood that's larger than expected

			// Neighborhood that's smaller than expected

			// Neighborhood that keeps a cell dead

			// Neighborhood that keeps a cell alive

			// Neighborhood that brings a cell to life

			// Neighborhood that kills an alive cell

			return passingTests;
		}
}