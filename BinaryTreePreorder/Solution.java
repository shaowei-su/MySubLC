import java.util.*;
/* 
* 
* 
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {

	public void preOrderHelper(List<Integer> res, TreeNode root) {
		if (root == null) {
			return ;
		}
		res.add(root.val);
		preOrderHelper(res, root.left);
		preOrderHelper(res, root.right);

		return ;
	}

    public List<Integer> preorderTraversal(TreeNode root) {

        List<Integer> res = new ArrayList<Integer>();
        preOrderHelper(res, root);

        return res;
    }
}