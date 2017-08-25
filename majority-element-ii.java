/*
题目：
Given an integer array of size n, find all elements that appear more than ⌊ n/3 ⌋ times. The algorithm should run in linear time and in O(1) space.

思路：
对于一个数组来说，出现次数超过1/3的数最多只可能有两个：定义candidate1并初始化为nums[0]，count1并初始化为1；candidate2并初始化为nums[1]，count2并初始化为1。
从第三个数字开始遍历数组，进行如下判断，找出出现次数最多的两个candidate：
1.如果nums[i]和某个candidate相等，则对应count加1；
2.如果不相等，且两个count都不为0，则两个count都被抵消减1；
3.如果不相等，且某个count为0，则其对应candidate被nums[i]替换，并将新的count重置为1。
最后重新遍历整个数组，计算两个candidate出现次数后把出现次数超过数组大小1/3的加入结果。

注意：
之所有最后要再遍历数组，是为了避免出现次数最多的也不足1/3的情况，比如[1,2,3]。
*/

class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> res = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return res;
        }
        
        if (nums.length <= 1) {
            res.add(nums[0]);
            return res;
        }
        
        int candidate1 = nums[0];
        int count1 = 1;
        int candidate2 = 0;
        int count2 = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == candidate1 || nums[i] == candidate2) {
                if (nums[i] == candidate1) {
                    count1++;
                } else {
                    count2++;
                }
            } else if (count1 == 0 || count2 == 0) {
                if (count1 == 0) {
                    candidate1 = nums[i];
                    count1 = 1;
                } else {
                    candidate2 = nums[i];
                    count2 = 1;
                }
            } else {
                count1--;
                count2--;
            }
        }
        count1 = 0;
        count2 = 0;
        for (int n : nums) {
            if (n == candidate1) {
                count1++;
            } else if (n == candidate2) {
                count2++;
            }
        }
        if (count1 > nums.length / 3) {
            res.add(candidate1);
        } 
        if (count2 > nums.length / 3) {
            res.add(candidate2);
        }
        return res;
    }
}