/* C1_P2.c
    Author: Billy Hart    Last Modified by: Billy Hart
    Assignment: Chapter 1 Project #2
    Date Last Modified: October 1, 2015
    Program Description:
    After taking in an items quantity, cost and tax rate, it calculates both tax
    and total. They are then displayed to the user.
*/

#include <stdio.h>

int main() {

// Local Variables
  float userInputItemCost, userInputTaxRate;
  int userInputItemQuanity;
  float purchaseTax, purchaseTotalWithoutTax, purchaseTotalWithTax;

// Simulated input
  userInputItemCost = 12.99;
  userInputItemQuanity = 3;
  userInputTaxRate = 0.0925;

// Get item quantity
  printf("Enter the item cost: \n");
  scanf("%f", &userInputItemCost);
// Get number of items purchased
  printf("Enter the number of items purchased: \n");
  scanf("%d", &userInputItemQuanity);
// Get the tax rate
  printf("Enter the tax rate: \n");
  scanf("%f", &userInputTaxRate);

// Calculate the total from qunaity (No type cast required)
  purchaseTotalWithoutTax = userInputItemCost * userInputItemQuanity;
// Calculate purchase tax
  purchaseTax = (purchaseTotalWithoutTax * userInputTaxRate);
// Calculate cost total
  purchaseTotalWithTax = purchaseTotalWithoutTax + purchaseTax;

// Print calculated totals to the user
  printf("Purchase amount: %.2f\n", purchaseTotalWithoutTax);
  printf("Tax: %.5f\n", purchaseTax);
  printf("Total: %.5f\n",  purchaseTotalWithTax);

// Release memory
return (0);
}

