/*
题目：
Given two strings s and t, write a function to determine if t is an anagram of s.

For example,
s = "anagram", t = "nagaram", return true.
s = "rat", t = "car", return false.

Note:
You may assume the string contains only lowercase alphabets.

Follow up:
What if the inputs contain unicode characters? How would you adapt your solution to such case?

思路：
建HashMap保存s里每个字母和出现次数，再遍历t的每一个字母，如果t里出现map里没有的字母则返回错误，反之则减去相应出现次数。最后遍历map的values，如果有计数不为0则返回错误。

注意：
也可以用HashTable做，但没必要。
*/

public class Solution {
    public boolean isAnagram(String s, String t) {
        if (s == null || t == null || s.length() != t.length()) {
            return false;
        }
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            if (!map.containsKey(c)) {
                map.put(c, 1);
            } else {
                map.put(c, map.get(c) + 1);
            }
        }
        for (char c : t.toCharArray()) {
            if (!map.containsKey(c)) {
                return false;
            } else {
                map.put(c, map.get(c) - 1);
            }
        }
        for (Integer val : map.values()) {
            if (val != 0) {
                return false;
            }
        }
        return true;
    }
}