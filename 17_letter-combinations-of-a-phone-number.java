/*
题目：
Given a digit string, return all possible letter combinations that the number could represent.
A mapping of digit to letters (just like on the telephone buttons) is given below.

Input:Digit string "23"
Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].

Note:
Although the above answer is in lexicographical order, your answer could be in any order you want.
    
思路：
创建一个HashMap保存号码和字母的映射关系，然后对于号码的每一位找出其对应的字符串，定义为candidate；遍历candiate的每一个字母，再进行DFS，找出candidate每一个字母和号码剩下数字对应的字符串里字母组合的所有可能性。
以“23”为例：第一个数字“2”，其对应的字母有“abc”，那么此时只需要知道“3”可能代表的字符串有哪些，然后将"abc"的每一个字母与“def”的每一个字母一一组合起来，便可得到全部的解。

注意：
用StringBuilder构建临时字符串；
当临时字符串为空时，不用将其加入结果列表中。
*/

public class Solution {
    List<String> res = new ArrayList<String>();

    public List<String> letterCombinations(String digits) {
        // 建立映射表
        String[] table = {" ", " ", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        StringBuilder tmp = new StringBuilder();
        helper(table, 0, tmp, digits);
        return res;
    }

    private void helper(String[] table, int idx, StringBuilder tmp, String digits) {
        if (idx == digits.length()) {
            // 找到一种结果，加入列表中
            if (tmp.length() != 0) {
                res.add(tmp.toString());
            }
        } else {
            // 找出当前位数字对应可能的字母
            String candidates = table[digits.charAt(idx) - '0'];
            // 对每个可能字母进行搜索
            for (int i = 0; i < candidates.length(); i++) {
                tmp.append(candidates.charAt(i));
                helper(table, idx + 1, tmp, digits);
                tmp.deleteCharAt(tmp.length() - 1);
            }
        }
    }
}
