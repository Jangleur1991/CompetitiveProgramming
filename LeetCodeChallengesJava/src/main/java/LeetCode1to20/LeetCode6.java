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

    // private static String convert(String s, int numRows) {
    //     if (numRows == 1)
    //         return s;
    //
    //     StringBuilder sb = new StringBuilder();
    //     // Durchlaufe jede Reihe
    //     for ( int row = 0; row < numRows; row++ )
    //     {
    //         int distanceOfFirstAndLastRowBetweenElements = 2*(numRows-1);
    //         // Durchlaufe elemente in einer Reihe
    //         for ( int i = row; i < s.length(); i += distanceOfFirstAndLastRowBetweenElements )
    //         {
    //             sb.append(s.charAt( i )); // sufficent for first and last row, only in part for middle row
    //             //Check if we are in a middle row and check that we are not out of the string
    //             if (row > 0 && (row < numRows-1) && (i + distanceOfFirstAndLastRowBetweenElements - 2*row) < s.length())
    //                 sb.append( s.charAt( i + distanceOfFirstAndLastRowBetweenElements - 2*row ) );
    //         }
    //     }
    //     return sb.toString();
    // }

    private static String convert(String s, int numRows) {
        int n = s.length();
        StringBuilder[] rows = new StringBuilder[numRows];
        for ( int i = 0; i < numRows; i++ )
        {
            rows[i] = new StringBuilder();
        }

        int i = 0;
        while ( i<n ) {
            //down
            for ( int j = 0; (j < numRows) && (i < n); j++ )
            {
                rows[j].append( s.charAt( i++ ) );
            }

            //up
            for ( int j = numRows-2; j > 0 && i < n; j-- )
            {
                rows[j].append( s.charAt( i++ ) );
            }
        }

        StringBuilder result = new StringBuilder();
        for ( StringBuilder row : rows )
           result.append( row.toString() );
        return result.toString();
    }

//    private static String convert(String s, int numRows) {
//        if (numRows == 1)
//            return s;
//
//        StringBuilder[] rows = new StringBuilder[numRows];
//        for ( int i = 0; i < numRows; i++ )
//        {
//            rows[i] = new StringBuilder();
//        }
//
//        int rowIndex = 0; // start at first row
//        int flowDirection = -1; // -1 == down, 1 == up
//
//        for ( char letter : s.toCharArray() ) {
//            rows[rowIndex].append( letter );
//            // if first or last row change direction
//            if (rowIndex == 0 || rowIndex == numRows-1) {
//                flowDirection = -flowDirection;
//            }
//            rowIndex += flowDirection;
//        }
//
//        StringBuilder result = new StringBuilder();
//        for ( StringBuilder row : rows )
//            result.append( row.toString() );
//        return result.toString();
//    }
}
