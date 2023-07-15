package sorting;

public class FindKthLargest {

    public static void main(String[] args) {
        int[] nums = {3,2,3,1,2,4,5,5,6};
        System.out.println(findKthLargest(nums, 4));
    }

    private static int findKthLargest(int[] nums, int k) {
        return findKthLargestHelper(nums, 0, nums.length-1, nums.length-k);
    }

    private static int findKthLargestHelper(int[] nums, int low, int high, int index) {
        int partitionIndex = QuickSort.partitioning(nums, low, high);

        if (partitionIndex < index)
            return findKthLargestHelper(nums, partitionIndex+1, high, index);

        if (partitionIndex > index)
            return findKthLargestHelper(nums, low, partitionIndex-1, index);

        return nums[partitionIndex];
    }

}
