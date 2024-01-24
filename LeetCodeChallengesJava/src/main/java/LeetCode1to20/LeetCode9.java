package LeetCode1to20;

/**
 * https://leetcode.com/problems/palindrome-number/description/
 */
public class LeetCode9 {
    public static void main(String[] args) {
        int x1 = 121;
        int x2 = -121;
        int x3 = 10;
        int x4 = 1410110141;

//        System.out.println(isPalindrome(x1));
//        System.out.println(isPalindrome(x2));
//        System.out.println(isPalindrome(x3));
        System.out.println(isPalindrome(x4));
    }


    //NeetCode solution. Doesn't work for very big numbers (overflow)!
//    private static boolean isPalindrome(int x) {
//        if (x < 0)
//            return false;
//
//        int powerOfTen = 1;
//
//        //Calculate the highest power of ten by which x can be divided.
//        while (x >= powerOfTen * 10) {
//            powerOfTen = powerOfTen * 10;
//        }
//
//        while (x != 0) {
//            int mostRightDigit = x % 10;
//            int mostLeftDigit = x / powerOfTen;
//
//            if (mostLeftDigit != mostRightDigit)
//                return false;
//
//            x = (x % powerOfTen) / 10; // remove most left digit: x%powerOfTen, remove most right digit: /10
//
//            powerOfTen /= 100; //since we remove two digits we have decrease powerOfTen by 100
//        }
//
//        return true;
//    }

    private static boolean isPalindrome(int x) {
        int reverseNumber = 0, originalNumber = x;
        while (x > 0) {
            int lastDigit = x%10;
            reverseNumber = (reverseNumber*10) + lastDigit;
            x /= 10;
        }
        return reverseNumber == originalNumber;
    }
}
