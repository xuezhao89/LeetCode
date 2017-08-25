/*
题目：
Given n non-negative integers a1, a2, ..., an, where each represents a point at coordinate (i, ai). n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). Find two lines, which together with x-axis forms a container, such that the container contains the most water.
Note: You may not slant the container and n is at least 2.

思路：
高的板不动，调整短的板。
当前面积=短板高度*两板距离之差
*/

class Solution {
    public int maxArea(int[] height) {
        int start = 0;
        int end = height.length - 1;
        int area = 0;
        int max = 0;
        while (start < end) {
            if (height[start] < height[end]) {
                area = height[start] * (end - start);
                start++;
            } else {
                area = height[end] * (end - start);
                end--;
            }
            max = Math.max(max, area);
        }
        return max;
    }
}