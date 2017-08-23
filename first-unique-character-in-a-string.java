/*
题目：
Given a string, find the first non-repeating character in it and return it's index. If it doesn't exist, return -1.
Examples:
s = "leetcode"
return 0.
s = "loveleetcode",
return 2.
Note: You may assume the string contain only lowercase letters.

思路：
建HashMap，遍历字符串的同时保存每个字母出现的次数；遍历结束后再次遍历字符串，找出HashMap中出现次数为1对应的字母。
*/

public class Solution {
    public int firstUniqChar(String s) {
        if (s == null || s.length() == 0) {
			return -1;
		}

		//用来统计字符出现的次数
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		//首先循环遍历一次，统计出各个字符出现的次数
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (!map.containsKey(c)) {
				map.put(c, 1);
			} else {
				map.put(c, map.get(c) + 1);//如果在map中存在该字符了，则次数+1;
			}
		}
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (map.get(c) == 1) {
			    return i;
			}
		}
		
		return -1;
    }
}