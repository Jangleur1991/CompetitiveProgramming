package techniques.recursion;

import java.util.HashMap;
import java.util.Map;

public class Fibonacci {
    public static void main(String[] args) {
        int n1 = 2;
        int n2 = 3;
        int n3 = 4;

        System.out.println(fib(n1));
        System.out.println(fib(n2));
        System.out.println(fib(n3));
    }

//    private static int fib(int n) {
//        return fibHelper(n, new int[n+1]);
//    }
//
//    private static int fibHelper(int n, int[] memo)
//    {
//        if (n == 0) return 0;
//        if (n <= 2) return 1;
//        if (memo[n] != 0) return memo[n];
//        memo[n] = fibHelper(n-1, memo) + fibHelper(n-2, memo);
//        return memo[n];
//    }

    private static int fib(int n) {
        if (n<1) return 0;
        if (n == 1 || n == 2) return 1;

        int f1 = 1, f2 = 1, result = 2;
        for (int i = 4; i <= n; i++) {
            f1 = f2;
            f2 = result;
            result = f1 + f2;
        }
        return result;
    }
}
