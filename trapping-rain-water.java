/*
题目：
Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it is able to trap after raining.
For example, 
Given [0,1,0,2,1,0,1,3,2,1,2,1], return 6.

思路：
把这道题想象成填土，取left和right中较低的（以left为例）作为水平线smaller，继续移动left指针，如果所到高度小于或等于水平线即可填土，填土面积是水平线与当前的高度差(smaller - height[left])*宽度（此题为1），填土后left指针继续移动，重复以上步骤，直到所到高度高于水平线，这时跳出内循环，再通过比较left和right所在高度更新水平线。

注意：
需要定义left，end，smaller表示水平线，area；外层循环限制条件是while (left < right)，里面分析两种情况：if (height[left] < height[right]和else；内层循环限制条件是while (left < right && height[left] <= smaller)和while (left < right && height[right] <= smaller)。
*/

public class Solution {
    public int trap(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int smaller = 0;
        int area = 0;
        
        while (left < right) {
            if (height[left] < height[right]) {
                smaller = height[left];
                while (left < right && height[left] <= smaller) {
                    area += (smaller - height[left]) * 1;
                    left++;
                }
            } else {
                smaller = height[right];
                while (left < right && height[right] <= smaller) {
                    area += (smaller - height[right]) * 1;
                    right--;
                }
            }
        }
        return area;
    }
}
