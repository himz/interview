package leetcode.matrix;

/**
 * You are given an n x n 2D matrix representing an image, rotate the image by 90 degrees (clockwise).
 *
 * You have to rotate the image in-place, which means you have to modify the input 2D matrix directly. DO NOT allocate another 2D matrix and do the rotation.
 *
 *
 *
 * Example 1:
 *
 * Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
 * Output: [[7,4,1],[8,5,2],[9,6,3]]
 *
 * Example 2:
 *
 * Input: matrix = [[5,1,9,11],[2,4,8,10],[13,3,6,7],[15,14,12,16]]
 * Output: [[15,13,2,5],[14,3,4,1],[12,6,8,9],[16,7,10,11]]
 *
 * Example 3:
 *
 * Input: matrix = [[1]]
 * Output: [[1]]
 *
 * Example 4:
 *
 * Input: matrix = [[1,2],[3,4]]
 * Output: [[3,1],[4,2]]
 * https://leetcode.com/problems/rotate-image/
 */


public class _48_RotateImageMatrix {
// Basic math. ClockRotation == transpose + reverse row. Anti Clock Rotation == transpose + reverse col
    /*
     * clockwise rotate
     * first swap the symmetry (i.e. transpose the matrix), then reverse each row
     * 1 2 3     1 4 7     7 4 1
     * 4 5 6  => 2 5 8  => 8 5 2
     * 7 8 9     3 6 9     9 6 3
     *
     * anti-clockwise rotate
     * first swap the symmetry (i.e. transpose the matrix), then reverse each col
     */
    public void rotate(int[][] image) {
        transposeImage(image);

        // reverse each row of the image
        for(int row = 0; row < image.length; row++) {
            int i = 0;
            int j = image[row].length - 1;
            while(i < j) {
                int tmp = image[row][i];
                image[row][i++] = image[row][j];
                image[row][j--] = tmp;
            }
        }
    }

    // Turns rows into cols and vice versa
    private void transposeImage(int[][] image) {
        for(int i = 0; i < image.length; i++) {
            for(int j = i + 1; j < image[i].length; j++) {
                int tmp = image[i][j];
                image[i][j] = image[j][i];
                image[j][i] = tmp;
            }
        }
    }
}
