/*
 * ################################################################################
 * Name: Billy Hart
 * Chapter: 8
 * Assignment: Programming Challenge #5
 * Date: 10/06/15
 * Description: Demonstrates the Month class by creating and manipulating month 
 *              objects.
 * ################################################################################
*/

/*_____- * - Grade - * -_____
 |                           |
 |                           |
 |                           |
 |                           |
 |                           |
 |___________________________|
*/

/*
 * ## Pseudo ######################################################################
 * Demonstrate:
 *              getMonthName()
 *              getMonthNumber()
 *              setMounthNumber()
 *              toString()
 *              equals()
 *              greaterThan()
 *              lessThan()
 * ################################################################################
*/

public class C8_PC_5
{
    public static void main(String[] args)
    {
      // Local Variables
      Month goodMonth = new Month();
      Month badMonth = new Month("February");
      Month greatMonth = new Month("august");
      Month terribleMonth = new Month(3);


      // getMonthName() and getMonthNumber()
      System.out.println(goodMonth.getMonthName() + 
      " as a number representation is " + goodMonth.getMonthNumber() + ".");

      // setMonthNumber()
      System.out.print(goodMonth.getMonthName() + " has been changed to ");
        goodMonth.setMonthNumber(7);
      System.out.println(goodMonth.getMonthName() + 
      " which is represented as " + goodMonth.getMonthNumber() + ".");

      // toString()
      System.out.println("The current state of the goodMonth object is: " + 
      goodMonth.toString());

      // equals()
      System.out.println(goodMonth.getMonthName() + " has the same data as " + 
      badMonth.getMonthName() + ": " + goodMonth.equals(badMonth));

      // greaterThan()
      System.out.println(greatMonth.getMonthNumber() + " is greater than " + 
      terribleMonth.getMonthNumber() + ": " + 
      greatMonth.greaterThan(terribleMonth));

      // lessThan()
      System.out.println(terribleMonth.getMonthNumber() + " is less than " + 
      greatMonth.getMonthNumber() + ": " + terribleMonth.lessThan(greatMonth));

       // Exit
       System.exit(0);
    }
}

// ## Results #####################################################################

// January as a number representation is 1.
// January has been changed to July which is represented as 7.
// The current state of the goodMonth object is: July
// July has the same data as February: false
// 8 is greater than 3: true
// 3 is less than 8: true
// [Finished in 0.4s]