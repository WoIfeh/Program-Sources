import java.util.*;

public class PermutationsTest extends Permutations {
    
    public static void main (String[] args) {
        //try {
            int[] testIncorrectSum = {1, 2, 3};
            assert (!checkPermutation(testIncorrectSum));
            int[] testSameNumber = {1, 1, 1};
            assert (!checkPermutation(testSameNumber));
            int[] testTooBigNumber = {2, 3, 8};
            assert (!checkPermutation(testTooBigNumber));
            int[] testTooLowNumber = {5, 0, 7};
            assert (!checkPermutation(testTooLowNumber));
            int[] testOddPoliceNumber = {2, 7, 3};
            assert (!checkPermutation(testOddPoliceNumber));
            int[] testCorrect1 = {2, 6, 4};
            assert (checkPermutation(testCorrect1));
            int[] testCorrect2 = {1, 4, 7};
            assert (checkPermutation(testCorrect2));
            int[] testCorrect3 = {7, 4, 1};
            assert (checkPermutation(testCorrect3));
            int[] testCorrect4 = {5, 6, 1};
            assert (checkPermutation(testCorrect4));  
            System.out.println("ALL CLEAR :D");
        //} catch (AssertionError error) {
        //    System.out.println(error);
        //}  
            Deque<int[]> test = createPermutations();
            System.out.println("now by sum:");
            Deque<int[]> test2 = createPermutationsBySum();
    }

}