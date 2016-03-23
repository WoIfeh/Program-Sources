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

		System.out.println("GoLCell Tests: " + testGoLCell() + "/1");

	}

	public static int testGoLCell() {

		int passingTests = 0;


		// updateCell() Testing 

			// Neighborhood that's empty
			try {
				GoLNeighborhood testNeighborhood = new GoLNeighborhood(new GoLCell[0][0]);
			} catch (EmptyObjectException error) {
			    System.err.println("EmptyObjectException: " + error.getMessage());
			}
			passingTests++;
			// Neighborhood that doesn't contain proper cells

			// Neighborhood that's larger than expected

			// Neighborhood that's smaller than expected

			// Neighborhood that keeps a cell dead

			// Neighborhood that keeps a cell alive

			// Neighborhood that brings a cell to life

			// Neighborhood that kills an alive cell

			return passingTests;
		}
}