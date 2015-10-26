/* C5_P3.c
    Author: Billy Hart    Last Modified by: Billy Hart
    Assignment: Chapter 5 Project #3
    Date Last Modified: October 20, 2015
    Program Description:
    Tests whether two given words are anagrams (permutations of the same letters)
*/

/*What it should look like

Enter first word: smartest
Enter second word: mattress
The two words are anagrams.

Enter first word: dumbest
Enter second word: stumble
The two words are not anagrams.

*/

// Includes
#include <stdio.h> // Used for printf()
#include <stdlib.h> // Used for system(); //<-------------------------------------------------------- Erase me afterwards
#include <string.h> // Used for strcpy()
#include <ctype.h> // Used for isalpha() and tolower()

// Function Declarations
char *ConsoleRead(int maxLengthOfString);
char *GetWordFromUser(int wordOrder);
bool DetermineIfAnagrams(char *wordOne, char *wordTwo);

// Definitions
#define Array_Length(arrayToCheck) (sizeof(arrayToCheck) / sizeof(arrayToCheck[0]))

int main() {
// Local Variables
const int first = 1, second = 2;
char *firstWord, *secondWord;
bool anagramValue = false;

  firstWord = GetWordFromUser(first);
  secondWord = GetWordFromUser(second);
  anagramValue = DetermineIfAnagrams(firstWord, secondWord);



// Release memory
system("pause"); //<---------------------------------------------------------------------------------- Erase me afterwards
return (0);
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

char *GetWordFromUser(int wordOrder){
  // Local Variable
  const int Max_Length_Of_Message = 80;

  // Ask the user for a word based on order
  if (wordOrder == 1) {
    printf("Enter first word: ");
  }
  else  {
    printf("Enter second word: ");
  }
  // Return the message
  return ConsoleRead(Max_Length_Of_Message);
}

bool DetermineIfAnagrams(char *wordOne, char *wordTwo) {
int charInstanceTracker[26] = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
int loopCounter, messageLength = strlen(wordOne);

for (loopCounter = 0; loopCounter < messageLength; loopCounter++) {
  

}




  return true;
}