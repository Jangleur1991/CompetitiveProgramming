package sorting;

import java.util.Arrays;

/**
 * https://medium.com/analytics-vidhya/investigating-quick-sort-partitioning-c70b4240cf4b
 */
public class QuickSort {
    public static void main(String[] args) {
        int[] nums = {2, 7, 1, 6, 8, 5, 3, 4};
        System.out.println(Arrays.toString(nums));
        quickSort(nums);
        System.out.println(Arrays.toString(nums));
    }

    public static void quickSort(int[] nums) {
        quickSortHelper(nums, 0, nums.length-1);
    }

    private static void quickSortHelper(int[] nums, int low, int high) {
        if (low < high) {
            int pivotIndex = partitionWithTwoPointers(nums, low, high);
            quickSortHelper(nums, low, pivotIndex-1);
            quickSortHelper(nums, pivotIndex+1, high);
        }
    }

    public static int partitioning(int[] nums, int low, int high) {

        // nums = [2, 7, 1, 6, 4]
        //1. Pick a pivot
        int pivot = nums[high]; //4

        //2. Create a boundary/position where to set the pivot
        // - find a way to the boundary -> variable bound
        // - find a way to compare each element with pivot to decent if smaller -> iterate through array?
        int bound = low; // Keeps track of index at which we add an element less than pivot
        //[2, 1, 4, 7, 6] //bound=2

        //3. //[2, 1, 4, 7, 6]
        // 2 < pivot? -> yes! bound++; i++; [7, 1, 6, 4]
        // 7 < pivot? -> no! i++; [7, 1, 6, 4]
        // 1 < pivot? -> yes! swap(7, 1) -> [1, 7, 6, 4], bound++; i++; [7, 6, 4]
        // 6 < pivot? -> no! i++; [4]
        for (int i = low; i < nums.length - 1; i++) {
            if (nums[i] < pivot) {
                swap(nums, bound, i);
                bound++;
            }
        }

        //4.
        // swap(pivot, bound) -> [2, 1, 7, 6, 4] -> [2, 1, 4, 6, 7]
        swap(nums, high, bound);

        return bound;
    }

    private static int partitionWithTwoPointers(int[] nums, int left, int right) {
        int pivot = nums[right];

        int i = left;
        int j = right-1;
        while (i < j) {
            //Find the first element left with element >= pivot
            while (nums[i] < pivot)
                i++;

            //Find the first element right with element < pivot
            while (nums[j] >= pivot)
                j--;

//            if (i == j && nums[i] < pivot)
//                i++;


            //Swap greater element on the left with higher element on the right side
            if (i < j) {
                swap(nums, i, j);
                i++;
                j--;
            }
        }

        if (nums[i] != pivot)
            swap(nums, i, right);
        return i;
    }

    public static void swap(int[] nums, int pivotCurrentIndex, int i) {
        int temp = nums[i];
        nums[i] = nums[pivotCurrentIndex];
        nums[pivotCurrentIndex] = temp;
    }
}
