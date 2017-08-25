/*
题目：
Given an array of size n, find the majority element. The majority element is the element that appears more than ⌊ n/2 ⌋ times.
You may assume that the array is non-empty and the majority element always exist in the array.

思路：
方法1：排序后返回最中间的数字
方法2：投票法。定义变量候选数candidate并初始为nums[0]，和一个计数器count并初始为1，从数组第二个数字（nums[1]）开始遍历，进行如下判断：
1.如果当前数字和candidate相等，则count加1；
2.如果不相等，且count不是0，则count抵消减1；
3.如果不相等，且count已经是0，则更新当前数字为新的candidate。

注意：
因为每一对不一样的数都会互相消去，最后留下来的candidate一定是所求数。
*/

class Solution {
    public int majorityElement(int[] nums) {
        int candidate = nums[0];
        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == candidate) {
                count++;
            } else if (count == 0) {
                candidate = nums[i];
            } else {
                count--;
            }
        }
        return candidate;
    }
}
