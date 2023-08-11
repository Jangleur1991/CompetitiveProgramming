package techniques.twoPointer;

import java.util.Arrays;

/**
 * Examples for the two pointers technique.
 *
 */
public class TwoPointers {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        int sum = 5;
        int[] nums2 = {0, 1, 4, 6, 7, 10};
        System.out.println(existsPairWithGivenSumForSortedArrayRec(nums, sum));
        System.out.println(Arrays.toString(reverseArrayRec(nums)));
        System.out.println(numberOfDiffForSortedArrayRec(nums2, 3));
        System.out.println(binarySearchWithTwoPointer(nums2, 1));
    }

    private static int binarySearchWithTwoPointer(int[] nums, int num) {
        Arrays.sort(nums);
        int lower = 0;
        int upper = nums.length-1;

        while (lower <= upper) {
            int midIndex = (lower+upper)/2;
            int midElement = nums[midIndex];
            if (midElement == num)
                return midIndex;
            if (midElement < num) {
                lower = midIndex;
            } else  {
                upper = midIndex;
            }
        }
        return -1;
    }


    // Naive implementation
    /*private static boolean existsPairWithGivenSumForSortedArray(int[] nums, int sum) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if (nums[i] + nums[j] == sum)
                    return true;
            }
        }
        return false;
    }*/

    // Two Pointer Implementation
    // The array nums must be sorted!
    private static boolean existsPairWithGivenSumForSortedArray(int[] nums, int sum) {
        int i = 0;
        int j = nums.length-1;

        while (i < j) {
            int tempSum = nums[i] + nums[j];
            if (tempSum == sum)
                return true;
            if (sum > tempSum)
                i++;
            if (sum < tempSum)
                j--;
        }
        return false;
    }

    private static boolean existsPairWithGivenSumForSortedArrayRec(int[] nums, int sum) {
        return existsPairHelper(nums, sum, 0, nums.length-1);
    }

    private static boolean existsPairHelper(int[] nums, int sum, int lowerCounter, int upperCounter) {
        int tempSum = nums[lowerCounter] + nums[upperCounter];

        if (tempSum == sum)
            return true;
        if (lowerCounter == upperCounter)
            return false;
        if (sum > tempSum)
            return existsPairHelper(nums, sum, ++lowerCounter, upperCounter);
        return existsPairHelper(nums, sum, lowerCounter, --upperCounter);
    }

    private static int numberOfDiffForSortedArray(int[] nums, int diff) {
        int ans = 0;
        int i = 0;
        int j = 1;

        while(i <= j && j < nums.length) {
            if (nums[j] - nums[i] < diff) {
                j++;
            } else if (nums[j] - nums[i] > diff) {
                i++;
            } else {
                ans++;
                j++;
                i++;
            }
        }
        return ans;
    }

    private static int numberOfDiffForSortedArrayRec(int[] nums, int diff) {
        return countPairs(nums, diff, 0, 1, 0);
    }

    private static int countPairs(int[] nums, int diff, int i, int j, int ans) {
        if (i > j || j >= nums.length)
            return ans;

        if (nums[j] - nums[i] < diff) {
            return countPairs(nums, diff, i, j + 1, ans);
        } else if (nums[j] - nums[i] > diff) {
            return countPairs(nums, diff, i + 1, j, ans);
        } else {
            return countPairs(nums, diff, i + 1, j + 1, ans + 1);
        }
    }

    // Naive implementation
    /*private static int[] reverseArray(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            ans[n-1-i] = nums[i];
        }
        return ans;
    }*/


    // Two Pointer Implementation
    private static int[] reverseArray(int[] nums) {
        int i = 0;
        int j = nums.length-1;

        while (i < j) {

            //Swap elements
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;

            i++;
            j--;
        }
        return nums;
    }

    private static int[] reverseArrayRec(int[] nums) {
        return helperReverseArray(nums, 0, nums.length-1);
    }

    private static int[] helperReverseArray(int[] nums, int i, int j) {
        if (i >= j)
            return nums;
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
        return helperReverseArray(nums, ++i, --j);
    }

}
