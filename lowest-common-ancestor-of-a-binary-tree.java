/*
题目：
Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.
According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes v and w as the lowest node in T that has both v and w as descendants (where we allow a node to be a descendant of itself).”
        _______3______
       /              \
    ___5__          ___1__
   /      \        /      \
   6      _2       0       8
         /  \
         7   4
For example, the lowest common ancestor (LCA) of nodes 5 and 1 is 3. Another example is LCA of nodes 5 and 4 is 5, since a node can be a descendant of itself according to the LCA definition.

思路：
如果root为null或root为A、B其中一个节点，则通过返回该root标记该子树发现了某个目标结点；
分治左右子树，查看左右子树是否有目标结点，没有为null；
如果分治结果都不为空，说明左右子树都有目标结点，则公共祖先就是root本身；
如果左右子树其中一个不为空，则继续向上标记为该目标节点。
*/

/**
 * Definition of TreeNode:
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left, right;
 *     public TreeNode(int val) {
 *         this.val = val;
 *         this.left = this.right = null;
 *     }
 * }
 */
public class Solution {
    /**
     * @param root: The root of the binary search tree.
     * @param A and B: two nodes in a Binary.
     * @return: Return the least common ancestor(LCA) of the two nodes.
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode A, TreeNode B) {
        // write your code here
	//发现目标节点则通过返回值标记该子树发现了某个目标结点
        if (root == null || root == A || root == B) {
            return root;
        }
        //查看左子树中是否有目标结点，没有为null
        TreeNode left = lowestCommonAncestor(root.left, A, B);
	//查看右子树是否有目标节点，没有为null
        TreeNode right = lowestCommonAncestor(root.right, A, B);
	//都不为空，说明左右子树都有目标结点，则公共祖先就是本身
        if (left != null && right != null) {
            return root;
        }
	//如果发现了目标节点，则继续向上标记为该目标节点
        if (left != null) {
            return left;
        }
        if (right != null) {
            return right;
        }
        
        return null;
    }
}
