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

	public int sumHelper(TreeNode root, int crt) {
		if (root == null) {
			return 0;
		}
		int rootVal = root.val;
		crt = crt * 10 + rootVal;
		if (root.left == null && root.right == null) {
			return crt;
		}
		return sumHelper(root.left, crt) + sumHelper(root.right, crt);
	}

    public int sumNumbers(TreeNode root) {

        return sumHelper(root, 0);
    }
}