package LeetCode1to20;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/two-sum/description/
 * https://leetcode.com/problems/two-sum/editorial/
 *
 * @author Pulse Innovations Ltd
 */
public class LeetCode1
{
    public static void main( String[] args )
    {
        int[] arr1 = new int[]{2,7,11,15};
        int[] arr2 = new int[]{3,2,4};
        int[] arr3 = new int[]{3,3};

        System.out.println( Arrays.toString(twoSum( arr1, 9 )));
        System.out.println( Arrays.toString(twoSum( arr2, 6 )));
        System.out.println( Arrays.toString(twoSum( arr3, 6 )));
    }

    private static int[] twoSum(int[] arr, int target)
    {
        Map<Integer, Integer> map = new HashMap<>();
        for ( int i = 0; i < arr.length; i++ )
        {
            int summand = target - arr[i];
            if (map.containsKey( summand )) {
                return new int[]{i, map.get( summand )};
            }
            map.put( arr[i], i );
        }
        return new int[]{};
    }
}
