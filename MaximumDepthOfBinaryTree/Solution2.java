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

	public void maxDepthHelper(TreeNode root, res) {
		if (root == null) {
			return 
		}
	}

    public int maxDepth(TreeNode root) {
        if (root == null) {
        	return 0;
        }
        int res = 0;

        maxDepthHelper(root, res);

        return res;
    }
}