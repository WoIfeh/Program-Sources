/* Testing.c
    Author: Billy Hart    Last Modified by: Billy Hart
    Assignment: Chapter 7 Project #1
    Date Last Modified: October 28, 2015
    Program Description:
    Best description I can make for the program
*/

/*What it should look like:



*/

/* --------------------------------- Includes ---------------------------------- */

#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <ctype.h>

/* ---------------------------- Function Prototypes ---------------------------- */

char *ConsoleRead(int maxLengthOfString);


/* -------------------------------- Definitions -------------------------------- */

#define Array_Length(arrayToCheck) (sizeof(arrayToCheck) / sizeof(arrayToCheck[0]))


/* ----------------------------------- Main ------------------------------------ */

int main() {
    // Local Variables


    // Start Pseudo Below



    // Release memory
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

[Finished in 0.1s]
    