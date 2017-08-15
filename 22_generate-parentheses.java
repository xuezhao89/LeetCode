
/*
题目：
思路：通过向string插入“（”和“）”直到两者数量都为n，则视为一个combination构建完成；
生成“（”的条件是：只要“（”的数量没到n，就可以插入“（”；
可以插入“）”的前提是：当前的“（”数量大于当前的“）”数量
递归终止条件：“（”和“）”的数量相等，且等于n
注意：这种问题不可能按照"顺序"结构进行罗列的,一定是用到了递归"做了一部分事情,剩下的递归去做"的核心；
"穷举"这种情况,最合适的就是"回溯法"；
这里应该是对回溯法的一个扩展(右括号的数量永远小于等于左括号)。
思考：
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
