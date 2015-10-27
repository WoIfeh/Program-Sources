/* C5_P4.c
    Author: Billy Hart    Last Modified by: Billy Hart
    Assignment: Chapter 5 Project #4
    Date Last Modified: October 24, 2015
    Program Description:
    Prints an n * n magic square.
    Magic Square: A square arrangement of the numbers in which the sums of the 
    rows, columns, and diagonals are all the same.) The user provides the value of n.
*/

/* --------------------------------- Includes ---------------------------------- */

#include <stdio.h>
#include <stdlib.h>
#include <string.h>

/* ---------------------------- Function Prototypes ---------------------------- */

// Main
int AskUserForNumber();
int **CreateMagicSquare(int sizeOfMagicSquare);

// Tools
int ConsoleRead();


/* ----------------------------------- Main ------------------------------------ */

int main() {
    // Local Variables
    int dimensionOfMagicSquare = 5;
    int **magicSquare;

    // Ask for the dimensions of the Magic Square
    // dimensionOfMagicSquare = AskUserForNumber();

    // Create the Magic Square
    magicSquare = CreateMagicSquare(dimensionOfMagicSquare);

    // Print the Magic Square so the user can see it
    // PrintMagicSquare();


    //Print the 2D array
    int loopCounter1, loopCounter2;

    for (loopCounter1 = 0; loopCounter1 < dimensionOfMagicSquare; loopCounter1++) {
      for (loopCounter2 = 0; loopCounter2 < dimensionOfMagicSquare; loopCounter2++) {
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

int **CreateMagicSquare(int sizeOfMagicSquare) {
  // Local Variables
  int row = 0, column = 0, oldRow, oldColumn;
  int nextNumberInSequence = 1;
  int maxSequenceSize = (sizeOfMagicSquare * sizeOfMagicSquare);

  // Allocate DimensionSize of rows, each row is a pointer to an integer
    int **magicSquare = (int **)malloc(sizeOfMagicSquare * sizeof(int *)); 
    int loopCounter;

    // Allocate DimensionSize of columns, each column is a pointer to an integer
    for (loopCounter = 0; loopCounter < sizeOfMagicSquare; loopCounter++) {
        magicSquare[loopCounter] = (int *)malloc(sizeOfMagicSquare * sizeof(int));
    }

    // First set the column to the center of the first row
    column = (sizeOfMagicSquare / 2);
    // Next set that centered column value to 1
    magicSquare[row][column] = nextNumberInSequence;
    // Increment the number to place next
    nextNumberInSequence++;
 
  // Loop through the array assigning each next value in the magic square
  for ( ; nextNumberInSequence <= maxSequenceSize; nextNumberInSequence++ ) {
    // Keep a copy of previously stored numbers
    oldRow = row;
    oldColumn = column;
    //Move up one row (Decrement to move up)
    row--;
    // Check to see if the row needs to wrap around
    if (row < 0) {
      // Wrap around a row by starting from the last row (sizeOfMagicSquare - 1)
      row = (sizeOfMagicSquare - 1);
    }

    // Move it over one column to the right
    column++;
    // Check to see if column needs wrap around
    if (column == sizeOfMagicSquare) {
      // Wrap around to the first column by just setting it to the first column (0)
      column = 0;
    }

    // Check to see if a number is already occupying the slot
    if (magicSquare[row][column] < 99) {
      // If it is, then put the number directly below the previously stored number
      row = oldRow + 1; // Last numbers row (+1 to go to the next row)
      column = oldColumn;
    }

    // Place the next number in the sequence
    magicSquare[row][column] = nextNumberInSequence;
  }
  return magicSquare;
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
