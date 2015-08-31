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
    TreeNode first = null;
    TreeNode second = null;
    TreeNode prev = new TreeNode(Integer.MIN_VALUE);

	public void recoverHelper(TreeNode root) {
		if (root == null) {
			return;
		}
		recoverHelper(root.left);
		if (first == null && prev.val > root.val) {
			first = prev;
			second = root;
		}
		if (first != null && prev.val > root.val) {
			second = root;
		}
		prev = root;
		recoverHelper(root.right);
		return;
	}

	public void swap(TreeNode first, TreeNode second) {
		int temp = first.val;
		first.val = second.val;
		second.val = temp;
	}

    public void recoverTree(TreeNode root) {
        if (root == null) {
        	return ;
        }



        recoverHelper(root);

        swap(first, second);
    }

}