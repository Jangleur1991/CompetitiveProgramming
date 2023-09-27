package techniques.twoPointer;

/**
 * Given a binary array nums, return the maximum number of consecutive 1's in the array if you can flip at most one 0.
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
