/* C5_P4.c
    Author: Billy Hart    Last Modified by: Billy Hart
    Assignment: Chapter 5 Project #4
    Date Last Modified: October 24, 2015
    Program Description:
    Prints an n * n magic square.
    Magic Square: A square arrangement of the numbers in which the sums of the 
    rows, columns, and diagonals are all the same.) The user provides the value of n.
*/

/*What it should look like:
This program creates a magic square of a specified size. The size must be an
odd number between 1 and 99.
Enter size of magic square: 5

17  24  01  08  15
23  05  07  14  16
04  06  13  20  22
10  12  19  21  03
11  18  25  02  09


PromtUser()
AskUserForNumber()
DrawMagicSquare()

*/

/* --------------------------------- Includes ---------------------------------- */

#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <ctype.h>

/* ---------------------------- Function Prototypes ---------------------------- */

// Tools
char *ConsoleRead(int maxLengthOfString);



/* -------------------------------- Definitions -------------------------------- */

#define Array_Length(arrayToCheck) (sizeof(arrayToCheck) / sizeof(arrayToCheck[0]))



/* ----------------------------------- Main ------------------------------------ */

int main() {
    // Local Variables
    int magicSquare[99][99];
    int numberToPlace = 1;
    int column = 0;
    int row = 0;

    // Simulated Input
    int userNum = 3;

    // Magic Square Creation

    // First set the column to the center of the first row
    column = (userNum / 2);
    // Next set that centered column value to 1
    magicSquare[row][column] = numberToPlace;
    // Increment the number to place next
    numberToPlace++;

    while (numberToPlace < (userNum * userNum) + 1) {

      // If row goes into -1
      if (row - 1 < 0) {
        // Reset row to last row
        row = userNum - 1;
      }
      else {
        // Otherwise move up a row
        row--;
      }

      // If the column number moves outside the max
      if (column + 1 > userNum) {
        // Reset it to column 0
        column = 0;
      }
      else {
        // Otherwise, move one to the right
        column++;
      }

      // If the spot being moved to already has a number
      if (magicSquare[row][column] != 0)  {
        // Then move back into the row you were in before
        row = 0;
      }

      magicSquare[row][column] = numberToPlace;
      numberToPlace++;
    }

    // Print the 2D array
    int rows = 3;
    int columns = 3;
    int loopCounter1, loopCounter2;

    for (loopCounter1 = 0; loopCounter1 < rows; loopCounter1++) {
      for (loopCounter2 = 0; loopCounter2 < columns; loopCounter2++) {
          printf("%d ", magicSquare[loopCounter1][loopCounter2]);
      }
      printf("\n");
    }

    // Release memory
    printf("\n");
    // system("pause"); //<--------------------------------------- Erase me afterwards
    return (0);
}


/* --------------------------------- Functions --------------------------------- */

char *ConsoleRead(int maxLengthOfString) {
  // Assign memory (casted) to a pointer to hold entered text
  char *rawMessage = (char *)malloc(sizeof(char) * maxLengthOfString);
  // Local memory on the heap to store the user message
  char *userMessage;
  // Read the message (up to max chars) from keyboard and store it
  fgets(userMessage, maxLengthOfString, stdin);
  // Take the read message and copy it into the memory allocated
  strcpy(rawMessage, userMessage);
  // Return the pointer to the character array
  return rawMessage;
}

/* ---------------------------- Compile Run Results ---------------------------- */

//[Finished in 0.1s]
