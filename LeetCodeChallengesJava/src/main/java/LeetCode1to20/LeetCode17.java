package LeetCode1to20;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode.com/problems/letter-combinations-of-a-phone-number/description/
 */
public class LeetCode17
{
    public static void main( String[] args )
    {
        String digits1 = "23";
        String digits2 = "2";
        String digits3 = "";

        System.out.println( letterCombinationsBacktrack( digits1 ) );
        System.out.println( letterCombinationsBacktrack( digits2 ) );
        System.out.println( letterCombinationsBacktrack( digits3 ) );
    }

    private static List<String> letterCombinations( String digits )
    {
        if ( digits.isEmpty() )
            return new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();
        map.put( "2", List.of("a", "b", "c") );
        map.put( "3", List.of("d", "e", "f") );
        map.put( "4", List.of("g", "h", "i") );
        map.put( "5", List.of("j", "k", "l") );
        map.put( "6", List.of("m", "n", "o") );
        map.put( "7", List.of("p", "q", "r", "s") );
        map.put( "8", List.of("t", "u", "v") );
        map.put( "9", List.of("w", "x", "y", "z") );
        return letterCombinations( digits, map );
    }

    private static List<String> letterCombinations( String digits, Map<String, List<String>> map)
    {
        if (digits.length() == 1)
            return map.get( digits );
        List<String> lettersOfFirstDigit = map.get( digits.substring( 0, 1 ) );
        List<String> letterCombinationsOfRemaining = letterCombinations( digits.substring( 1 ) );
        List<String> result = new ArrayList<>();
        for ( String letterOfFirstDigit : lettersOfFirstDigit ) {
            for ( String letterCombinationOFRemaning : letterCombinationsOfRemaining ) {
                result.add( letterOfFirstDigit + letterCombinationOFRemaning );
            }
        }
        return result;
    }

    private static List<String> letterCombinationsBacktrack( String digits )
    {
        if ( digits.isEmpty() )
            return Collections.emptyList();
        Map<String, List<String>> map = new HashMap<>();
        map.put( "2", List.of("a", "b", "c") );
        map.put( "3", List.of("d", "e", "f") );
        map.put( "4", List.of("g", "h", "i") );
        map.put( "5", List.of("j", "k", "l") );
        map.put( "6", List.of("m", "n", "o") );
        map.put( "7", List.of("p", "q", "r", "s") );
        map.put( "8", List.of("t", "u", "v") );
        map.put( "9", List.of("w", "x", "y", "z") );
        List<String> result = new ArrayList<>();
        backtrack( "", digits, result, map );
        return result;
    }


    private static void backtrack(String combination, String digits, List<String> result, Map<String,
        List<String>> map)
    {
        if (digits.isEmpty())
        {
            result.add( combination );
        } else {
            List<String> letters = map.get( digits.substring( 0, 1 ) );
            for ( String letter : letters ) {
                backtrack( combination + letter, digits.substring( 1 ), result, map );
            }
        }
    }
}
