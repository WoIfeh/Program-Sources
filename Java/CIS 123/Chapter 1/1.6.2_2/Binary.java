/*
 * ############################################################################
 * Name: Billy Hart
 * Date: Wed Mar 30 15:47:59 2016
 * Description: Subtracts Binary Strings
 * ############################################################################
*/

// Includes
import java.util.*;

public class Binary {
    
    // Instance Variables
    private String binaryString;

    // Constructor(s) ----------------------------------------------------------
    public Binary(String binaryString) {
        this.binaryString = binaryString;
    }

    // Method(s) ---------------------------------------------------------------
    
    // Subtracts binary strings
    public String subtract(String binaryToSubtract) {

        int i = Integer.parseInt(this.binaryString, 2);
        int j = Integer.parseInt(binaryToSubtract, 2);

        i = i - j;

        return Integer.toBinaryString(i);
    }
    

    // Override toString()
    public String toString() {
        return this.binaryString;
    }

}