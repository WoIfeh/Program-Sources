/*
 * ############################################################################
 * Name: Billy Hart
 * Date: Tue Mar 29 16:44:57 2016
 * Description: Converts decimal value to binary string
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
    
    // Convert decimal value to binary
    public String asBinary() {
        String binaryString = "";

        for (; this.decimalValue > 0; decimalValue /= 2) {
            if (this.decimalValue % 2 == 0) {
                binaryString += "0";
            } else {
                binaryString += "1";
            }
        }

        return new StringBuilder(binaryString).reverse().toString();
    }
    

    // Override toString()
    public String toString() {
        return "Decimal: " + this.decimalValue + "\nBinary: " + "1001";
    }

}