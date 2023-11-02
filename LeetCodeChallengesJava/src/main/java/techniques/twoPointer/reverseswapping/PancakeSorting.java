package techniques.twoPointer.reverseswapping;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an array of integers arr, sort the array by performing a series of pancake flips.
 *
 * In one pancake flip we do the following steps:
 * 1) Choose an integer k where 1 <= k <= arr.length.
 * 2) Reverse the sub-array arr[0...k-1] (0-indexed).
 *
 * For example, if arr = [3,2,1,4] and we performed a pancake flip choosing k = 3, we reverse the sub-array [3,2,1],
 * so arr = [1,2,3,4] after the pancake flip at k = 3.
 *
 * Return an array of the k-values corresponding to a sequence of pancake flips that sort arr. Any valid answer that
 * sorts the array within 10 * arr.length flips will be judged as correct.
 *
 * https://leetcode.com/problems/pancake-sorting/editorial/
 */
public class PancakeSorting {
    public static void main(String[] args) {
        int[] nums = new int[]{3,2,4,1};
        int[] nums2 = new int[]{1,2,3};

        System.out.println(pancakeSort(nums)); // [3, 4, 2, 3, 1, 2, 1, 1]
        System.out.println(pancakeSort(nums2)); // []
    }

    //1) Find the largest number
    //2) Flip twice to the tail
    private static List<Integer> pancakeSort(int[] arr) {
        List<Integer> result = new ArrayList<>();
        int currentMaxNumber = arr.length;

        //Start always with the next max number
        while (currentMaxNumber > 0) {
            //Find the currentIndex of the current max number
            int index = indexOfNumber(arr, currentMaxNumber);

            //Reverse the array up to the index => currentMaxNumber is
            //at the beginning of the array
            result.add(index+1);
            reverse(arr, index);

            //Reverse the array up to the currentMaxNumber => currentMaxNumber
            //is in the correct position!
            result.add(currentMaxNumber);
            reverse(arr, currentMaxNumber-1);

            currentMaxNumber--;
        }
        return result;
    }

    private static int indexOfNumber(int[] nums, int number) {
        for (int i = 0; i < nums.length; i++) {
            if (number == nums[i])
                return i;
        }
        return -1;
    }

    private static void reverse(int[] arr, int index) {
        int i = 0, j = index;
        while (i < j) {
            int temp = arr[i];
            arr[i++] = arr[j];
            arr[j--] = temp;
        }
    }
}
