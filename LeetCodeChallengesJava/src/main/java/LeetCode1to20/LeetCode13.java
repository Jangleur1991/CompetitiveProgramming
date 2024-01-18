package LeetCode1to20;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/roman-to-integer/description/
 */
public class LeetCode13
{
    public static void main( String[] args )
    {
        String s1 = "III";
        String s2 = "LVIII";
        String s3 = "MCMXCIV";

        System.out.println(romanToInt(s1));
        System.out.println(romanToInt(s2));
        System.out.println(romanToInt(s3));
    }

    private static int romanToInt( final String s )
    {
        Map<Character, Integer> map = new HashMap<>();
        map.put( 'I', 1 );
        map.put( 'V', 5 );
        map.put( 'X', 10 );
        map.put( 'L', 50 );
        map.put( 'C', 100 );
        map.put( 'D', 500 );
        map.put( 'M', 1000 );

        int previousNumber = 0, result = 0;
        for ( int i = s.length()-1; i >= 0; i-- )
        {
            int currentNumber = map.get(s.charAt( i ));
            result = (currentNumber < previousNumber)
                ? result-currentNumber
                : result + currentNumber;
            previousNumber = currentNumber;
        }
        return result;
    }
}
