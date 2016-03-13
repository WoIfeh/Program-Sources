/*
 * ##################################################################
 * Billy Hart
 * Chapter: NaN
 * Assignment: Programming Challenge
 * Date: 10/14/15
 * Description: Adds two numbers given by the user and then displays them
 * ##################################################################
*/

/*_____- * - Grade - * -_____
 |                                         |
 |                                         |
 |                                         |
 |                                         |
 |_______________________|
*/

/*
 * ## Pseudo #########################################################
 *
 * ##################################################################
*/

// Includes
//import.java.util.Scanner;

public class Testing
{
    public static void main(String[] args)
    {
      userTempInFahrenheit = getTempFromUser();
      tempInCelsius = convertTempToCelsius(userTempInFahrenheit);
      display(tempInCelsius)
    }
}








public static int getNumberFromUser() {
  // Local Variables
  int numberFromUser;

  ConsoleWrite("Enter a Number: ", 0);
  return scanf("%d", numberFromUser);
}

public static int calculateSumOf(number1, number2){
  return number1 + number2;
}

public static void displayCalcuatedSumOf(int total){
  ConsoleWrite("Total is:" + total, 0);
}