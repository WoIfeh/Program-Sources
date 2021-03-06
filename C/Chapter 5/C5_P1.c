/* C5_P1.c
    Author: Billy Hart    Last Modified by: Billy Hart
    Assignment: Chapter 5 Project #1
    Date Last Modified: October 11, 2015
    Program Description:
    Reveres the order of words in a given sentence.
*/

#include <stdio.h>
#include <string.h>

// Function Declarations
bool notTerminatingChar(char currentCharacter);

int main() {
  // Local Variables
  char userSentence[128];
  char userSentencesTerminatingChar; // What ended the users sentence
  char terminatingChar[] = {'.', '?', '!'}; // Different types of terminating characters
  bool notTerminatingChar = true; // While loop break
  int loopCounter = 0; // character increment
  int wordStart  = 0, wordEnd = 0, badCounter = 0; // reversed word trackers

  // Ask the user to enter a sentence to swap
  printf("Enter a sentence: ");

  // Store the given sentence as a char array
  fgets(userSentence, sizeof(userSentence), stdin);

  // Loop through the sentence storing each character one by one
  while (notTerminatingChar)
  {
    // Check to see if the terminating character is a ' . '
    if (userSentence[loopCounter] == terminatingChar[0]) {
      notTerminatingChar = false;
      userSentencesTerminatingChar = terminatingChar[0];
    }

    // Check to see if the terminating character is a ' ? '
    if (userSentence[loopCounter] == terminatingChar[1]) {
      notTerminatingChar = false;
      userSentencesTerminatingChar = terminatingChar[1];
    }

    // Check to see if the terminating character is a ' ! '
    if (userSentence[loopCounter] == terminatingChar[2]) {
      notTerminatingChar = false;
      userSentencesTerminatingChar = terminatingChar[2];
    }
    // Increment the counter
    loopCounter++;
  }

  // Print intro to let the user know what's being displayed
  printf("Reversed: ");

  // Loop backwards through the array, printing at each whitespace
  for (loopCounter -= 2, wordEnd = loopCounter; loopCounter >= 0; loopCounter--)
  {
    // if a white space is encountered or the loop finishes
    if (userSentence[loopCounter] == ' ' || loopCounter == 0)
    {
      // then the start of the word is the char index of the whitespace plus 1
      wordStart = (loopCounter != 0) ? loopCounter + 1 : loopCounter;
      // Loop from the start of the word to the end, printing each character
      for (badCounter = wordStart; badCounter <= wordEnd; badCounter++) {
        printf("%c", userSentence[badCounter]);
      }
      // If the counter isn't finished, print a space, otherwise print the terminating character
      printf("%c", (loopCounter != 0 ? ' ' : userSentencesTerminatingChar) );
      // decrement the loop counter
      wordEnd = loopCounter - 1;
    }
  }

// Release memory
return (0);
}