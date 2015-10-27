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

*/

/* --------------------------------- Includes ---------------------------------- */

#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <ctype.h>

/* ---------------------------- Function Prototypes ---------------------------- */

// Main
int AskUserForNumber();

// Tools
int ConsoleRead();



/* -------------------------------- Definitions -------------------------------- */

#define Array_Length(arrayToCheck) (sizeof(arrayToCheck) / sizeof(arrayToCheck[0]))



/* ----------------------------------- Main ------------------------------------ */

int main() {
    // Local Variables
    int magicSquare[99][99];
    int dimensionOfMagicSquare;

    // Ask for the dimensions of the Magic Square
    dimensionOfMagicSquare = AskUserForNumber();
    magicSquare = CreateMagicSquare(dimensionOfMagicSquare);
    // PrintMagicSquare();

    // Simulated Input
    int userNum = dimensionOfMagicSquare;
    int maxSequenceSize = userNum*userNum;




    // Print the 2D array
    int rows = userNum;
    int columns = userNum;
    int loopCounter1, loopCounter2;

    for (loopCounter1 = 0; loopCounter1 < rows; loopCounter1++) {
      for (loopCounter2 = 0; loopCounter2 < columns; loopCounter2++) {
          printf("%d\t", magicSquare[loopCounter1][loopCounter2]);
      }
      printf("\n");
    }

    // Release memory
    printf("\n");
    system("pause"); //<--------------------------------------- Erase me afterwards
    return (0);
}


/* --------------------------------- Functions --------------------------------- */

int AskUserForNumber() {
  printf("This program creates a magic square of a specified size. ");
  printf("The size must be an\n odd number between 1 and 99.\n");
  printf("Enter size of magic square: ");
  return ConsoleRead();
}

CreateMagicSquare(dimensionOfMagicSquare) {
  // Local Variables
  int nextNumberInSequence = 1;
  int column = 0;
  int row = 0;
  int oldRow, oldColumn;

  // First set the column to the center of the first row
  column = (userNum / 2);
  // Next set that centered column value to 1
  magicSquare[row][column] = nextNumberInSequence;
  // Increment the number to place next
  nextNumberInSequence++;


  

  for ( ; nextNumberInSequence <= maxSequenceSize; nextNumberInSequence++ ) {
    // Keep a copy of previously stored numbers
    oldRow = row;
    oldColumn = column;
    //Move up one row (Decrement to move up)
    row--;
    // Check to see if the row needs to wrap around
    if (row < 0) {
      // Wrap around a row by starting from the last row (userNum - 1)
      row = (userNum - 1);
    }

    // Move it over one column to the right
    column++;
    // Check to see if column needs wrap around
    if (column == userNum) {
      // Wrap around to the first column by just setting it to the first column (0)
      column = 0;
    }

    // Check to see if a number is already occupying the slot
    if (magicSquare[row][column] != 0) {
      // If it is, then put the number directly below the previously stored number
      row = oldRow + 1; // Last numbers row (+1 to go to the next row)
      column = oldColumn;
    }

    // Place the next number in the sequence
    magicSquare[row][column] = nextNumberInSequence;
  }
}


int ConsoleRead() {
  // Local Variables
  int numberFromUser;
  // Scarily using scanf() for convenience, ignoring buffer overflow
  scanf("%d", &numberFromUser);
  // Return the entered number
  return numberFromUser;
}

/* ---------------------------- Compile Run Results ---------------------------- */

//[Finished in 0.1s]
