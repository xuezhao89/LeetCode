/*
题目：
Given an array of n integers where n > 1, nums, return an array output such that output[i] is equal to the product of all the elements of nums except nums[i].
Solve it without division and in O(n).
For example, given [1,2,3,4], return [24,12,8,6].
Follow up:
Could you solve it with constant space complexity? (Note: The output array does not count as extra space for the purpose of space complexity analysis.)

思路：
新建left，right两个变量保存每个点左边、右边所有数的乘积；从左到右遍历数组，计算每个点左边乘积并存入res数组，再从右到左遍历计算右边乘积后，直接乘到之前的res数组里，就得到左右两边乘积相乘的结果。

注意：
不需要额外定义left和right数组。
*/

public class Solution {
    public int[] productExceptSelf(int[] nums) {
        if (nums.length <= 1) {
            return nums;
        }
        
        int[] res = new int[nums.length];
        res[0] = 1;
        int left = 1;
        int right = 1;
        for (int i = 1; i < nums.length; i++) {
            left = left * nums[i - 1];
            res[i] = left;
        }
        for (int i = nums.length - 2; i >= 0; i--) {
            right = right * nums[i + 1];
            res[i] = right * res[i];
        }
        return res;
    }
}