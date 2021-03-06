/* C3_P2.c
    Author: Billy Hart    Last Modified by: Billy Hart
    Assignment: Chapter 3 Project #2
    Date Last Modified: October 2, 2015
    Program Description:
    Four integer values are given by the user, which are then compared. The largest and
    smallest numbers of the set are returned and displayed to the user.
*/

#include <stdio.h>

int main() {
// Local Variables
  int input1, input2, input3, input4, min, min2, max, max2;
  int smallestValue, largestValue;

// Simulated Input
  input1 = 5, input2 = 5, input3 = 0, input4 = 5;

// Ask the user to supply the set of numbers
  printf("Enter 4 numbers separated by commas (eg...1, 2, 3, 4): \n");

// Store their values accordingly
  scanf("%d, %d, %d, %d", &input1, &input2, &input3, &input4);

// Compare the values to determine the smallest and largest values.
// Algorithm solves using 4 if statements
  if (input1 > input2) {max = input1; min = input2;}  else {max = input2; min = input1;}
  if (input3 > input4) {max2 = input3; min2 = input4;}  else {max2 = input4; min2 = input3;}
  if (max < max2) {largestValue = max2;}  else {largestValue = max;}
  if (min > min2) {smallestValue = min2;}  else {smallestValue = min;}

// Display Smallest and Largest values from the set
  printf("The smallest value from the set is %d, and the largest is %d\n",
            smallestValue, largestValue);

// Release memory
return (0);
}