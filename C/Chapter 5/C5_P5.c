/* C5_P5.c
    Author: Billy Hart    Last Modified by: Billy Hart
    Assignment: Chapter 5 Project #4
    Date Last Modified: October 29, 2015
    Program Description:
    Converts a binary sequence to decimal with bit shifting options.
*/

/*What it should look like:

Input an 8 bit binary number: 10111000
Input rotate value (0-7): 3
LEFT ROTATED RESULT: 11000101
DECIMAL: 197

*/

/* --------------------------------- Includes ---------------------------------- */

#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <ctype.h>

/* ---------------------------- Function Prototypes ---------------------------- */

// Main
int   getRotateValue();
int   convertFromOctalToDecimal(int rotatedBinaryArray[]);
int  *getBinaryNumber();
int  *rotateBinaryNumber(int binaryArray[], int rotateValue);
void  displayRotatedBinaryNumber(int rotatedBinaryArray[]);
void  displayDecimalVersion(int decimalValue);

// Tools
char *ConsoleRead(int maxLengthOfString);



/* -------------------------------- Definitions -------------------------------- */

#define Array_Length(arrayToCheck) (sizeof(arrayToCheck) / sizeof(arrayToCheck[0]))



/* ----------------------------------- Main ------------------------------------ */

int main() {

    // Local Variables
    int *userBinaryNumber;
    int *rotatedBinaryNumber;
    int rotateValue;
    int decimalVersionOfNumber;

    // Ask for the binary sequence
    userBinaryNumber = getBinaryNumber();

    // Print the binary array
    int loopCounter;
    for (loopCounter = 0; loopCounter < 8; loopCounter++) {
      printf("%c", userBinaryNumber[loopCounter]);
    }

/*
    // Ask for the number of characters to rotate the array
    rotateValue = getRotateValue();

    // Return the new array after rotation
    rotatedBinaryNumber = rotateBinaryNumber(userBinaryNumber, rotateValue);

    // Display the new array
    displayRotatedBinaryNumber(rotatedBinaryNumber);

    // Convert the binary int array into decimal 
    decimalVersionOfNumber = convertFromOctalToDecimal(rotatedBinaryNumber);

    // Display the decimal value
    displayDecimalVersion(decimalVersionOfNumber);
*/

    // Release memory
    printf("\n");
    system("pause"); //<--------------------------------------- Erase me afterwards
    return (0);
}


/* --------------------------------- Functions --------------------------------- */

int* getBinaryNumber() {
  // Local Variables
  const int binaryLength = 8;
  char binaryAsString[binaryLength];
  int binaryArray[binaryLength];
  int loopCounter;

  // Ask the user for a binary number:
  printf("Input an 8 bit binary number: ");
  scanf("%s", binaryAsString);

  // Store the result in an int array
  for (loopCounter = 0; loopCounter < binaryLength; loopCounter++) {
    binaryArray[loopCounter] = int(binaryAsString[loopCounter]);
  }

  // Return the users binary set
  return (int *)binaryArray;
}


int getRotateValue() {
  // Local Variables
  int usersRotateValue;

  // Prompt for the rotate value
  printf("Input rotate value (0-7): \n");

  // Store the value recieved from the user
  //return scanf("%d", &usersRotateValue);

  // Simulated Input
  usersRotateValue = 3;

  // Return the value retrived by the user
  return usersRotateValue;
}


int* rotateBinaryNumber(int binaryArray[], int rotateValue) {
  // Local Variables
  int *rotatedBinaryArray;

  printf("Fix Me: rotateBinaryNumber()\n");

  // Return the rotated array
  return rotatedBinaryArray;
}


void displayRotatedBinaryNumber(int rotatedBinaryArray[]) {
  printf("LEFT ROTATED RESULT: ");
  printf("Fix Me: displayRotatedBinaryNumber()\n");
  return;
}


int convertFromOctalToDecimal(int rotatedBinaryArray[]) {
  // Local Variables
  int decimalValue;

  printf("Fix Me: convertFromOctalToDecimal()\n");

  // Return the decimal value equivalent
  return decimalValue;
}


void displayDecimalVersion(int decimalValue) {
  printf("DECIMAL: %d\n", decimalValue);
  return;
}


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
    