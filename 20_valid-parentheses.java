
/*
题目：
Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.

思路：
新建HashMap保存括号对应关系，新建Stack；
遍历字符串的每一个元素，遇见左括号就把对应的右括号加进栈，遇见右括号判断：1.如果栈为空，说明之前没有遇见其对应的左括号，返回错误；2.如果栈不为空，判断出栈元素是否和当前括号一致，不一致也返回错误。

注意：
当遇见右括号时，先检查Stack是否为空，为空则返回错误；
遍历结束后，最后检查Stack是否为空，不为空返回错误。

思考：
*/
public class Solution {
    /**
     * @param s A string
     * @return whether the string is a valid parentheses
     */
    public boolean isValidParentheses(String s) {
        // Write your code here
        if (s == null || s.length() == 0) {
            return true;
        }
        Map<Character, Character> pairMap = new HashMap<Character, Character>();
        pairMap.put('(', ')');
        pairMap.put('[', ']');
        pairMap.put('{', '}');
        
        Stack<Character> stack = new Stack<Character>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '[' || c == '{') {
                stack.push(pairMap.get(c));
            } else if (c == ')' || c == ']' || c == '}') {
                if (stack.isEmpty()) {
                    return false;
                }
                char c2 = stack.pop();
                if (c2 != c) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
