/*
题目：
Find the contiguous subarray within an array (containing at least one number) which has the largest sum.
For example, given the array [-2,1,-3,4,-1,2,1,-5,4],
the contiguous subarray [4,-1,2,1] has the largest sum = 6.
More practice:
If you have figured out the O(n) solution, try coding another solution using the divide and conquer approach, which is more subtle.

思路：
定义变量sum保存包括当前数的数字和，变量max保存所求的连续最大和；如果sum大于max则更新max，同时如果sum小于0就归零重新累加。

注意：
遍历的时候sum是从第一位数字开始计算的，因此初始值设为0，而不是nums[0]；max的初始值设为nums[0]或Integer.MIN_VALUE都可以。
/*

class Solution {
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int sum = 0;
        int max = nums[0];
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (sum > max) {
                max = sum;
            }
            if (sum < 0) {
                sum = 0;
            }
        }
        return max;
    }
}
