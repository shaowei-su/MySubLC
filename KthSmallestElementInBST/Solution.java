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

	public void inorder(TreeNode root, ArrayList<Integer> list) {
		if (root == null) {
			return ;
		}
		inorder(root.left, list);
		list.add(root.val);
		inorder(root.right, list);

		return;
	}

    public int kthSmallest(TreeNode root, int k) {
        if (root == null) {
        	return 0;
        }

        ArrayList<Integer> list = new ArrayList<Integer>();
        inorder(root, list);

        return list.get(k - 1);
    }
}