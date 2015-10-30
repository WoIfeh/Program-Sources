/*
 * ################################################################################
 * Name: Billy Hart
 * Chapter: 7 (Part 2)
 * Assignment: Programming Challenge Option #2
 * Date: 10/24/15
 * Description: Life (Pending more details)
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
 * GetGuessCoordsFromUser()
 * DisplayGuessTable()
 * CreateLirhtMap()
 * MarkGuessOnMap()
 * PlaceHurkleOnMap()
 * ################################################################################
*/

// Includes
// import java.util.Scanner;

public class C7_PC_2
{
    public static void main(String[] args)
    {
      // Local Variables

      // Enable User Input
      // Scanner userInput = new Scanner(System.in);

      // Simulated Input


      final int MAP_ROWS = 24;
      final int MAP_COLUMNS = 47;
      final int ROWS_WITHOUT_MARKERS = 20;
      final int COLUMNS_WITHOUT_MARKERS = 42;
      char mapOfLirth[][] = new char[MAP_ROWS][MAP_COLUMNS];
      int loopCounter, loopCounterRow, loopCounterColumn;
      int minNumOfNums = 1, maxNumOfNums = 9, markerLocation = 4;
      int row, column;

      // Initalize all of the map with empty spaces
     for (row = 0; row < MAP_ROWS; row++) {
        for (column = 0; column < MAP_COLUMNS; column++) {
          mapOfLirth[row][column] = ' ';
        }
     }

      // Place the Column numbers
      for (loopCounter = 2, markerLocation = 2; loopCounter <= ROWS_WITHOUT_MARKERS; loopCounter++) {
          if (counterIsAtNextMarker(loopCounter, markerLocation)) {
              if (loopCounter == 2) {
                mapOfLirth[loopCounter][loopCounter - 1] = '1';
                mapOfLirth[loopCounter][loopCounter]     = '0';
              }
              else {
                mapOfLirth[loopCounter][2] = Integer.toString(maxNumOfNums).charAt(0);
                maxNumOfNums--;
              }
          }
      }

      // Place the Row numbers
      for (loopCounter = 6, markerLocation = 4; loopCounter <= COLUMNS_WITHOUT_MARKERS; loopCounter++) { 
          if ( counterIsAtNextMarker(loopCounter + 2, markerLocation)) {
              mapOfLirth[22][loopCounter] = Integer.toString(minNumOfNums).charAt(0);
              minNumOfNums++;
              if (loopCounter == COLUMNS_WITHOUT_MARKERS) { 
                mapOfLirth[22][loopCounter] = '1';
                mapOfLirth[22][loopCounter + 1] = '0'; 
              }
          }
      }

      // Place the row markers ( '---' )
      for (loopCounterRow = 1, markerLocation = 4; loopCounterRow < (MAP_ROWS - 1); loopCounterRow += 2) {
        for (loopCounterColumn = 4; loopCounterColumn < (MAP_COLUMNS - 3); loopCounterColumn++) {
          if ( counterIsAtNextMarker(loopCounterColumn, markerLocation) ) {
            mapOfLirth[loopCounterRow][loopCounterColumn] = ' ';
          }
          else {
            mapOfLirth[loopCounterRow][loopCounterColumn] = '-';
          }
        }
      }

      // Place the column markers ( '|' )
      for (loopCounterRow = 2, markerLocation = 4; loopCounterRow < (MAP_ROWS - 2); loopCounterRow += 2) {
        for (loopCounterColumn = 4; loopCounterColumn < (MAP_COLUMNS - 2); loopCounterColumn++) {
          if ( counterIsAtNextMarker(loopCounterColumn, markerLocation) ) {
            mapOfLirth[loopCounterRow][loopCounterColumn] = '|';
          }
          else {
            mapOfLirth[loopCounterRow][loopCounterColumn] = ' ';
          }
        }
      }
      
      // Place in the directional words <--- I failed, I couldn't figure out how to add these into the loop so I cheated...'

      // North
      mapOfLirth[0][22] = 'N';
      mapOfLirth[0][23] = 'O';
      mapOfLirth[0][24] = 'R';
      mapOfLirth[0][25] = 'T';
      mapOfLirth[0][26] = 'H';

      // South
      mapOfLirth[23][22] = 'S';
      mapOfLirth[23][23] = 'O';
      mapOfLirth[23][24] = 'U';
      mapOfLirth[23][25] = 'T';
      mapOfLirth[23][26] = 'H';

      // East
      mapOfLirth[9][46]  = 'E';
      mapOfLirth[10][46] = 'A';
      mapOfLirth[11][46] = 'S';
      mapOfLirth[12][46] = 'T';

      // West
      mapOfLirth[9][0]  = 'W';
      mapOfLirth[10][0] = 'E';
      mapOfLirth[11][0] = 'S';
      mapOfLirth[12][0] = 'T';

      // Display the map
     for (row = 0; row < MAP_ROWS; row++) {
        for (column = 0; column < MAP_COLUMNS; column++) {
          System.out.print(mapOfLirth[row][column]);
        }
        System.out.println("");
     }
  }

    public static boolean counterIsAtNextMarker(int counter, int markerLocation) {
      return counter % markerLocation == 0;
    }

}
     

// ## Results #####################################################################

    