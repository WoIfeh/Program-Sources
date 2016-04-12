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

    // Local Variables
    Scanner userInput = new Scanner(System.in);
    boolean CONTINUE_PLAYING = true;
    char NEXT_GEN_CHAR = 'n';
    GoLBoard testingBoard = new GoLBoard();

        while (CONTINUE_PLAYING) {
            // Run an instance of the game
            GoLDisplay.displayBoard(testingBoard);

            // Determine if the user wants to continue playing
            if (userInput.next().charAt(0) != NEXT_GEN_CHAR )
              CONTINUE_PLAYING = false;
        }

    



    }
}