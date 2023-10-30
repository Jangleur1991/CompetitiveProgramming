package techniques.twoPointer.reverseswapping;

import java.util.Arrays;

/**
 * Given an n x n binary matrix image, flip the image horizontally, then invert it, and return the resulting image.
 *
 * To flip an image horizontally means that each row of the image is reversed.
 *
 * For example, flipping [1,1,0] horizontally results in [0,1,1].
 * To invert an image means that each 0 is replaced by 1, and each 1 is replaced by 0.
 *
 * For example, inverting [0,1,1] results in [1,0,0].
 *
 * https://leetcode.com/problems/flipping-an-image/editorial/
 */
public class FlipAndRevertImage {
    public static void main(String[] args) {
        int[][] image1 = new int[][]{new int[]{1,1,0},new int[]{1,0,1},new int[]{0,0,0}};
        int[][] image2 = new int[][]{new int[]{1,1,0,0},new int[]{1,0,0,1},new int[]{0,1,1,1},new int[]{1,0,1,0}};

        System.out.println(Arrays.deepToString(flipAndInvertImage(image1))); //[[1,0,0],[0,1,0],[1,1,1]]
        System.out.println(Arrays.deepToString(flipAndInvertImage(image2))); // [[1,1,0,0],[0,1,1,0],[0,0,0,1],[1,0,1,0]]
    }

    private static int[][] flipAndInvertImage(int[][] image) {
        int rowLength = image[0].length;
        for (int[] row: image) {
            for (int i = 0; i < ((rowLength+1)/2); i++) { // Two pointer with a for loop!!!
                int tmp = flipValue(row[i]);
                row[i] = flipValue(row[rowLength-1-i]);
                row[rowLength-1-i] = tmp;
            }
        }
        return image;
    }

    private static int flipValue(int value) {
        return value ^ 1; // XOR. 0^1=1, 1^1=0
    }
}
