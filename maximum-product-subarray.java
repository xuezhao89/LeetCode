/*
题目：
Find the contiguous subarray within an array (containing at least one number) which has the largest product.
For example, given the array [2,3,-2,4],
the contiguous subarray [2,3] has the largest product = 6.

思路：
维护两个数组：max用来维护局部最大，min维护局部最小，这样如果下一个元素遇到负数时，就有可能与这个最小相乘得到当前最大的乘积和。遍历的同时比较res和max[i]的大小，更新res。

注意：
不要忘了定义res；
遍历的开始不要忘了初始化max[i] = min[i] = nums[i]。
*/

public class Solution {
    public int maxProduct(int[] nums) {
        int[] max = new int[nums.length];
        int[] min = new int[nums.length];
        max[0] = min[0] = nums[0];
        int res = nums[0];
        for (int i = 1; i < nums.length; i++) {
            max[i] = min[i] = nums[i];
            if (nums[i] >= 0) {
                max[i] = Math.max(max[i], max[i - 1] * nums[i]);
                min[i] = Math.min(min[i], min[i - 1] * nums[i]);
            } else {
                max[i] = Math.max(max[i], min[i - 1] * nums[i]);
                min[i] = Math.min(min[i], max[i - 1] * nums[i]); 
            }
            res = Math.max(res, max[i]);
        }
        return res;
    }
}