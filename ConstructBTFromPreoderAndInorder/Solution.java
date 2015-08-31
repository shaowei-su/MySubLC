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

	public TreeNode buildHelper(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd) {
        if (inEnd < inStart || preEnd < preStart) {
        	return null;
        }

        TreeNode root = new TreeNode(preorder[preStart]);
        int pos = 0;
        for (int i = 0; i < inorder.length; i++) {
        	if (inorder[i] == preorder[preStart]) {
        		pos = i;
        		break;
        	}
        }
        //left
        TreeNode left = buildHelper(preorder, preStart + 1, preStart + (pos - inStart), inorder, inStart, pos - 1);
        root.left = left;
        //right
        TreeNode right = buildHelper(preorder, preStart + (pos - inStart) + 1, preEnd, inorder, pos + 1, inEnd);
        root.right = right;

        return root;
	}

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || inorder == null || preorder.length == 0 || inorder.length == 0) {
        	return null;
        }

        return buildHelper(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }
}