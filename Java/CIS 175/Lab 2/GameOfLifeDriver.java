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

		System.out.println("GoLCell Tests: " + testGoLCell() + "/2");

	}

	public static int testGoLCell() {

		int passingTests = 0;


		// updateCell() Testing 

			try {
				// Neighborhood that's empty
				GoLNeighborhood emptyNeighborhood = new GoLNeighborhood(new GoLCell[1][1]);
				passingTests++;
				// Neighborhood that's larger than expected
				GoLNeighborhood largeNeighborhood = new GoLNeighborhood(new GoLCell[3][4]);
				passingTests++;
			} catch (EmptyObjectException error) {
			    System.err.println("EmptyObjectException: " + error.getMessage());
			} catch (IndexOutOfBoundsException error) {
				System.err.println("IndexOutOfBoundsException: " + error.getMessage());
			}

			// Neighborhood that's smaller than expected

			// Neighborhood that doesn't contain proper cells

			// Neighborhood that keeps a cell dead

			// Neighborhood that keeps a cell alive

			// Neighborhood that brings a cell to life

			// Neighborhood that kills an alive cell

			return passingTests;
		}
}