package techniques.twoPointer;

/**
 * You are given an integer array height of length n. There are n vertical lines drawn such that the two endpoints of
 * the ith line are (i, 0) and (i, height[i]).
 *
 * Find two lines that together with the x-axis form a container, such that the container contains the most water.
 *
 * Return the maximum amount of water a container can store.
 *
 * Notice that you may not slant the container
 *
 *
 */
public class ContainerWithMostWater {
    public static void main(String[] args) {
        int[] height1 = new int[]{1,8,6,2,5,4,8,3,7};
        int[] height2 = new int[]{1,1};

        System.out.println(maxArea(height1)); //49
        System.out.println(maxArea(height2)); //1
    }

    private static int maxArea(int[] height) {
        int left = 0 , right = height.length - 1;
        int result = 0;
        while (left < right) {
            result = Math.max(result, Math.min(height[left], height[right])*(right-left));
            if (height[left] < height[right])
                left++;
            else
                right--;
        }
        return result;
    }
}
