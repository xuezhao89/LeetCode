/*
题目：
Given a string s and a non-empty string p, find all the start indices of p's anagrams in s.
Strings consists of lowercase English letters only and the length of both strings s and p will not be larger than 20,100.
The order of output does not matter.
Example 1:
Input:
s: "cbaebabacd" p: "abc"
Output:
[0, 6]
Explanation:
The substring with start index = 0 is "cba", which is an anagram of "abc".
The substring with start index = 6 is "bac", which is an anagram of "abc".
Example 2:
Input:
s: "abab" p: "ab"
Output:
[0, 1, 2]
Explanation:
The substring with start index = 0 is "ab", which is an anagram of "ab".
The substring with start index = 1 is "ba", which is an anagram of "ab".
The substring with start index = 2 is "ab", which is an anagram of "ab".

思路：
创建一个HashTable记录p中有哪些字母及出现次数，定义变量count记录距离找到符合条件的窗口还差几个字符，维护左右窗口。
先移动右窗口，当新加入右窗口字符在p里出现过，count减1；HashTable相应计数减1；当count等于0时说明找到一个匹配，加到结果里，右窗口加1。
当窗口总长度等于p的长度时，需要抛弃左窗口，找新的左窗口：当前左窗口的字符如果在p里出现过，要把count加回来；HashTable相应计数加1，左窗口加1。

注意：
滑动右窗口时，不管右窗口字符是否在p里出现，HashTable相应数字都要减1；滑动左窗口时，不管左窗口字符是否在p里出现，都要抛弃当前左窗口，因此HashTable里相应计数也要加回来。
*/

public class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        if (s == null || s.length() == 0 || p == null || p.length() == 0) {
            return res;
        }
        // 记录p中有哪些字符，及各自出现次数
        int[] hash = new int[256];
        char[] pa = p.toCharArray();
        for (char c : pa) {
            // 记录完毕
            hash[c]++;
        }
        // 左右窗口
        int left = 0;
        int right = 0;
        // 记录距离找到符合条件的窗口还差几个字符
        int count = p.length();
        while (right < s.length()) {
            // 当加进来的右窗口字符在p里出现过，count减1
            if (hash[s.charAt(right)] >= 1) {
                count--;
            }
            // 不管该字符是否在p里，hash里相应计数都要减1
            hash[s.charAt(right)]--;
            // 滑动右窗口
            right++;
            // 此时出现一个匹配，把左窗口加入到结果里
            if (count == 0) {
                res.add(left);
            }
            // 当窗口长度等于p的长度时，抛弃现有左窗口，找新的符合条件的窗口
            if (right - left == p.length()) {
                // 当left所指字符对应计数不为负，说明count之前做过减法，因此要加回来
                if (hash[s.charAt(left)] >= 0) {
                    count++;
                }
                // 现在的左窗口要被抛弃，因此hash里相应计数要加回来
                hash[s.charAt(left)]++;
                // 滑动左窗口
                left++;
            }
        }       
        return res;
    }
}

