package LeetCode1to20;

/**
 * https://leetcode.com/problems/zigzag-conversion/description/
 */
public class LeetCode6
{
    public static void main( String[] args )
    {
        String s1= "PAYPALISHIRING";
        String s2= "PAYPALISHIRING";
        String s3= "A";

        System.out.println(convert(s1, 3)); //PAHNAPLSIIGYIR
        System.out.println(convert(s2, 4)); //PINALSIGYAHRPI
        System.out.println(convert(s3, 1)); //A
    }

    private static String convert(String s, int numRows) {
        if (numRows == 1)
            return s;

        StringBuilder sb = new StringBuilder();
        // Durchlaufe jede Reihe
        for ( int row = 0; row < numRows; row++ )
        {
            int distanceOfFirstAndLastRowBetweenElements = 2*(numRows-1);
            // Durchlaufe elemente in einer Reihe
            for ( int i = row; i < s.length(); i += distanceOfFirstAndLastRowBetweenElements )
            {
                sb.append(s.charAt( i )); // sufficent for first and last row, only in part for middle row
                //Check if we are in a middle row and check that we are not out of the string
                if (row > 0 && (row < numRows-1) && (i + distanceOfFirstAndLastRowBetweenElements - 2*row) < s.length())
                    sb.append( s.charAt( i + distanceOfFirstAndLastRowBetweenElements - 2*row ) );
            }
        }
        return sb.toString();
    }
}
