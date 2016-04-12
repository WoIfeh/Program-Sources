/*
 * ############################################################################
 * Name: Billy Hart
 * Date: Tue Mar 29 17:38:30 2016
 * Description: Converts decimal value to hexadecimal
 * ############################################################################
*/

// Includes
import java.util.*;

public class Decimal {
    
    // Instance Variables
    private int decimalValue;

    // Constructor(s) ----------------------------------------------------------
    public Decimal(int decimalValue) {
        this.decimalValue = decimalValue;
    }

    // Method(s) ---------------------------------------------------------------
    
    // Converts decimal value to hexadecimal
    public String asHex() {
        String digits = "0123456789ABCDEF";
        String hexValue = "";
        int userDecValue = this.decimalValue;
        
        if (userDecValue == 0) {
            hexValue = "0";
        } else {
            while (userDecValue > 0) {
                int digit = userDecValue % 16;
                hexValue = digits.charAt(digit) + hexValue;
                userDecValue = userDecValue / 16;
            }
        }

        return hexValue;
    }
    

    // Override toString()
    public String toString() {
        return "Decimal Value: " + this.decimalValue;
    }

}