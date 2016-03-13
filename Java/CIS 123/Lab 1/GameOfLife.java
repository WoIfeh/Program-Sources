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
public class GameOfLife {

  // Settings
  private static final int NEW_LINE = 1, SAME_LINE = 0;
  private static int ROUND_NUM = 0;
  private static int NUM_OF_ROWS = 20, NUM_OF_COLUMNS = 20;
  private static int NUM_BIRTHS = 0, NUM_DEATHS = 0;
  private static boolean INITIAL_RUN = true, CONTINUE_PLAYING = true;
  private static char[][] FIRST_GEN_MAP;
  private static char LIFE_CHAR = '0', DEATH_CHAR = ' ', NEXT_GEN_CHAR = 'n';
  private static int MAP_NUM = 5;

    // Main
    public static void main(String[] args) {

      // Local Variables
      Scanner userInput = new Scanner(System.in);

      // Cycle game while user wants to continue playing
      while (CONTINUE_PLAYING) {

        // Run an instance of the game
        NextGen();

        // Determine if the user wants to continue playing
        if (userInput.next().charAt(0) != NEXT_GEN_CHAR ) {

          /* DEBUG: ConsoleWrite("Thank you for playing.", NEW_LINE); */

          // Exit the loop if the user doesn't press the NEXT_GEN_CHAR
          CONTINUE_PLAYING = false;
        }
        else {
          // Artificial cls using newline spam
          ClearConsole();
        }

      }
      
    }


  // Methods ======================================================================

  // Checks to see if this is the first run of the game, if it is then it generates
  // the map and updates all of the entities before displaying it. If the user then
  // wishes to continue playing, it updates round count and lives/deaths after 
  // applying the game's rules. 
      public static void NextGen() {

        // Increase the round count
        ROUND_NUM++;

        // Alert the user to the current round
        ConsoleWrite("--------------- Round " + ROUND_NUM +
                     " ---------------", NEW_LINE);

        // Check to see if it's the first run
        if (INITIAL_RUN) {
          // Set flag to false, so next run skips this
          INITIAL_RUN = false;

          // Initiate the first instance of the map
          FIRST_GEN_MAP = GenerateMap(NUM_OF_ROWS, NUM_OF_COLUMNS);

          // Display the map
          DisplayMap(FIRST_GEN_MAP);
        }
        else {
          // Update the map after appling the game's rules
          ApplyRulesToMap(FIRST_GEN_MAP);

          // Display the number of births and deaths
          ConsoleWrite("Births: " + NUM_BIRTHS + " Deaths: " + NUM_DEATHS, NEW_LINE);

          // Display the map
          DisplayMap(FIRST_GEN_MAP);
        }

      }

  // Applies the game's rules to the map
    public static char[][] ApplyRulesToMap(char[][] FIRST_GEN_MAP) {

      // Local Variables
      int mapRowLength    = FIRST_GEN_MAP.length - 1;
      int mapColumnLength = FIRST_GEN_MAP[0].length - 1;
      int numAlive = 0;
      boolean stateOfCell = false;
      NUM_BIRTHS = 0;
      NUM_DEATHS = 0;

      // Blank map for original value comparisons
      boolean[][] mapCopy = new boolean[NUM_OF_ROWS][NUM_OF_COLUMNS];

      // Loop through each element of the original map, and create a duplicate
      // with boolean values to mimic life (true) and death (false)
      for (int row = 0; row <= mapRowLength; row++) {
        for (int column = 0; column <= mapColumnLength; column++) {
          mapCopy[row][column] = (FIRST_GEN_MAP[row][column] == LIFE_CHAR) ? 
            true : false;
        }
      }
     
      // Loop through each element of the map
      for (int row = 0; row <= mapRowLength; row++) {
        for (int column = 0; column <= mapColumnLength; column++) {
          numAlive = 0;

          // Check neighboring cells for cell status

          // Above Left
          if (row != 0 && column != 0 && mapCopy[row - 1][column - 1]) numAlive++;
          // Above
          if (row != 0 && mapCopy[row - 1][column]) numAlive++;
          // Above Right
          if (column != mapColumnLength && row != 0 && 
                                         mapCopy[row - 1][column + 1]) numAlive++;
          // Left
          if (column != 0 && mapCopy[row][column - 1]) numAlive++;
          // Right 
          if (column != mapColumnLength && mapCopy[row][column + 1]) numAlive++;
          // Below Left
          if (column != 0 && row != mapRowLength && 
                                         mapCopy[row + 1][column - 1]) numAlive++;
          // Below
          if (row != mapRowLength && mapCopy[row + 1][column]) numAlive++;
          // Below Right
          if (column != mapColumnLength && row != mapRowLength && 
                                         mapCopy[row + 1][column + 1]) numAlive++;

          // Check to see if the current cell is alive or dead
          stateOfCell = mapCopy[row][column];
          if (stateOfCell) {

            // If there is more than 3 or less than 2 neighbors
            if (numAlive > 3 || numAlive < 2) {

              // Kill the cell
              FIRST_GEN_MAP[row][column] = DEATH_CHAR;

              // Increase the death count
              NUM_DEATHS++;
            } 
          } 
          else  {

            // If the cell is dead but has 3 live neighbors
            if (numAlive == 3) {

              // Bring the cell to life
              FIRST_GEN_MAP[row][column] = LIFE_CHAR;

              // Increase the births count
              NUM_BIRTHS++;
            }
          }
          /* DEBUG: ConsoleWrite("Element [" + row + ", " + column + "] is " + 
                    (stateOfCell ? "alive" : "dead") + " and surrounded by " + 
                    numAlive + " live cells.", NEW_LINE);
          */
        }
      }
      return FIRST_GEN_MAP;
    }

  // Creates an array based on a given sizes, and populates it randomly with life
    public static char[][] GenerateMap(int Rows, int Columns) {
    
      // Local Variables
      Random randomLifeOrDeath = new Random(MAP_NUM);

      // Create the empty array
      char[][] firstMap = new char[Rows][Columns];

      // Iterate through array, populate based on a random true or false value
      for (int row = 0; row < Rows; row++)
        for (int column = 0; column < Columns; column++)
          // Fetch random boolean, assign it as living or dead cell
          firstMap[row][column] = randomLifeOrDeath.nextBoolean() ? 
            LIFE_CHAR : DEATH_CHAR;

      // Return the array
      return firstMap;
    }


  // Iterate through array, print all elements using special formatting. 
    public static void DisplayMap(char[][] FIRST_GEN_MAP) {

      // Local Variables
      int mapRowLength    = FIRST_GEN_MAP.length;
      int mapColumnLength = FIRST_GEN_MAP[0].length;

      // print the contents at each index in the console
      for (int row = 0; row < mapRowLength; row++) {
        for (int column = 0; column < mapColumnLength; column++) {
            ConsoleWrite(FIRST_GEN_MAP[row][column] + " ", 0);
        }
        ConsoleWrite();
      }
    }


// Tools / Helpers ----------------------------------------------------------------

  // Lessens the wordiness of the System.out.print() and System.out.println() 
  // methods by becoming a wrapper function that handles either case based on 
  // parameter passed.
    private static void ConsoleWrite() {
        System.out.println();
    }

    // Main
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
    
    // Overloaded to handle floats
    private static void ConsoleWrite(float userFloat, int newLineToggle) {
      if (newLineToggle == 1) {
        System.out.println(userFloat);
      }
      else {
        System.out.print(userFloat);
      }
    }

  // Clears the console screen by spamming new lines
    public static void ClearConsole() {
      for (int count = 0; count < 20; count++) {
        ConsoleWrite();
      }
    }

} // End of Class