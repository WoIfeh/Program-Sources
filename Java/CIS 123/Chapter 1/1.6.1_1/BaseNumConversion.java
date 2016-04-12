/*
 * ################################################################################
 * Name: Billy Hart
 * Date: Tue Mar 29 15:12:58 2016
 * Description: Class converts Binary String to Decimal
 * Version # 1.00
 * ################################################################################
*/

// Includes
import java.util.*;

public class BaseNumConversion {
    
    // Constructor(s) ----------------------------------------------------------
    public BaseNumConversion() {
        //.. 
    }

    // Method(s) ---------------------------------------------------------------
    
    // Converts a given 16-bit binary string into decimal
    public static int asDecimal(String binaryString) {
        char[] binaryArray = binaryString.toCharArray();
        int decimalValue = 0;

        for (int currentBit = binaryArray.length - 1; currentBit >= 0; currentBit--) {
           if (binaryArray[currentBit] == '1') {
               decimalValue += Math.pow(2, (binaryArray.length - currentBit - 1));
           }
        }

        return decimalValue;
    }

}