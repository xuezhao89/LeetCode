/*
题目：
Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.
Example:
Input: "babad"
Output: "bab"
Note: "aba" is also a valid answer.
Example:
Input: "cbbd"
Output: "bb"

思路：
中心扩散法 Spread From Center
连续以某点为中心向外扩散判断是否是回文，当较小一层不是回文停止扩散时，记录当前回文字符串与maxStr比较长度决定是否更新，再更换中心点重新对外扩散。外层循环遍历子字符串的中心点，内层循环则从中心点向两边扩散，另外定义offset，从而实现扩散。
注意：
1.中心对称有两种情况：奇数个字母以某个字母为中心对称，或偶数字母以两个字母为中间对称，主函数分别计算这两种情况。
2.左右指针跳出循环时已分别进行减1和加1，所以取当前子字符串时左右指针应分别加1和减1，所以是.substring(left+1, right)。
*/

public class Solution {
    String longest = "";
    public String longestPalindrome(String s) {
        if (s == null || s.length() <= 1) {
            return s;
        }    
        for (int i = 0; i < s.length(); i++) {
            helper(s, i, 0);
            helper(s, i, 1);            
        }
        return longest;
    }
    
    private void helper(String s, int index, int offset) {
        int left = index;
        int right = index + offset;
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        String cur = s.substring(left + 1, right);
        if (cur.length() > longest.length()) {
            longest = cur;
        }
    }
}
