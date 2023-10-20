package techniques.twoPointer.twoSumProblem;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an integer array arr, and an integer target, return the number of tuples i, j, k such that i < j < k and arr[i] + arr[j] + arr[k] == target.
 *
 * As the answer can be very large, return it modulo 109 + 7.
 *
 */
public class ThreeSumWithMultiplicity {
    public static void main(String[] args) {
        int[] nums1 = new int[]{1,1,2,2,3,3,4,4,5,5};
        int[] nums2 = new int[]{1,1,2,2,2,2};
        int[] nums3 = new int[]{2,1,3};

        System.out.println(threeSumMulti(nums1, 8)); //20
        System.out.println(threeSumMulti(nums2, 5)); //12
        System.out.println(threeSumMulti(nums3, 6)); //1
    }

    private static int threeSumMulti(int[] arr, int target) {
        int result = 0;

        Map<Integer, Integer> map = new HashMap<>();
        int mod = 1000000007;

        for (int i = 0; i < arr.length; i++) {
            for (int j = i+1; j < arr.length; j++) {
                if (map.containsKey(target - arr[i] - arr[j])) {
                    result = (result + map.get(target - arr[i] - arr[j])) % mod;
                }
            }
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }

        return result;
    }
}
