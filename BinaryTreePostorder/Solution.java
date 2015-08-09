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

	public void postorderHelper(List<Integer> res, TreeNode root) {
		if (root == null) {
			return;
		}

		postorderHelper(res, root.left);
		postorderHelper(res, root.right);
		res.add(root.val);

		return;
	}

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();

        if (root == null) {
        	return res;
        }

        postorderHelper(res, root);

        return res;
    }
}