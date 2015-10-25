/* C4_P1.c
    Author: Billy Hart    Last Modified by: Billy Hart
    Assignment: Chapter 4 Project #1
    Date Last Modified: October 2, 2015
    Program Description:
    Calculates a persons pay given that the first day of pay would be 1 cent and each
    daythereafter would be doubled. Program restrictions are the user can't enter a
    valid outside the range of 5 - 31 days.
*/

#include <stdio.h>

int main() {
// Local Variables
int numberOfDaysWorked = 1;
int days;
float pay, total;


// Check to make sure the number of days given falls within range
while (numberOfDaysWorked < 5 || numberOfDaysWorked > 31) {
  // Ask the user how many days they are working
  printf("How many days do you plan on working: \n");

  // Store the result
  scanf("%d", numberOfDaysWorked);

  // Simulated Input
  numberOfDaysWorked = 10;
}

// Begin the table
printf("DAY     PAY     TOTAL\n");

// Calculate and display table of days and pay
for (days = 1, pay = 0.01, total = 0.01; days <= numberOfDaysWorked; days++, pay *= 2, total = total + pay) {
  printf("   %d       %.2f       %.2f\n", days, pay, total);
}

// Release memory
return (0);
}