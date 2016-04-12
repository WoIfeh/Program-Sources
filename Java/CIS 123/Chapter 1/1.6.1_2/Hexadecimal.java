/*
 * ############################################################################
 * Name: Billy Hart
 * Date: Tue Mar 29 16:10:00 2016
 * Description: Converts a 32-bit Hexadecimal string to Decimal
 * ############################################################################
*/

// Includes
import java.util.*;

public class Hexadecimal {
    
    // Instance Variables
    private String hexadecimalString;

    // Constructor(s) ----------------------------------------------------------
    public Hexadecimal(String hexadecimalString) {
        this.hexadecimalString = hexadecimalString;
    }

    // Method(s) ---------------------------------------------------------------
    
    // Converts hexadecimal value to decimal
    public int asDecimal() {
        int sum = 0;
        int newnum = 0;
        String hexString = hexadecimalString.toUpperCase();

            for (int nybbleCount = 0; nybbleCount < hexString.length(); nybbleCount++) {
                char currentNybble = hexString.charAt(hexString.length() - nybbleCount - 1);

                if (currentNybble == 'A') {
                    newnum = 10;
                } else if (currentNybble == 'B') {
                    newnum = 11;
                } else if (currentNybble == 'C') {
                    newnum = 12;
                } else if (currentNybble == 'D') {
                    newnum = 13;
                } else if (currentNybble == 'E') {
                    newnum = 14;
                } else if (currentNybble == 'F') {
                    newnum = 15;
                } else {
                    newnum = Character.getNumericValue(currentNybble);
                }

                sum = (int)(sum + newnum * Math.pow(16, nybbleCount));
            }

        return sum;
    }


    // Override toString()
    public String toString() {
        return "Hexadecimal: " + this.hexadecimalString;
    }

} 