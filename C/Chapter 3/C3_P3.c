/* C3_P3.c
    Author: Billy Hart    Last Modified by: Billy Hart
    Assignment: Chapter 3 Project #3
    Date Last Modified: October 2, 2015
    Program Description:
    Prints two given dates in calendar order.
*/

#include <stdio.h>

//Function Declarations
int convertToComparableDate(int month, int day, int year);
int getEarlierDate(int date1, int date2);

int main() {
// Local Variables
  int month1, day1, year1;
  int month2, day2, year2;
  int comparableDate1, comparableDate2;
  int earilerDate;

// Simulated input
month1 = 8, day1 = 18, year1 = 1994;
month2 = 2, day2 = 19, year2 = 1992;

// Ask and store the two dates to compare
  printf("Please enter the first date in format mm/dd/yyyy: \n");
  scanf("%d/%d/%d", &month1, &day1, &year1);

  printf("Please enter the second date in format mm/dd/yyyy: \n");
  scanf("%d/%d/%d", &month2, &day2, &year2);

// Compare the two dates and return the eariler date
  comparableDate1 = convertToComparableDate(month1, day1, year1);
  comparableDate2 = convertToComparableDate(month2, day2, year2);
  earilerDate = getEarlierDate(comparableDate1, comparableDate2);

//Display the ordered dates to the user
  if (earilerDate == 1) {
    printf("%d/%d/%d is earlier than %d/%d/%d\n", month1, day1, year1, month2, day2, year2);
  }
  else {
    printf("%d/%d/%d is earlier than %d/%d/%d\n", month2, day2, year2, month1, day1, year1);
  }

// Release memory
return (0);
}


int convertToComparableDate(int month, int day, int year) {
  return year *10000 + month * 100 + day;
}

int getEarlierDate(int date1, int date2) {
  return (date1 > date2) ? 2 : 1;
}