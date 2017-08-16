/*
��Ŀ��
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

˼·��
����һ��HashTable��¼p������Щ��ĸ�����ִ������������count��¼�����ҵ����������Ĵ��ڻ�����ַ���ά�����Ҵ��ڡ�
���ƶ��Ҵ��ڣ����¼����Ҵ����ַ���p����ֹ���count��1��HashTable��Ӧ������1����count����0ʱ˵���ҵ�һ��ƥ�䣬�ӵ������Ҵ��ڼ�1��
�������ܳ��ȵ���p�ĳ���ʱ����Ҫ�����󴰿ڣ����µ��󴰿ڣ���ǰ�󴰿ڵ��ַ������p����ֹ���Ҫ��count�ӻ�����HashTable��Ӧ������1���󴰿ڼ�1��

ע�⣺
�����Ҵ���ʱ�������Ҵ����ַ��Ƿ���p����֣�HashTable��Ӧ���ֶ�Ҫ��1�������󴰿�ʱ�������󴰿��ַ��Ƿ���p����֣���Ҫ������ǰ�󴰿ڣ����HashTable����Ӧ����ҲҪ�ӻ�����
*/

public class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        if (s == null || s.length() == 0 || p == null || p.length() == 0) {
            return res;
        }
        // ��¼p������Щ�ַ�������������
        int[] hash = new int[256];
        char[] pa = p.toCharArray();
        for (char c : pa) {
            // ��¼���
            hash[c]++;
        }
        // ���Ҵ���
        int left = 0;
        int right = 0;
        // ��¼�����ҵ����������Ĵ��ڻ�����ַ�
        int count = p.length();
        while (right < s.length()) {
            // ���ӽ������Ҵ����ַ���p����ֹ���count��1
            if (hash[s.charAt(right)] >= 1) {
                count--;
            }
            // ���ܸ��ַ��Ƿ���p�hash����Ӧ������Ҫ��1
            hash[s.charAt(right)]--;
            // �����Ҵ���
            right++;
            // ��ʱ����һ��ƥ�䣬���󴰿ڼ��뵽�����
            if (count == 0) {
                res.add(left);
            }
            // �����ڳ��ȵ���p�ĳ���ʱ�����������󴰿ڣ����µķ��������Ĵ���
            if (right - left == p.length()) {
                // ��left��ָ�ַ���Ӧ������Ϊ����˵��count֮ǰ�������������Ҫ�ӻ���
                if (hash[s.charAt(left)] >= 0) {
                    count++;
                }
                // ���ڵ��󴰿�Ҫ�����������hash����Ӧ����Ҫ�ӻ���
                hash[s.charAt(left)]++;
                // �����󴰿�
                left++;
            }
        }       
        return res;
    }
}

