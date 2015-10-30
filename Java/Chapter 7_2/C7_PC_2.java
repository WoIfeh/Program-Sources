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


      // Map has 24 rows and 47 columns
      final int MAP_ROWS = 24;
      final int MAP_COLUMNS = 47;
      char mapOfLirth[][] = new char[MAP_ROWS][MAP_COLUMNS];
      int loopCounterRow, loopCounterColumn, loopCounter;
      int maxNumOfNums = 9, minNumOfNums = 1;
      int row, column;

      // Initalize all of the map with empty spaces
     for (row = 0; row < MAP_ROWS; row++) {
        for (column = 0; column < MAP_COLUMNS; column++) {
          mapOfLirth[row][column] = ' ';
        }
     }

      // Place the Column numbers
      for (loopCounter = 2; loopCounter <= (MAP_COLUMNS / 2.35); loopCounter++) {
          if (loopCounter % 2 == 0) {
              if (loopCounter == 2) {
                mapOfLirth[loopCounter][loopCounter - 1] = '1';
                mapOfLirth[loopCounter][loopCounter]      = '0';
              }
              else {
                mapOfLirth[loopCounter][2]   = (char)(maxNumOfNums + 48);
                maxNumOfNums--;
              }
          }
      }

      // Place the Row numbers
      for (loopCounter = 6; loopCounter <= (MAP_ROWS * 1.75); loopCounter++) {
          if ((loopCounter + 2)% 4 == 0) {
              mapOfLirth[22][loopCounter] = (char)(minNumOfNums + 48);
              minNumOfNums++;
              if (loopCounter == 42) {
                mapOfLirth[22][loopCounter] = '1';
                mapOfLirth[22][loopCounter + 1] = '0';
              }
          }
      }

      // Place the row markers ( '---' )
      for (loopCounterRow = 1; loopCounterRow < (MAP_ROWS - 1); loopCounterRow += 2) {
        for (loopCounterColumn = 4; loopCounterColumn < (MAP_COLUMNS - 3); loopCounterColumn++) {
          if (loopCounterColumn % 4 != 0) {
            mapOfLirth[loopCounterRow][loopCounterColumn] = '-';
          }
          else {
            mapOfLirth[loopCounterRow][loopCounterColumn] = ' ';
          }
        }
      }

      // Place the column markers ( '|' )
      for (loopCounterRow = 2; loopCounterRow < (MAP_ROWS - 2); loopCounterRow += 2) {
        for (loopCounterColumn = 4; loopCounterColumn < (MAP_COLUMNS - 2); loopCounterColumn++) {
          if (loopCounterColumn % 4 != 0) {
            mapOfLirth[loopCounterRow][loopCounterColumn] = ' ';
          }
          else {
            mapOfLirth[loopCounterRow][loopCounterColumn] = '|';
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
























        // Exit
        System.exit(0);
    }
}

// ## Results #####################################################################

    