/*
��Ŀ��
Given an array of n integers where n > 1, nums, return an array output such that output[i] is equal to the product of all the elements of nums except nums[i].
Solve it without division and in O(n).
For example, given [1,2,3,4], return [24,12,8,6].
Follow up:
Could you solve it with constant space complexity? (Note: The output array does not count as extra space for the purpose of space complexity analysis.)

˼·��
�½�left��right������������ÿ������ߡ��ұ��������ĳ˻��������ұ������飬����ÿ������߳˻�������res���飬�ٴ��ҵ�����������ұ߳˻���ֱ�ӳ˵�֮ǰ��res������͵õ��������߳˻���˵Ľ����

ע�⣺
����Ҫ���ⶨ��left��right���顣
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