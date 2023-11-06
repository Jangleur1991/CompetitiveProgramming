package techniques.dynamicProgramming;

import java.util.HashMap;
import java.util.Map;

/**
 * You are climbing a staircase. It takes n steps to reach the top.
 *
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 *
 * https://medium.com/analytics-vidhya/leetcode-q70-climbing-stairs-easy-444a4aae54e8
 */
public class ClimbingStairs {
    public static void main(String[] args) {
        int n1 = 2;
        int n2 = 3;

        System.out.println(climbStairs(n1)); //2
        System.out.println(climbStairs(n2)); //3
    }

    private static int climbStairs(int n) {
        return climbStairsHelper(n, new HashMap<>());
    }

    private static int climbStairsHelper(int n, Map<Integer, Integer> memo) {
        if (memo.containsKey(n)) return memo.get(n);
        if (n == 1) return 1;
        if (n == 2) return 2;
        int result = climbStairsHelper(n-1, memo ) + climbStairsHelper(n-2, memo);
        memo.put(n, result);
        return result;
    }

}
