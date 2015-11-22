/*
 * ################################################################################
 * Name: Billy Hart
 * Chapter: 14
 * Assignment: In Class Programming Challenge
 * Date: 11/17/15
 * Description: Uses java applet paint methods to create a checkerboard
 * ################################################################################
*/

/*_____- * - Grade - * -_____
 |                           |
 |                           |
 |                           |
 |                           |
 |                           |
 |___________________________|
*/

/*
 * ## Pseudo ######################################################################
 * Apply a gold trim
 * For (each) checkerboard row
 *    For (each) checkerboard column
 *       Calculate coords of upper-left corner of tile
 *          Determine the color of the square (red on even row/column)
 *             Color the square
 *    Next
 * Next
 * ################################################################################
*/

// Includes
import java.awt.*;
import java.applet.*;

public class C14_PC_1 extends Applet 
{

  // Main -------------------------------------------------------------------------

  public void paint(Graphics Checkerboard)
  {
    // Settings
    final int Max_Rows = 8;
    final int Max_Columns = 8;
    final int Size_Of_Square = 40;
 
    // Apply a gold trim around the checkerboard
    drawBoardTrim(Checkerboard, Max_Rows, Max_Columns, Size_Of_Square);
     
    // Draw the main checkerboard
    drawCheckerBoard(Checkerboard, Max_Rows, Max_Columns, Size_Of_Square);
  }


  // Helper Functions -------------------------------------------------------------

  public void drawBoardTrim(Graphics board, int row, int column, int sizeOfSquare)
  {
    // Set the color to "goldish"
    board.setColor(Color.orange);

    // Apply solid color beneath the board to add thickness to trim
    board.fillRect(0, 0, (row * sizeOfSquare) + 5, (column * sizeOfSquare) + 5);
  }
   
   
  public void drawCheckerBoard(Graphics board, 
                                    int rowMax, 
                                    int columnMax, 
                                    int sizeOfSquare)
  {
    // Local Variables
    int checkerBoardRow, checkerBoardColumn;
    int topXPosition = 0, topYPosition = 0;
       
     // Loop through each row
     for (checkerBoardRow = 0; checkerBoardRow < rowMax; checkerBoardRow++) 
     {
       // Loop through each column
       for (checkerBoardColumn = 0; checkerBoardColumn < columnMax; 
                                    checkerBoardColumn++) 
       {
         // Set the upper left corner of the square to start
         topXPosition = checkerBoardColumn * sizeOfSquare;
         topYPosition = checkerBoardRow * sizeOfSquare;
         
         // Determine what the color of the square should be
         getColorOfSquare(board, checkerBoardRow, checkerBoardColumn);
         
         // Color in the square
         setColorOfSquare(board, topXPosition, topYPosition, sizeOfSquare);
       } 
     }
  }

  public void getColorOfSquare(Graphics board, int row, int column)
  {
    // If the square falls on both an even row and column, it's a red square
    if ( (row % 2) == (column % 2) )
    {
      // Set the red color
       board.setColor(Color.red);
    }
    else // otherwise it's black
    {
      // Set the black color
       board.setColor(Color.black); 
    }
  }
  
  public void setColorOfSquare(Graphics board, 
                                    int xPos, 
                                    int yPos, 
                                    int sizeOfSquare)
  {
    // Color in the square
    board.fillRect(xPos, yPos, sizeOfSquare, sizeOfSquare);
  }

}

// ## Results #####################################################################

