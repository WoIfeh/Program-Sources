/*
 * ################################################################################
 * Name: Billy Hart
 * Assignment: Lab #1
 * Date: 02/23/16 - 
 * Description: Text-only version of game "The Game of Life" 
 * ################################################################################
*/

// Includes
import java.util.*;


// Class is designed to replicate the Game of Life
public class Lab1 {

  // Settings
  private static final int NEW_LINE = 1, SAME_LINE = 0;
  private static int roundNum = 0;
  private static int numOfRows = 20, numOfColumns = 20;
  private static int numBirths = 0, numDeaths = 0;
  private static boolean initialRun = true, continuePlaying = true;
  private static char[][] Map;
  private static char lifeChar = 'L', deathChar = '-';

    // Main
    public static void main(String[] args) {

      // Local Variables
      Scanner userInput = new Scanner(System.in);

      // Cycle game while user wants to continue playing
      while (continuePlaying) {

        // Run an instance of the game
        NextRound();

        // Determine if the user wants to continue playing
        if (!userInput.nextLine().equals("n")) {
          ConsoleWrite("Thank you for playing.", NEW_LINE);
          continuePlaying = false;
        }
        else {
          //ClearConsole();
        }

      }
      
    }


  // Methods ======================================================================

  // Checks to see if this is the first run of the game, if it is then it generates
  // the map and updates all of the entities before displaying it. If the user then
  // wishes to continue playing, it updates round count and lives/deaths after 
  // applying the game's rules. 
      public static void NextRound() {

        // Increase the round count
        roundNum++;

        // Alert the user to the current round
        ConsoleWrite("--------------- Round " + roundNum +
                     " ---------------", NEW_LINE);

        // Check to see if it's the first run
        if (initialRun) {
          // Set flag to false
          initialRun = false;

          // Create the map
          Map = GenerateMap(numOfRows, numOfColumns);

          // Display the map
          DisplayMap(Map);
        }
        else {
          // Update the map
          ApplyRulesToMap(Map);

          // Display the number of births and deaths
          ConsoleWrite("Births: " + numBirths + " Deaths: " + numDeaths, NEW_LINE);

          // Display the map
          DisplayMap(Map);
        }

      }

  // Applies the game's rules to the map
    public static char[][] ApplyRulesToMap(char[][] Map) {

      // Local Variables
      int mapRowLength    = Map.length - 1;
      int mapColumnLength = Map[0].length - 1;
      int numAlive = 0;
      boolean stateOfCell = false;
      numBirths = 0;
      numDeaths = 0;

      // Blank map for oringinal value comparisons
      boolean[][] mapCopy = new boolean[numOfRows][numOfColumns];

      // Loop through each element of the original map, and create a duplicate
      // with boolean values to mimic life (true) and death (false)
      for (int row = 0; row <= mapRowLength; row++) {
        for (int column = 0; column <= mapColumnLength; column++) {
            mapCopy[row][column] = (Map[row][column] == lifeChar) ? true : false;
        }
      }
     
      // Loop through each element of the map
      for (int row = 0; row <= mapRowLength; row++) {
        for (int column = 0; column <= mapColumnLength; column++) {
          numAlive = 0;
        // Check Corners ----------------------------------------------------------
         
          // Top Left Corner [0,0]
          if (row == 0 && column == 0 ) {       
            // ConsoleWrite("I was in the top left corner", NEW_LINE);
              if (mapCopy[row + 1][column]) numAlive++;     // Below
              if (mapCopy[row][column + 1]) numAlive++;     // Right
              if (mapCopy[row + 1][column + 1]) numAlive++; // Below Right
          }

          // Top Right Corner [0, 19]
          else if (row == 0 && column == mapColumnLength) {
            // ConsoleWrite("I was in the top right corner", NEW_LINE);
               if (mapCopy[row + 1][column]) numAlive++;     // Below
               if (mapCopy[row][column - 1]) numAlive++;     // Left
               if (mapCopy[row + 1][column - 1]) numAlive++; // Below Left
          }

          // Bottom Left Corner
          else if (row == mapRowLength && column == 0) {
            // ConsoleWrite("I was in the bottom left corner", NEW_LINE);
               if (mapCopy[row - 1][column]) numAlive++;     // Above
               if (mapCopy[row][column + 1]) numAlive++;     // Right
               if (mapCopy[row - 1][column + 1]) numAlive++; // Above Right
          }

          // Bottom Right Corner
          else if (row == mapRowLength && column == mapColumnLength) {
            // ConsoleWrite("I was in the bottom right corner", NEW_LINE);
               if (mapCopy[row - 1][column]) numAlive++;     // Above
               if (mapCopy[row][column - 1]) numAlive++;     // Left
               if (mapCopy[row - 1][column - 1]) numAlive++; // Above Left
          }

        // Check Columns ----------------------------------------------------------

          // Left Column
          else if (row > 0 && column == 0 && row <= mapRowLength) {
            // ConsoleWrite("I was in the left column", NEW_LINE);
               if (mapCopy[row - 1][column]) numAlive++;     // Above
               if (mapCopy[row + 1][column]) numAlive++;     // Below
               if (mapCopy[row][column + 1]) numAlive++;     // Right
               if (mapCopy[row - 1][column + 1]) numAlive++; // Above Right
               if (mapCopy[row + 1][column + 1]) numAlive++; // Below Right
          }

          // Right Column
          else if (row > 0 && column == mapColumnLength && row <= mapRowLength) {
            // ConsoleWrite("I was in the right column", NEW_LINE);
               if (mapCopy[row][column - 1]) numAlive++;     // Left
               if (mapCopy[row - 1][column]) numAlive++;     // Above
               if (mapCopy[row + 1][column]) numAlive++;     // Below
               if (mapCopy[row - 1][column - 1]) numAlive++; // Above Left
               if (mapCopy[row + 1][column - 1]) numAlive++; // Below Left
          }

        // Check Rows -------------------------------------------------------------

          // Top Row
          else if (row == 0 && column > 0 && column <= mapColumnLength) {
            // ConsoleWrite("I was in the top row", NEW_LINE);
               if (mapCopy[row + 1][column]) numAlive++;     // Below
               if (mapCopy[row][column - 1]) numAlive++;     // Left
               if (mapCopy[row][column + 1]) numAlive++;     // Right
               if (mapCopy[row + 1][column - 1]) numAlive++; // Below Left
               if (mapCopy[row + 1][column + 1]) numAlive++; // Below Right
          }

          // Bottom Row
          else if (row == mapRowLength && column > 0 && column <= mapColumnLength) {
            // ConsoleWrite("I was in the bottom row", NEW_LINE);
               if (mapCopy[row - 1][column]) numAlive++;     // Above
               if (mapCopy[row][column - 1]) numAlive++;     // Left
               if (mapCopy[row][column + 1]) numAlive++;     // Right
               if (mapCopy[row - 1][column - 1]) numAlive++; // Above Left
               if (mapCopy[row - 1][column + 1]) numAlive++; // Above Right
          }

        // Middle Cells -----------------------------------------------------------

          else {
            // ConsoleWrite("I was somewhere in the middle", NEW_LINE);
               if (mapCopy[row + 1][column]) numAlive++;     // Below
               if (mapCopy[row - 1][column]) numAlive++;     // Above
               if (mapCopy[row][column - 1]) numAlive++;     // Left
               if (mapCopy[row][column + 1]) numAlive++;     // Right
               if (mapCopy[row - 1][column - 1]) numAlive++; // Above Left
               if (mapCopy[row - 1][column + 1]) numAlive++; // Above Right
               if (mapCopy[row + 1][column - 1]) numAlive++; // Below Left
               if (mapCopy[row + 1][column + 1]) numAlive++; // Below Right
          }
        stateOfCell = mapCopy[row][column];
        if (stateOfCell) {
          if (numAlive > 3 || numAlive < 2) {
            Map[row][column] = deathChar;
            numDeaths++;
          } 
        } else  {
          if (numAlive == 3) {
            Map[row][column] = lifeChar;
            numBirths++;
          }
        }
        // ConsoleWrite("Element [" + row + ", " + column + "] is " + (stateOfCell ? "alive" : "dead") + " and surrounded by " + 
                     // numAlive + " live cells.", NEW_LINE);

        

        }
      }
      return Map;
    }

  // Creates an array based on a given sizes, and populates it randomly with life
    public static char[][] GenerateMap(int Rows, int Columns) {
    
      // Local Variables
      int seed = 10; 
      Random randomLifeOrDeath = new Random(seed);

      // Create the empty array
      char[][] firstMap = new char[Rows][Columns];

      // Iterate through the array and populate it based on a random true or false
      // value
      for (int row = 0; row < Rows; row++)
        for (int column = 0; column < Columns; column++)
          firstMap[row][column] = randomLifeOrDeath.nextBoolean() ? 
          lifeChar : deathChar;

      // Return the array
      return firstMap;
    }


  // Iterate through an array and print all of its elements using special
  // formatting. 
    public static void DisplayMap(char[][] Map) {

      // Local Variables
      int mapRowLength    = Map.length;
      int mapColumnLength = Map[0].length;

      // Iterate through and display the contents at each index in the console
      for (int row = 0; row < mapRowLength; row++) {
        for (int column = 0; column < mapColumnLength; column++) {
            ConsoleWrite(Map[row][column] + " ", 0);
        }
        ConsoleWrite("", NEW_LINE);
      }
    }


// Tools / Helpers ----------------------------------------------------------------

  // Lessens the wordiness of the System.out.print() and System.out.println() 
  // methods by becoming a wrapper function that handles either case based on 
  // parameter passed.
    public static void ConsoleWrite(String userString, int newLineToggle) {
        if (newLineToggle == NEW_LINE) {
            System.out.println(userString);
        }
        else {
          System.out.print(userString);
        }
    }
  // Overloaded to handle ints
    public static void ConsoleWrite(int userNum, int newLineToggle) {
      if (newLineToggle == NEW_LINE) {
          System.out.println(userNum);
      }
      else {
        System.out.print(userNum);
      }
    }

  // Clears the console screen by sending new lines
    public static void ClearConsole() {
      for (int count = 0; count < 20; count++) {
        ConsoleWrite("", NEW_LINE);
      }
    }

} // End of Class