/*
题目：
Given a string S and a string T, find the minimum window in S which will contain all the characters in T in complexity O(n).
For example,
S = "ADOBECODEBANC"
T = "ABC"
Minimum window is "BANC".
Note:
If there is no such window in S that covers all characters in T, return the empty string "".
If there are multiple such windows, you are guaranteed that there will always be only one unique minimum window in S.

思路：
参考Find All Anagrams in a String
*/

class Solution {
    public String minWindow(String s, String t) {
        String result = "";
        if (s == "" || t.length() > s.length()) {
            return result;
        }
        int[] map = new int[256];
        int start = 0;
        int minStart = 0;
        int end = 0;
        int count = t.length();
        int minLength = Integer.MAX_VALUE;
        for (char temp : t.toCharArray()){
            map[temp]++;
        }
        while (end < s.length()) {
            if (map[s.charAt(end)] > 0) {
                count--;
            }
            map[s.charAt(end)]--;
            end++;
            while (count == 0) {
                if (end - start < minLength) {
                    minStart = start;
                    minLength = end - start;
                }
                map[s.charAt(start)]++;
                if (map[s.charAt(start)] > 0) {
                    count++;
                }
                start++;
            }
        }
        return (minLength == Integer.MAX_VALUE) ? "" : s.substring(minStart, minStart + minLength);
    }
}