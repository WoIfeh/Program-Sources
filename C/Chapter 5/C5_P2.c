/* C5_P2.c
    Author: Billy Hart    Last Modified by: Billy Hart
    Assignment: Chapter 5 Project #2
    Date Last Modified: October 12, 2015
    Program Description:
    Encrypts a message using character shifting (Caesar cipher)
*/

/* Psuedo */
// userMessage = GetMessageFromUser(); <-- Finished
// encryptyedMessage = EncryptMessage(userMessage); <<
// DisplayEncryptedMessage(encryptedMessage);


// Includes
#include <stdio.h>
#include <stdlib.h>
#include <string.h>

// Function Declarations
int ConsoleRead();
char *ConsoleRead(int maxLengthOfString);
char *GetMessageFromUser();
char * EncryptMessage(char *messageToEncrypt);
void DisplayEncryptedMessage(char *encryptedMessage);

int main() {
// Local Variables
  char *userMessage;
  char *encryptedMessage;

  // Get the message from the user and store it
  userMessage = GetMessageFromUser();

  // Encrypt the message
  encryptedMessage = EncryptMessage(userMessage);

  // Display the new encrypted message
  DisplayEncryptedMessage(encryptedMessage);

  // Release memory
  system("pause");
//  free(*rawMessage);
  return (0);
}

char *GetMessageFromUser(){
  // Local Variable
  const int Max_Length_Of_Message = 80;
  // Ask the user for the message to encrypt
  printf("Enter message to be encrypted: ");
  // Return the message
  return ConsoleRead(Max_Length_Of_Message);
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

int ConsoleRead() {
  // Local Variables
  int numberFromUser;
  // Scarily using scanf() for convenience, ignoring buffer overflow
  scanf("%d", &numberFromUser);
  // Return the entered number
  return numberFromUser;
}

char * EncryptMessage(char *messageToEncrypt) {
  // Local Variables
  int cipherKey, loopCounter;
  int messageLength = strlen(messageToEncrypt);

  // Ask for the number of characters to shift by
  printf("Enter shift amount (1-25): ");

  // Store the number of characters to shift by
  cipherKey = ConsoleRead();

  for (loopCounter = 0; loopCounter <= messageLength; loopCounter++) {

    if (messageToEncrypt[loopCounter] >= 'a' && messageToEncrypt[loopCounter] <= 'z') {
        // Shift the given message over by a certain number of characters
        messageToEncrypt[loopCounter] = (((messageToEncrypt[loopCounter] - 'a') + cipherKey) % 26 + 'a');
    }
    else if (messageToEncrypt[loopCounter] >= 'A' && messageToEncrypt[loopCounter] <= 'Z') {
        // Shift the given message over by a certain number of characters
        messageToEncrypt[loopCounter] = (((messageToEncrypt[loopCounter] - 'A') + cipherKey) % 26 + 'A');
    }
    else {
      messageToEncrypt[loopCounter] = messageToEncrypt[loopCounter];
    }
}
  return messageToEncrypt;
}

void DisplayEncryptedMessage(char *encryptedMessage) {
  printf("Encrypted message: %s\n", encryptedMessage);
}