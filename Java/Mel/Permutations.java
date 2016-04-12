import java.util.*;

public class Permutations {
    
    public static void main (String[] args) {
        
    }

    protected static Deque<int[]> createPermutations () {
        Deque<int[]> validPermutations = new ArrayDeque<int[]>();
        int[]        currentPermutation = new int[3];
        for (int fire = 1; fire <= 7; fire++) {
            currentPermutation[0] = fire;
            for (int police = 2; police <= 6; police += 2) {
                currentPermutation[1] = police;
                for (int sanitation = 1; sanitation <= 7; sanitation++) {
                    currentPermutation[2] = sanitation;
                    if (checkPermutation(currentPermutation)) {
                        validPermutations.push(currentPermutation);
                        System.out.println(Arrays.toString(currentPermutation));
                    }
                }
            }
        }
        return validPermutations;
    }

    protected static Deque<int[]> createPermutationsBySum () {
        Deque<int[]> validPermutations  = new ArrayDeque<int[]>();
        int[]        currentPermutation = new int[3];
        int          maxNum             = 7;
        int          halfMax            = (int) Math.ceil((double)maxNum/2);
        int          remainder          = 0;
        int          currentPoliceNum   = 2;
        int          currentNum         = 1;
        while (currentNum <= halfMax) {
            if (currentPoliceNum == 8) {
                    currentNum++;
                    currentPoliceNum = 2;
            } else {
                remainder = 12 - currentNum - currentPoliceNum;
                if (remainder <= 7) {
                currentPermutation[0] = currentNum;
                currentPermutation[1] = currentPoliceNum;
                currentPermutation[2] = remainder;
                    if (checkPermutation(currentPermutation)) {
                        validPermutations.push(currentPermutation);
                        System.out.println(Arrays.toString(currentPermutation));
                        int temp = currentPermutation[0];
                        currentPermutation[0] = currentPermutation[2];
                        currentPermutation[2] = temp;
                        validPermutations.push(currentPermutation);
                        System.out.println(Arrays.toString(currentPermutation));
                    }
                }
                currentPoliceNum += 2;
            }
        }
        return validPermutations;
    }

    protected static boolean checkPermutation (int[] permutation) {
        if (getMaxOfTriplet(permutation) > 7 || getMinOfTriplet(permutation) < 1) {
            return false;
        } else {
            if (permutation[0] == permutation[1] || 
                permutation[0] == permutation[2] || 
                permutation[1] == permutation[2]) {
                return false;
            } else {
                if (permutation[1] % 2 != 0) {
                    return false;
                } else {
                    if (getSumOfTriplet(permutation) != 12) {
                        return false;
                    } else {
                        return true;
                    }
                }
            }
        }
    }

    private static int getMaxOfTriplet(int[] triplet) {
        return Math.max(Math.max(triplet[0], triplet[1]), triplet[2]);
    }

    private static int getMinOfTriplet(int[] triplet) {
        return Math.min(Math.min(triplet[0], triplet[1]), triplet[2]);
    }

    private static int getSumOfTriplet(int[] triplet) {
        return triplet[0] + triplet[1] + triplet[2];
    }

}