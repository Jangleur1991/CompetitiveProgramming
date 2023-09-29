package techniques.twoPointer;

/**
 * Given a binary array nums, return the maximum number of consecutive 1's in the array.
 *
 * Hint: You need to think about two things as far as any window is concerned. One is the starting point for the window.
 * How do you detect that a new window of 1s has started? The next part is detecting the ending point for this window.
 * How do you detect the ending point for an existing window? If you figure these two things out, you will be able to
 * detect the windows of consecutive ones. All that remains afterward is to find the longest such window and return the size.
 */
public class MaxConsecutiveOnes {
    public static void main(String[] args) {
        int[] nums1 = new int[]{1, 1, 0, 1, 1, 1};
        int[] nums2 = new int[]{1, 0, 1, 1, 0, 1};

        System.out.println(findMaxConsecutiveOnes(nums1)); //3
        System.out.println(findMaxConsecutiveOnes(nums2)); //2
    }

    //if nums[i] == 0 => start new window from end of old window
    // if nums[i] == 1 => calculate window size
    private static int findMaxConsecutiveOnes(int[] nums) {
        int result = 0, left = 0, right = 0;
        while (right < nums.length) {
            if (nums[right] == 0)
                left = right + 1;
            else
                result = Math.max(result, right - left + 1);
            right++;
        }
        return result;
    }

//    private static int findMaxConsecutiveOnes(int[] nums) {
//        int result = 0, currentConsecutiveOnes  = 0;
//        for (int num: nums) {
//            if (num == 1) {
//                currentConsecutiveOnes++;
//                result = Math.max(currentConsecutiveOnes, result);
//            } else {
//                currentConsecutiveOnes = 0;
//            }
//        }
//        return result;
//    }
}
