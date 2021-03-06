/* C5_P3.c
    Author: Billy Hart    Last Modified by: Billy Hart
    Assignment: Chapter 5 Project #3
    Date Last Modified: October 20, 2015
    Program Description:
    Tests whether two given words are anagrams (permutations of the same letters)
*/


/* --------------------------------- Includes ---------------------------------- */

#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <ctype.h>


/* ---------------------------- Function Prototypes ---------------------------- */

// Main
char *GetWordFromUser(int wordOrder);
bool   DetermineIfAnagrams(char *wordOne, char *wordTwo);
void   DisplayAnagramCheckResult(bool anagramValue);

// Tools
char *ConvertWordToLowerCase (char *wordToConvert);
char *ConsoleRead(int maxLengthOfString);


/* -------------------------------- Definitions -------------------------------- */

#define Array_Length(arrayToCheck) (sizeof(arrayToCheck) / sizeof(arrayToCheck[0]))



/* ----------------------------------- Main ------------------------------------ */

int main() {

  // Local Variables
  const int first = 1, second = 2;
  char *firstWord, *secondWord;
  bool anagramValue = false;

  // Ask the user for two words
  firstWord = GetWordFromUser(first);
  secondWord = GetWordFromUser(second);

  // Determine if the two words are an anagram
  anagramValue = DetermineIfAnagrams(firstWord, secondWord);

  // Print the results to the user
  DisplayAnagramCheckResult(anagramValue);

  // Release memory
  system("pause");
  return (0);
}

/* --------------------------------- Functions --------------------------------- */

// Retrieves and stores a string from the user
char *GetWordFromUser(int wordOrder) {

  // Local Variable
  const int Max_Length_Of_Message = 80;

  // Ask the user for a word based on order
  if (wordOrder == 1) {
    printf("Enter first word: ");
  }
  else  {
    printf("Enter second word: ");
  }

  // Return the message as a string
  return ConsoleRead(Max_Length_Of_Message);
}


// Determines if two given strings are anagrams
bool DetermineIfAnagrams(char *wordOne, char *wordTwo) {

  // Local Variable
  int charInstanceTracker[26] = {0};
  int currentCharAsArrayIndexValue, loopCounter;
  int messageLength;
  bool ZeroElement = true;

  // Convert both words to lower case
  wordOne = ConvertWordToLowerCase(wordOne);
  wordTwo = ConvertWordToLowerCase(wordTwo);

  // Compare both words to see if they are the same length
  if ( strlen(wordOne) != strlen(wordTwo) ) { return false; }
  else { messageLength = strlen(wordOne); }


  // Loop through first string, and track how many times each char is encountered
  for (loopCounter = 0; loopCounter < messageLength; loopCounter++) {

      // Current char - 'a' ( 97 ) = index value (0 - 25)
      currentCharAsArrayIndexValue = wordOne[loopCounter] - 'a';

      // Increment the location in the intArray[] that contains the match
      charInstanceTracker[currentCharAsArrayIndexValue]++;
  }
       
  // Repeat the loop but for the second word
  for (loopCounter = 0; loopCounter < messageLength; loopCounter++) {
      currentCharAsArrayIndexValue = wordTwo[loopCounter] - 'a';

      // Decrement the location in the intArray[] that contains the match
      charInstanceTracker[currentCharAsArrayIndexValue]--;
  }

  // reinitialize to 0
  loopCounter = 0; 

  // Loop through the intArray to determine if all elements are 0
  while (loopCounter < Array_Length(charInstanceTracker) && ZeroElement) {

      // If it runs into something other than a 0, break
      if (charInstanceTracker[loopCounter] != 0) { 
        ZeroElement = false; 
      }

        loopCounter++;
  }
  

    // If all elements in the array are 0, return true, else false
    return (ZeroElement) ? true : false;
}


// Displays if the two words are anagrams
void DisplayAnagramCheckResult(bool anagramValue) {

  // If they are anagrams..print that they are
  if (anagramValue) {
    printf("The two words are anagrams.\n");
  }

  // Else..print that they aren't
  else  {
    printf("The two words are not anagrams.\n");
  }
}


// Converts given string to all lower case letters
char *ConvertWordToLowerCase (char *wordToConvert) {

  // Local Variable
  int loopCounter;

  // Loops through each given character of a given string
  for (loopCounter = 0; wordToConvert[loopCounter] != '\0'; loopCounter++) {

      // convert the character to lower case, assign it as type-casted char
      wordToConvert[loopCounter] = (char)tolower(wordToConvert[loopCounter]);
  }

  // return the new string
  return wordToConvert;
}


// Reads a string or line from the user
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