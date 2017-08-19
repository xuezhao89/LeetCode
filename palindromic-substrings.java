/*
题目：
Given a string, your task is to count how many palindromic substrings in this string.
The substrings with different start indexes or end indexes are counted as different substrings even they consist of same characters.
Example 1:
Input: "abc"
Output: 3
Explanation: Three palindromic strings: "a", "b", "c".
Example 2:
Input: "aaa"
Output: 6
Explanation: Six palindromic strings: "a", "a", "a", "aa", "aa", "aaa".
Note:
The input string length won't exceed 1000.

思路：
参考Longest Palindromic Substring
*/

class Solution {
    public int countSubstrings(String s) {
        int oddCase = 0;
        int evenCase = 0;
        for (int i = 0; i < s.length(); i++) {
            oddCase += helper(s, i, 0);
            evenCase += helper(s, i, 1);
        }
        return oddCase + evenCase;
    }
    
    private int helper(String s, int idx, int offset) {
        int count = 0;
        int left = idx;
        int right = idx + offset;
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            count++;
            left--;
            right++;
        }
        return count;
    }
}