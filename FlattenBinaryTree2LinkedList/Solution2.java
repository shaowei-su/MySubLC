/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
//recursive inorder traversal
public class Solution {

    public void flattenHelper(TreeNode root, ArrayList<TreeNode> list) {
        if (root == null) {
            return;
        }
        TreeNode right = root.right;
        if (list.get(0) != null) {
            list.get(0).left = null;
            list.get(0).right = root;
        }
        list.set(0, root);
        flattenHelper(root.left, list);
        flattenHelper(right, list);
    }

    public void flatten(TreeNode root) {
        if (root == null) {
        	return;
        }
        ArrayList<TreeNode> list = new ArrayList<TreeNode>();
        list.add(null);
        flattenHelper(root, list);
    }
}