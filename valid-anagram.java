/*
��Ŀ��
Given two strings s and t, write a function to determine if t is an anagram of s.

For example,
s = "anagram", t = "nagaram", return true.
s = "rat", t = "car", return false.

Note:
You may assume the string contains only lowercase alphabets.

Follow up:
What if the inputs contain unicode characters? How would you adapt your solution to such case?

˼·��
��HashMap����s��ÿ����ĸ�ͳ��ִ������ٱ���t��ÿһ����ĸ�����t�����map��û�е���ĸ�򷵻ش��󣬷�֮���ȥ��Ӧ���ִ�����������map��values������м�����Ϊ0�򷵻ش���

ע�⣺
Ҳ������HashTable������û��Ҫ��
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