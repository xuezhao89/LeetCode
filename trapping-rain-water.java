/*
题目：
Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it is able to trap after raining.
For example, 
Given [0,1,0,2,1,0,1,3,2,1,2,1], return 6.

思路：
把这道题想成是填土，左右两个指针往中间走，取两边短的作为水平线，当前高度低于水平线时即可填土，填土面积是水平线与当前的高度差*宽度（此题为1），填完后继续往中间走，如果下一个是更低点，重复同样的步骤；如果比水平线高，则跳出当前循环，比较新的左右指针，取新的水平线，再重复以上步骤。

注意：需要定义left，end，smaller，area。
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