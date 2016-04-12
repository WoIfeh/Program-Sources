/*
 * ############################################################################
 * Name: Billy Hart
 * Assignment: C1_NT_2
 * Date: Wed Mar 30 15:44:24 2016
 * Description: Subtracts unsigned binary integers.
 * Version # 1.00
 * ############################################################################
*/

// Includes
import java.util.*;

public class C1_NT_2 {
    
    public static void main(String[] args) {
    
        Binary testBinary = new Binary("10001000");
        String binaryToSubtract = "0000101";
        System.out.println(testBinary + " - " + binaryToSubtract + " = " + testBinary.subtract(binaryToSubtract));
    
    }

}