/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

import java.util.*;

public class Solution {

	public void inorderHelper(List<Integer> res, TreeNode root) {
		if (root == null) {
			return;
		}

		inorderHelper(res, root.left);
		res.add(root.val);
		inorderHelper(res, root.right);

		return;
	}

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        if (root == null) {
        	return res;
        }
        inorderHelper(res, root);

        return res;
    }
}