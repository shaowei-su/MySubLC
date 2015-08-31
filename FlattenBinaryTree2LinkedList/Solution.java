/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void flatten(TreeNode root) {
        if (root == null) {
        	return;
        }
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode pointer = root;

        while (!stack.isEmpty() || pointer != null) {
        	if (pointer.right != null) {
        		stack.push(pointer.right);
        	}
        	if (pointer.left != null) {
        		pointer.right = pointer.left;
        		pointer.left = null;
        	} else if (!stack.isEmpty()) {
        		TreeNode poped = stack.peek();
        		stack.pop();
        		pointer.right = poped;
        	}
        	pointer = pointer.right;
        }

        return;
    }
}