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

	public TreeNode buildHelper(int[] inorder, int inStart, int inEnd, int[] postorder, int postStart, int postEnd) {
		if (inStart > inEnd || postStart > postEnd) {
			return null;
		}
		TreeNode root = new TreeNode(postorder[postEnd]);
		int pos = 0;
		for (int i = 0; i < inorder.length; i++) {
			if (inorder[i] == postorder[postEnd]) {
				pos = i;
				break;
			}
		}
		TreeNode left = buildHelper(inorder, inStart, pos - 1, postorder, postStart, postStart + pos - inStart - 1);
		TreeNode right = buildHelper(inorder, pos + 1, inEnd, postorder, postStart + pos - inStart, postEnd - 1);

		root.left = left;
		root.right = right;
		return root;
	}

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder == null || postorder == null || inorder.length == 0 || postorder.length == 0) {
        	return null;
        }

        return buildHelper(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
    }
}