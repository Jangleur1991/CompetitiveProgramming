package warmup;

/**
 * Given a non-negative integer x, return the square root of x rounded down to the nearest integer. The returned integer should be non-negative as well.
 *
 * You must not use any built-in exponent function or operator.
 */
public class MySqrt {
    public static void main(String[] args) {
        System.out.println(mySqrt(1));
        System.out.println(mySqrt2(8));
    }

    private static int mySqrt(int x) {
        if (x < 2)
            return 1;

        int left = 2, right = x / 2;
        int midElement;
        long currentSquare;
        while (left <= right) {
            midElement = left + (right - left) / 2;
            currentSquare = (long) midElement * midElement;
            if (currentSquare > x)
                right = midElement - 1;
            else if (currentSquare < x)
                left = midElement + 1;
            else
                return midElement;
        }
        return right;
    }

    private static int mySqrt2(int x) {
        return mySqrtHelper(x, 2, x / 2);
    }

    private static int mySqrtHelper(int x, int left, int right) {
        if (left > right)
            return right;
        int midElement = left + (right - left) / 2;
        long currentSquare = (long) midElement * midElement;
        if (currentSquare > x)
            return mySqrtHelper(x, left, midElement - 1);
        else if (currentSquare < x)
            return mySqrtHelper(x, midElement + 1, right);
        else
            return midElement;
    }
}