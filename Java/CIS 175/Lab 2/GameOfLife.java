/*
 * ################################################################################
 * Name: Billy Hart
 * Assignment: Lab #2
 * Date: 02/23/2016 - 04/15/2016
 * Description: Text-only version of game "The Game of Life" using OOP paradigm
 * Version # 2
 * ################################################################################
*/

// Includes
import java.util.*;


// Class is designed to replicate the Game of Life
public class GameOfLife {

	// Main
    public static void main(String[] args) {

    // Local Variables
    boolean CONTINUE_PLAYING = true;
    final char NEXT_GEN_CHAR = 'n';
    GoLBoard mainBoard = new GoLBoard();
    GoLDisplay boardDisplay = new GoLDisplay();
    Scanner userInput = new Scanner(System.in);

        while (CONTINUE_PLAYING) {

            // Display the board
            boardDisplay.displayBoard(mainBoard);

            // Spawn next generation
            mainBoard = mainBoard.nextRound();

            // Determine if the user wants to continue playing
            if (userInput.next().charAt(0) != NEXT_GEN_CHAR )
              CONTINUE_PLAYING = false;
        }
    }
}