package LeetCode1to20;

/**
 * https://leetcode.com/problems/integer-to-roman/
 * https://leetcode.com/problems/integer-to-roman/solutions/3975240/java-runtime-3ms-beats-98-91-o-1/
 * https://www.youtube.com/watch?v=hwBoSpQnijA
 */
public class LeetCode12
{
    public static void main( String[] args )
    {
        int num1 = 3;
        int num2 = 58;
        int num3 = 1994;

        System.out.println(intToRoman(num1));
        System.out.println(intToRoman(num2));
        System.out.println(intToRoman(num3));
    }

    private static String intToRoman( int num )
    {
        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] romanNumerals = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

        StringBuilder sb = new StringBuilder();

        int i = 0;
        while(num > 0) {
            if (num >= values[i]) {
                sb.append( romanNumerals[i] );
                num -= values[i];
            } else {
                i++;
            }
        }
        return sb.toString();
    }

    // private static String intToRoman( int num )
    // {
    //     String[] units = new String[]{"", "I", "II", "IV", };
    //     String[] tens = ....
    //     String[] hundreds = ...
    //     String[] thousands = ...
    //
    //     return thousands[num / 1000] + hundreds[(num%1000)/100] + tens[(num%100)/10] + units[(num%10)];
    //
    // }
}
