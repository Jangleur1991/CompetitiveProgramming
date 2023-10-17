package techniques.twoPointer.twoSumProblem;

import java.util.Arrays;

/**
 * You are given an array people where people[i] is the weight of the ith person, and an infinite number of boats
 * where each boat can carry a maximum weight of limit. Each boat carries at most two people at the same time,
 * provided the sum of the weight of those people is at most limit.
 *
 * Return the minimum number of boats to carry every given person.
 *
 * https://leetcode.com/problems/boats-to-save-people/solutions/1877945/java-c-a-very-easy-explanation-trust-me/
 */
public class BoatsToSavePeople {
    public static void main(String[] args) {
        int[] people1 = new int[]{1,2};
        int[] people2 = new int[]{3,2,2,1};
        int[] people3 = new int[]{3,5,3,4};

        System.out.println(numRescueBoats(people1, 3)); //1
        System.out.println(numRescueBoats(people2, 3)); //3
        System.out.println(numRescueBoats(people3, 5)); //4

    }

    //Given:
    // 1) An array of people.
    // 2) people[i] == "weight of ith person"
    // 3) An infinite number of boats.
    // 4) A "limit" (max weight) each boat can carry (same limit for each boat).
    // 5) Each boat carry at most 2 people.

    // Wanted: Minimum number of boats to carry every given person.

    // Ideas:
    // - Boat is ok if: Sum of at most two people is <= limit
    // - Maximize number of people where sum is smaller than limit + rest of single people == solution
    // - Highest number of people where sum is <= limit + rest of people == solution
    // - Find all pairs where sum <= limit => number of pairs + rest == solution
    private static int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int n = people.length;
        int result = 0, left = 0, right = n-1;

        while (left <= right) {
            if (people[left] + people[right] <= limit) {
                result++;
                left++;
                right--;
            } else {
                result++;
                right--;
            }
        }
        return result;
    }
}
