/* CelsiusToFahrenheit.c
    Author: Billy Hart    Last Modified by: Billy Hart
    Assignment: Chapter 1 Project
    Date Last Modified: September 22, 2015
    Program Description:
    Converts a given Celsius temperature to its Fahrenheit equivalent.
*/

#include <stdio.h>

// Function to perform conversion calculations
float convertCelsiusToFahrenheit(float celsiusTempFromUser);

int main() {
float celsiusTempFromUser; // Temperature input from user
float fahrenheitTemperature; // Fahrenheit equivalent of given temperature

// Simulated Input
celsiusTempFromUser = 22;

// Ask user for Celsius temperature
printf("Enter the celsius temperature: ");

// Store the given input
scanf("%f", &celsiusTempFromUser);

// Function call to convert temperatures
// Store result for display
fahrenheitTemperature = convertCelsiusToFahrenheit(celsiusTempFromUser);

// Display the results to the user
printf("\n");
printf("The Celsius temperature %.1f is equivalent to %.2f\n", celsiusTempFromUser, fahrenheitTemperature);

// Release memory
return (0);
}

float convertCelsiusToFahrenheit(float celsiusTempFromUser) {
  // Local variable to return
  float convertedFarhenheitTemperature;

  // Formula: http://www.farenheittocelsius.com/
  convertedFarhenheitTemperature = (celsiusTempFromUser * 9/5 + 32);

  // Return converted temperature on call
  return(convertedFarhenheitTemperature);
}
