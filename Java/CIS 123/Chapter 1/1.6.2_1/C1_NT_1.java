/*
 * ############################################################################
 * Name: Billy Hart
 * Assignment: C1_NT_1
 * Date: Wed Mar 30 15:34:55 2016
 * Description: Sample code used to view what it looks like when disassembled.
 * Version # 1.00
 * ############################################################################
*/

public class C1_NT_1 {
    
    public static void main(String[] args) {
    
        int Y = 0;
        int X = (Y + 4) * 3;
    
    }

}

/*
  public static void main(java.lang.String[]);
    Code:
       0: iconst_0  // Create a constant 0
       1: istore_1  // Store 0 in Y
       2: iload_1   // Load value of Y from line 16
       3: iconst_4  // Create constant '4'
       4: iadd      // Add Loaded Y to Constant '4'
       5: iconst_3  // Create constant '3'
       6: imul      // Multiple Value from line 29 with constant '3'
       7: istore_2  // Store the value in X
*/