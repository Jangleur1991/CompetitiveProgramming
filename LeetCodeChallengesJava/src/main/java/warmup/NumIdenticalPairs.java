package warmup;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of integers nums, return the number of good pairs.
 *
 * A pair (i, j) is called good if nums[i] == nums[j] and i < j.
 *
 */
public class NumIdenticalPairs {
    public static void main( String[] args ) {
        int[] nums1 = new int[]{1,2,3,1,1,3};
        int[] nums2 = new int[]{1,1,1,1};
        int[] nums3 = new int[]{1,2,3};

        System.out.println(numIdenticalPairs(nums1));
        System.out.println(numIdenticalPairs(nums2));
        System.out.println(numIdenticalPairs(nums3));
    }

    private static int numIdenticalPairs(int[] nums) {
        HashMap<Integer, Integer> numbersMap = new HashMap<>();
        int result = 0;
        for(int num : nums) {
            int numberOfNums = numbersMap.getOrDefault( num, 0 );
            result += numberOfNums;
            numbersMap.put( num, numberOfNums+1 );
        }
        return result;
    }

    private static int numIdenticalPairsRec(int[] nums) {
        return numIdenticalPairsHelper(nums, new HashMap<>(), 0, 0);
    }

    private static int numIdenticalPairsHelper(int[] nums, Map<Integer, Integer> numbersMap, int index, int result) {
        if (index >= nums.length) {
            return result;
        }

        int num = nums[index];
        int numberOfNums = numbersMap.getOrDefault(num, 0);
        result += numberOfNums;
        numbersMap.put(num, numberOfNums + 1);

        return numIdenticalPairsHelper(nums, numbersMap, index + 1, result);
    }
}
