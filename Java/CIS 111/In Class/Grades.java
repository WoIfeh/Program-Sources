/*
 * ##################################################################
 * Billy Hart
 * Chapter: 7
 * Assignment: In Class Assignment
 * Date: 10/20/15
 * Description: Test score manipulation
 * ##################################################################
*/

// Includes
import java.util.Random;

public class Grades
{
    public static void main(String[] args)
    {
      // Local Variables
      final int SIZE = 10;
      Random numGen = new Random();
      int[] scores = new int[SIZE];
      int indx;

      for (indx = 0; indx < SIZE; indx++)
      {
        scores[indx] = numGen.nextInt(101);
      }

      printArray(scores);

        // Exit
        System.exit(0);
    }

    public static void printArray(int[] list)
    {
        int indx;
        for (indx = 0; indx < list.length; indx++)
        {
          System.out.print(" " + list[indx]);
        }
    }
}