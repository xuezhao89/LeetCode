/*
题目：
Given a string s, find the longest palindromic subsequence's length in s. You may assume that the maximum length of s is 1000.
Example 1:
Input:
"bbbab"
Output:
4
One possible longest palindromic subsequence is "bbbb".
Example 2:
Input:
"cbbd"
Output:
2
One possible longest palindromic subsequence is "bb".

思路：
当已知一个序列是回文时，添加首尾元素后的序列存在两种情况：当首尾元素相等，则最长回文的长度加2；当首尾元素不相等，则最长回文序列为仅添加首元素时的最长回文与仅添加尾元素时的最长回文之间的最大值。
用dp[i][j]表示s[i, j]的最长回文序列，状态转移方程是：
1. 当i > j：dp[i][j] = 0； 
2. 当i == j：dp[i][j] = 1； 
3. 当i < j且s[i] == s[j]，dp[i][j] = dp[i + 1][j - 1] + 2； 
4. 当i < j且s[i] != s[j]，dp[i][j] = max(dp[i + 1][j]，dp[i][j - 1])；

注意：
这道题求的是最长回文子序列，而不是子串，序列的意思是组成回文的字符可以是不连续的。
计算dp[i][j]时需要用到dp[i+1][j - 1]和dp[i + 1][j]，所以对i的遍历应从尾部开始。
最后返回的是dp[0][s.length() - 1]。
/*

class Solution {
    public int longestPalindromeSubseq(String s) {
        int len = s.length();
        int[][] dp = new int[len][len];
        for (int i = len - 1; i >= 0; i--) {
            dp[i][i] = 1;
            for (int j = i + 1; j < len; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[0][len - 1];
    }
}