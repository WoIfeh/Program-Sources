/*
 * ############################################################################
 * Name: Billy Hart
 * Assignment: C1_PT_2
 * Date: Tue Mar 29 16:03:37 2016
 * Description: Write a function that receives a string containing a 32-bit 
 *              hexadecimal integer. The function must return the decimal 
 *              integer value of the hexadecimal integer. 
 * Version # 1.00
 * ############################################################################
*/

// Includes
import java.util.*;

public class C1_PT_2 {
    
    public static void main(String[] args) {
    
        Hexadecimal testHexValue = new Hexadecimal("13D3");
        System.out.println(testHexValue.asDecimal());
    
    }

}