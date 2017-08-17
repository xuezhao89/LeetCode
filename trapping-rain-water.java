/*
��Ŀ��
Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it is able to trap after raining.
For example, 
Given [0,1,0,2,1,0,1,3,2,1,2,1], return 6.

˼·��
��������������������������ָ�����м��ߣ�ȡ���߶̵���Ϊˮƽ�ߣ���ǰ�߶ȵ���ˮƽ��ʱ�������������������ˮƽ���뵱ǰ�ĸ߶Ȳ�*��ȣ�����Ϊ1���������������м��ߣ������һ���Ǹ��͵㣬�ظ�ͬ���Ĳ��裻�����ˮƽ�߸ߣ���������ǰѭ�����Ƚ��µ�����ָ�룬ȡ�µ�ˮƽ�ߣ����ظ����ϲ��衣

ע�⣺��Ҫ����left��end��smaller��area��
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