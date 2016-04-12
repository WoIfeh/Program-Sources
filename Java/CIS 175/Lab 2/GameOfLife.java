/*
 * ################################################################################
 * Name: Billy Hart
 * Assignment: Lab #1
 * Date: 02/23/16 - 
 * Description: Text-only version of game "The Game of Life" 
 * Version # 1
 * ################################################################################
*/

// Includes
import java.util.*;


// Class is designed to replicate the Game of Life
public class GameOfLife {

	// Main
    public static void main(String[] args) {

        GoLCell testingCell = new GoLCell(true);
        if (testingCell.isAlive()) System.out.println("I'm alive");

        GoLCell[][] testingNeighborhoodCells = new GoLCell[3][3];

        GoLNeighborhood testingNeighborhood = new GoLNeighborhood(testingNeighborhoodCells);

        GoLCell cellValue = testingNeighborhood.getCell(0, 0);
        System.out.println("Cell value is " + cellValue);
    }

}