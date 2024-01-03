package bigO;

import java.util.Arrays;

public class BigOExamples
{
    public static void main( String[] args )
    {
        int[] arr = new int[]{3,2,1};
        System.out.println( Arrays.toString( arr ) );
        System.out.println( linearSearch( arr, 5 ));

        binarySearch(arr, 3);

        int[] ints = generateRandomArray( 3 );
        System.out.println(Arrays.toString( ints ));
        selectionSort( arr );
        System.out.println(Arrays.toString( arr ));
    }

    //Example O(n)
    private static boolean linearSearch( int[] arr, int value ) {
        for ( int element : arr ) {
            if (element == value)
                return true;
        }
        return false;
    }

    //Example O(n2)
    private static void bubbleSort( int[] arr )
    {
        for ( int i = arr.length-1; i > 0; i--)
        {
            for ( int j = 0; j < i; j++ )
            {
                if (arr[j] > arr[j+1]) {
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }

    //Example O(n2) which is twice as fast as bubblesort
    private static void selectionSort( int[] arr )
    {
        for ( int i = 0; i < arr.length; i++ )
        {
            int lowestNumberIndex = i;
            for ( int j = i+1; j < arr.length; j++ )
            {
                if (arr[j] < arr[lowestNumberIndex])
                    lowestNumberIndex = j;
            }

            if (lowestNumberIndex != i) {
                int temp = arr[i];
                arr[i] = arr[lowestNumberIndex];
                arr[lowestNumberIndex] = temp;
            }
        }
    }

    //Example O(log(n))
    private static void binarySearch( int[] arr, int value )
    {
        int left = 0;
        int right = arr.length - 1;

        while ( left <= right )
        {
            int middleIndex = ( left + right )/2;
            if (arr[middleIndex] < value )
                left = middleIndex + 1;
            else if ( arr[ middleIndex ] > value )
                right = middleIndex - 1;
            else
            {
                System.out.println( "Element found at index: " + middleIndex );
                left = right+1;
            }
        }

    }

    private static int[] generateRandomArray( int arrSize )
    {
        int[] result = new int[ arrSize ];

        for ( int i = 0; i < arrSize; i++ )
        {
            result[ i ] = ( int ) ( Math.random() * 1000 );
        }
        return result;
    }
}
