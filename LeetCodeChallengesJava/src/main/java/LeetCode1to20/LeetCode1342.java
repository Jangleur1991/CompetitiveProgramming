package LeetCode1to20;

public class LeetCode1342 {
    public static void main(String[] args) {
        System.out.println(numberOfStepsBitwise(14));
        System.out.println(numberOfStepsBitwise(8));
        System.out.println(numberOfStepsBitwise(123));
    }

    private static int numberOfSteps(int num) {
        int steps = 0;
        while(num > 0) {
            if (num%2==0) {
                num /= 2;
            } else {
                num--;
            }
            steps++;
        }
        return steps;
    }

    private static int numberOfStepsBitwise(int num) {
        int steps = 0;
        while(num > 0) {
            //Before we used num % 2 to check if odd or even
            if ((num & 1) == 0) { //num xxx1 & bitmask: 0001
               //Before we used num /= 2; to half the number
                num = num >> 1; //right shift by number e. g. num >> 2 would shift number by two places to right
            } else {
                num --;
            }
            steps++;
        }
        return steps;
    }
}
