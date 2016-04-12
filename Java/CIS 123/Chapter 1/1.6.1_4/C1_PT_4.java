/*
 * ############################################################################
 * Name: Billy Hart
 * Assignment: C1_PT_4
 * Date: Tue Mar 29 17:33:31 2016
 * Description: Write a function that receives an integer. The function must 
 *              return a string containing the hexadecimal representation of 
                the integer. 
 * Version # 1.00
 * ############################################################################
*/

// Includes
import java.util.*;     

public class C1_PT_4 {
    
    public static void main(String[] args) {
    
        Decimal testDecimal = new Decimal(1234);
        System.out.println(testDecimal.asHex());

    }

}       