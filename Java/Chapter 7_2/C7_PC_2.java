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
 * 
 * ################################################################################
*/

// Includes
import java.util.Scanner;
import java.util.Random;
import java.util.ArrayList;
import java.io.IOException;

public class C7_PC_2
{
    public static void main(String[] args)  throws IOException, InterruptedException
    {
      // Local Variables
      boolean visible = true;
      int userGuessCoords[];
      ArrayList<int[]> userGuessList = new ArrayList<int[]>();

      // Create the map
      char mapOfLirth[][] = CreateLirhtMap();

      // Place Hurkle in the map
      PlaceHurkleOnMap(mapOfLirth, visible);

      // Display the map
      DisplayMap(mapOfLirth);

      //Display the guess table
      DisplayGuessTable();

      // Ask the user for their guess
      userGuessCoords = GetGuessCoordsFromUser();

      // Store the users score
      userGuessList.add(userGuessCoords);

      // Display the guesses
      // System.out.println("Row: " + userGuessCoords[0] + " Column: " + userGuessCoords[1]);

      // Mark the users guess
      MarkGuessOnMap(mapOfLirth, userGuessCoords[0], userGuessCoords[1]);

      // Display the map
      DisplayMap(mapOfLirth);

    }







    public static int[] GetGuessCoordsFromUser() {
      // Enable User Input
      Scanner userInput = new Scanner(System.in);

      String guessCoords;
      String guesses[];
      int userGuess[] = new int[10];

      // Read entire coord guess (5, 2)
      guessCoords = userInput.nextLine();

      // Separate values by comma
      guesses = guessCoords.split(",");

      // Remove whitespace
      guesses[1] = guesses[1].replaceAll("(^ )|( $)", "");

      // Cast guesses from string to int
      userGuess[0] = Integer.parseInt(guesses[0]);
      userGuess[1] = Integer.parseInt(guesses[1]);

      // Convert their guess to actual coords
      userGuess[0] = 20 - 2 * (userGuess[0] - 1);
      userGuess[1] = (userGuess[1] * 4) + 2;

      // return the guesses as an array
      return userGuess;
    }

    public static void PlaceHurkleOnMap(char map[][], boolean visibilityState)  throws IOException, InterruptedException {
      Random locationGenerator = new Random();
      int rowMin = 2, rowMax = 20;
      int columnMin = 8, columnMax = 42;
      int rowLocation = (locationGenerator.nextInt(rowMax - rowMin + 1) + rowMin) &-2;
      int columnLocation = ((locationGenerator.nextInt(((columnMax + 2) - columnMin) + 1) + columnMin) & -4) -2;
      if (visibilityState == true) {
         new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
         MarkGuessOnMap(map, rowLocation, columnLocation);
         // System.out.print("Row: " + rowLocation + " Column: " + columnLocation);
      }
    }

    public static char[][] MarkGuessOnMap(char map[][], int rowLocation, int columnLocation) {
        map[rowLocation][columnLocation] = 'O';
        return map;
    }


    public static boolean CounterIsAtNextMarker(int counter, int markerLocation) {
      return counter % markerLocation == 0;
    }

    public static void DisplayGuessTable() {
      int loopCounter;

       for (loopCounter = 0; loopCounter < 4; loopCounter++) {
        System.out.println();
       }

      System.out.println("Guess\t\t\tClue");
    }

    public static void ClearConsole() {
      //Invoke cmd and tell it to execute /c cls
      // Directly connect output channel to Java process' using inheritIO()
          
    }

    public static void DisplayMap(char map[][]) {
      // Local Variables
      int row, column, loopCounter;
      final int MAP_ROWS = 24;
      final int MAP_COLUMNS = 47;

      for (row = 0; row < MAP_ROWS; row++) {
         for (column = 0; column < MAP_COLUMNS; column++) {
           System.out.print(map[row][column]);
         }
         System.out.println("");
      }

      return;
    }


    public static char[][] CreateLirhtMap() {
       // Local Variables
       final int MAP_ROWS = 24;
       final int MAP_COLUMNS = 47;
       final int ROWS_WITHOUT_MARKERS = 20;
       final int COLUMNS_WITHOUT_MARKERS = 42;
       char mapOfLirth[][] = new char[MAP_ROWS][MAP_COLUMNS];
       char North[] = {'N', 'O', 'R', 'T', 'H'};
       char South[] = {'S', 'O', 'U', 'T', 'H'};
       char East[] = {'E', 'A', 'S', 'T'};
       char West[] = {'W', 'E', 'S', 'T'};
       int loopCounter, loopCounterRow, loopCounterColumn;
       int minNumOfNums = 1, maxNumOfNums = 9, markerLocation = 4;
       int startOfColumn = 0, endOfColumn = 46;
       int startOfRow = 9, endOfRow = 22;
       int row, column;

        // Initalize all of the map with empty spaces
       for (row = 0; row < MAP_ROWS; row++) {
          for (column = 0; column < MAP_COLUMNS; column++) {
            mapOfLirth[row][column] = ' ';
          }
       }

        // Place the Column numbers
        for (loopCounter = 2, markerLocation = 2; loopCounter <= ROWS_WITHOUT_MARKERS; loopCounter++) {
            if (CounterIsAtNextMarker(loopCounter, markerLocation)) {
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
            if ( CounterIsAtNextMarker(loopCounter + 2, markerLocation)) {
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
            if ( CounterIsAtNextMarker(loopCounterColumn, markerLocation) ) {
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
            if ( CounterIsAtNextMarker(loopCounterColumn, markerLocation) ) {
              mapOfLirth[loopCounterRow][loopCounterColumn] = '|';
            }
            else {
              mapOfLirth[loopCounterRow][loopCounterColumn] = ' ';
            }
          }
        }
      
        // Place in the directional words
        for (loopCounter = 0; loopCounter < North.length; loopCounter++) {
            mapOfLirth[startOfColumn][loopCounter + endOfRow] = North[loopCounter];
            mapOfLirth[endOfRow + 1][loopCounter + endOfRow] = South[loopCounter];
        }
      
        for (loopCounter = 0; loopCounter < East.length; loopCounter++) {
            mapOfLirth[startOfRow + loopCounter][endOfColumn] = East[loopCounter];
            mapOfLirth[startOfRow + loopCounter][startOfColumn] = West[loopCounter];
        }
      
        // Return the array
        return mapOfLirth;
    }
}     

// ## Results #####################################################################

    