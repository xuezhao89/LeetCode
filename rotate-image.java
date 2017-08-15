/*

题目：
You are given an n x n 2D matrix representing an image.
Rotate the image by 90 degrees (clockwise).

Follow up:
Could you do this in-place?

思路：
先把原矩阵转换到转置矩阵，再反转转置矩阵的每一行。

注意：
转换至转置矩阵的同时可以反转转置后的当前行，不需要完全转换到转置矩阵再反转每一行。
*/



public class Solution {
    public void rotate(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = i; j < matrix[0].length; j++) {
                swapNum(matrix, i, j);
            }
            reverseRow(matrix[i]);
        }
    }
    
    private void swapNum(int[][] matrix, int i, int j) {
        int tmp = matrix[i][j];
        matrix[i][j] = matrix[j][i];
        matrix[j][i] = tmp;
    }
    
    private void reverseRow(int[] nums) {
        int i = 0;
        int j = nums.length - 1;
        while (i < j) {
            int tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
            i++;
            j--;
        }
    }
}