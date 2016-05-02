/*
 * ############################################################################
 * Name: Billy Hart
 * Date: Tue Apr 19 16:14:33 2016
 * Description: 
 * ############################################################################
*/

// Includes
import java.util.*;

public class GoLExtRandomInitializer implements GoLInitializer {
    
    // Instance Variables
    private final int NUM_ROWS = 20;
    private final int NUM_COLUMNS = 20;
    private GoLCell[][] gameBoard = new GoLCell[NUM_ROWS][NUM_COLUMNS];
    private String extendedVersionNotice = "\t:: Extended Version ::";

    // Constructor(s) ----------------------------------------------------------

    // Creates new GoLExtRandomInitializer with a random seed
    public GoLExtRandomInitializer() {
        Random randomLifeOrDeath = new Random();
        Random randomCellType = new Random();
        int cellType = -1;
    
        // alert the user to the use of extended version
        System.out.println(extendedVersionNotice);

        // Give life to random cells in the board
        for (int row = 0; row < this.NUM_ROWS; row++) {
            for (int column = 0; column < this.NUM_COLUMNS; column++) {
                cellType = randomCellType.nextInt(3);
                if (cellType == 0) 
                    this.gameBoard[row][column] = new 
                        GoLCell(randomLifeOrDeath.nextBoolean());
                if (cellType == 1)
                    this.gameBoard[row][column] = new 
                        GoLStrongCell(randomLifeOrDeath.nextBoolean());
                if (cellType == 2)
                    this.gameBoard[row][column] = new 
                        GoLWeakCell(randomLifeOrDeath.nextBoolean());
            }
        }    
    }

    public GoLExtRandomInitializer(long seed) {
        Random randomLifeOrDeath = new Random(seed);
        Random randomCellType = new Random(seed);
        int cellType = -1;
    
        // alert the user to the use of extended version
        System.out.println(extendedVersionNotice);

        // Give life to random cells in the board
        for (int row = 0; row < this.NUM_ROWS; row++) {
            for (int column = 0; column < this.NUM_COLUMNS; column++) {
                cellType = randomCellType.nextInt(3);
                if (cellType == 0) {
                    this.gameBoard[row][column] = new 
                        GoLCell(randomLifeOrDeath.nextBoolean());
                } else if (cellType == 1) {
                    this.gameBoard[row][column] = new 
                        GoLStrongCell(randomLifeOrDeath.nextBoolean());
                } else if (cellType == 2) {
                    this.gameBoard[row][column] = new 
                        GoLWeakCell(randomLifeOrDeath.nextBoolean());
                } else { 
                    System.out.println("error!");
                }
            }
        }    
    }

    // Method(s) ---------------------------------------------------------------

    // Returns an array of cells
    public GoLCell[][] getCellArray() {
        return gameBoard;
    }

}