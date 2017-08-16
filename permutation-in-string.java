/*
题目：
Given two strings s1 and s2, write a function to return true if s2 contains the permutation of s1. In other words, one of the first string's permutations is the substring of the second string.
Example 1:
Input:s1 = "ab" s2 = "eidbaooo"
Output:True
Explanation: s2 contains one permutation of s1 ("ba").
Example 2:
Input:s1= "ab" s2 = "eidboaoo"
Output: False
Note:
The input strings only contain lower case letters.
The length of both given strings is in range [1, 10,000].

思路：
参考find-all-anagrams-in-a-string
*/

public class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int[] table = new int[256];
        for (char c : s1.toCharArray()) {
            table[c]++;
        }
        int count = s1.length();
        int left = 0;
        int right = 0;
        while (right < s2.length()) {
            if (table[s2.charAt(right)] >= 1) {
                count--;
            }
            table[s2.charAt(right)]--;
            right++;
            if (count == 0) {
                return true;
            }
            if (right - left == s1.length()) {
                if (table[s2.charAt(left)] >= 0) {
                    count++;
                }
                table[s2.charAt(left)]++;
                left++;
            }
        }
        return false;
    }
}
