/*
题目：
Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
For example, given n = 3, a solution set is:
[
  "((()))",
  "(()())",
  "(())()",
  "()(())",
  "()()()"
]

思路：
当剩余可放左括号个数大于0时，就可以放新的左括号；当剩余可放右括号个数大于0且大于剩余可放左括号个数时，就可以放新的右括号。
跳出条件是当左右括号的剩余可放个数相等，且都等于0。

注意：这种问题不可能按照"顺序"结构进行罗列的,一定是用到了递归"做了一部分事情,剩下的递归去做"的核心；
"穷举"这种情况,最合适的就是"回溯法"；
这里应该是对回溯法的一个扩展(右括号的数量永远小于等于左括号)。
*/

public class Solution {
    /**
     * @param n n pairs
     * @return All combinations of well-formed parentheses
     */
    public ArrayList<String> generateParenthesis(int n) {
        // Write your code here
        ArrayList<String> result = new ArrayList<String>();
        if (n <= 0) {
            return result;
        }
        helper(result, "", n, n);
        return result;
    }
    
    public void helper(ArrayList<String> result,
	                   String paren, // current parentheses
	                   int left,     // how many left paren we need to add
	                   int right) {  // how many right paren we need to add
	if (left == 0 && right == 0) {
		result.add(paren);
		return;
	}

        if (left > 0) {
		    helper(result, paren + "(", left - 1, right);
        }
        
        if (right > 0 && left < right) {
		    helper(result, paren + ")", left, right - 1);
        }
    }
}
