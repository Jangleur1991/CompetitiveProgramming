package sorting;

import org.junit.jupiter.api.Test;

import java.util.OptionalInt;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;

class QuickSortTest {

    @Test
    void testPartitioning() {
        //given
        int[] nums = {2, 7, 1, 6, 8, 5, 3, 4};
        int pivot = 4;
        int indexOfPivot = nums.length-1;

        //when
        int result = QuickSort.partitioning(nums, 0, nums.length-1);

        //then
        boolean isPartitionCorrect = true;
        for (int i = 0; i < result; i++) {
            if (nums[i] > pivot)
                isPartitionCorrect = false;
        }

        for (int i = result + 1; i < nums.length; i++) {
            if (nums[i] < pivot)
                isPartitionCorrect = false;
        }

        assertTrue( isPartitionCorrect );
        assertEquals(3, result);

    }
}