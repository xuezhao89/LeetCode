
/*
题目：
思路：遍历字符串的每一个元素时进行如下判断：遇见左括号就把对应的右括号加进栈，遇见右括号就进行如下判断；如果栈为空，说明之前没有遇见其对应的左括号，所以返回错误；如果栈不为空，判断出栈元素是否和当前括号一致，不一致也返回错误。
注意：遍历结束后要最后检查stack是否为空，不为空返回错误。
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