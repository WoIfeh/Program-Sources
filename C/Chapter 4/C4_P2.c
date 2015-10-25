/* C4_P2.c
    Author: Billy Hart    Last Modified by: Billy Hart
    Assignment: Chapter 4 Project #2
    Date Last Modified: October 2, 2015
    Program Description:
    A set of numbers are taken in and compared. The lowest and highest values from the set are extracted, and all numbers between are displayed to the user in accending order.
*/

#include <stdio.h>

int main() {
// Local Variables
int userNumber = 1;
int minInt = 0, maxInt = 0;

// Ask the user to enter some numbers
  printf("Please enter a series of integers between 1 and 100 inclusive.\n");
  printf("Entering a number outside of that range will end the input process.\n");

while (userNumber >= 1 && userNumber <= 100) {
    printf("Enter Number: ");
    // Store the value given by the user
    scanf("%d", &userNumber);

    if (userNumber < minInt || minInt == 0) {
      minInt = userNumber;
    }
    else if (userNumber > maxInt || minInt == 0) {
      maxInt = userNumber;
    }
}

while (minInt <  maxInt) {
  printf("%d\n", minInt);
  minInt++;
}

// Release memory
return (0);
}

