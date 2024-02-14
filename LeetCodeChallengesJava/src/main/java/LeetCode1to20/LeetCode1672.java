package LeetCode1to20;

// https://leetcode.com/problems/richest-customer-wealth/description/
public class LeetCode1672 {
    public static void main(String[] args) {
        int[][] accounts1 = new int[][]{new int[]{1,2,3},new int[]{3,2,1}};
        int[][] accounts2 = new int[][]{new int[]{1,5},new int[]{7,3}, new int[]{3,5}};
        int[][] accounts3 = new int[][]{new int[]{2,8,7},new int[]{7,1,3}, new int[]{1,9,5}};

        System.out.println(maximumWealth(accounts1)); //6
        System.out.println(maximumWealth(accounts2)); //10
        System.out.println(maximumWealth(accounts3)); //17
    }

    private static int maximumWealth(int[][] accounts) {
        int result = 0;
        for(int[] customer : accounts) {
            int currentCustomerMaxWealth = 0;
            for(int bank : customer) {
                currentCustomerMaxWealth += bank;
            }
            result = Math.max(result, currentCustomerMaxWealth);
        }
        return result;
    }
}
