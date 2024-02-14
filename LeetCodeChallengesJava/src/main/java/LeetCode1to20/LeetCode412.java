package LeetCode1to20;

import java.util.ArrayList;
import java.util.List;

public class LeetCode412 {
    public static void main(String[] args) {
        System.out.println(fizzBuzz(3));
        System.out.println(fizzBuzz(5));
        System.out.println(fizzBuzz(15));
    }

    private static List<String> fizzBuzz(int n) {
        List<String> result = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            boolean isDivisbleBy3 = i%3 == 0;
            boolean isDivisbleBy5 = i%5 == 0;

//            String currentSolution = isDivisbleBy3 ? "Fizz" + (isDivisbleBy5 ? "Buzz" : "") :
//                    (isDivisbleBy5 ? "Buzz" : String.valueOf(i));
//            result.add(currentSolution);
            if (isDivisbleBy3 && isDivisbleBy5) {
                result.add("FizzBuzz");
            } else if (isDivisbleBy3) {
                result.add("Fizz");
            } else if (isDivisbleBy5) {
                result.add("Buzz");
            } else {
                result.add(String.valueOf(i));
            }

        }
        return result;
    }
}
