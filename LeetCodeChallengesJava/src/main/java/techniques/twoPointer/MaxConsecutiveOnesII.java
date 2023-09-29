package techniques.twoPointer;

/**
 * Given a binary array nums, return the maximum number of consecutive 1's in the array if you can flip at most one 0.
 * https://sunjetliu.medium.com/algorithm-practice-max-consecutive-ones-ii-792887fe1b4e
 *
 * Approach: Similar to MaxConescutiveOnes but the valid/invalid states are different:
 *
 *  - Valid: one or fewer 0’s in our current sequence
 *  - Invalid: two 0’s in our current sequence
 *
 */
public class MaxConsecutiveOnesII {
    public static void main(String[] args) {
        int[] nums1 = new int[]{1,0,1,1,0};
        int[] nums2 = new int[]{1,0,1,1,0,1};

        System.out.println(maxConsecutiveOne(nums1)); //4
        System.out.println(maxConsecutiveOne(nums2)); //4
    }

    private static int maxConsecutiveOne(int[] nums){
        int result = 0, left = 0, right = 0, lastZeroIndex = -1;

        while (right < nums.length) {
            if (nums[right] == 0) {
                left = lastZeroIndex+1;
                lastZeroIndex = right;
            }
            result = Math.max(result, right-left+1);
            right++;
        }
        return result;
    }
}
