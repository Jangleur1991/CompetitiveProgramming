/*
    Given an array of integers nums and an integer target,
    return indices of the two numbers such that they add up to target.

    Example:
    Input: nums = [2,7,11,15], target = 9
    Output: [0,1]
    Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].

    Constraints:
    1) 2 <= nums.length <= 104
    2) -109 <= nums[i] <= 109
    3) -109 <= target <= 109
    4) Only one valid answer exists.
 */


import java.util.*;
import java.util.stream.IntStream;

public class TwoSum {


    /*
        Idea:

        For an int nums[i] we need to find the index of target-nums[i],
        because nums[i]+target-nums[i] = target.

        Create a map mapValueToIndex with properties (target-nums[i], i),
        then the searched indices corresponds to [mapValueToIndex.get(i), i].
     */

    //Time: 12ms
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> mapValueToIndex = new HashMap<>();
        int[] result = new int[2];
        //Creates an index Stream, so you can use the index 'index'
        //like in a normal for-loop.
        IntStream.range(0, nums.length).forEach(index -> {
            if (!mapValueToIndex.containsKey(nums[index])) {
                mapValueToIndex.put(target-nums[index], index);
            } else {
                result[0] = mapValueToIndex.get(nums[index]);
                result[1] = index;
            }
        });
        return result;
    }

}
