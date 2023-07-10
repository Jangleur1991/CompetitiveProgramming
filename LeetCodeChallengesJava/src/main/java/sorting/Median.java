package sorting;

public class Median {

    public static void main(String[] args) {
        int[] nums = {2, 7, 6, 1, 4};
        System.out.println(median(nums));
    }

    private static int median(int[] nums) {
        return medianHelper(nums, 0, nums.length-1);
    }

    private static int medianHelper(int[] nums, int low, int high) {

        if (low < high) {

            int index = QuickSort.partitioning(nums, low, high);
            int n = nums.length-1;

            if (index < (n/2)) {
                return medianHelper(nums, index+1, high);
            }

            if (index > (n/2)) {
                return medianHelper(nums, low, index-1);
            }

            return nums[index];

        }
        return -1;
    }
}
