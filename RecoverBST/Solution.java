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
	ArrayList<TreeNode> list = new ArrayList<TreeNode>();

	public void inorder(TreeNode root) {
		if (root == null) {
			return;
		}
		inorder(root.left);
		list.add(root);
		inorder(root.right);

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
        
        inorder(root);

        TreeNode first = null;
        TreeNode second = null;
        TreeNode prev = list.get(0);
        for (int i = 1; i < list.size(); i++) {
        	TreeNode cur = list.get(i);
        	if (prev.val > cur.val) {
        		if (first == null) {
        			first = prev;
        			second = cur;
        		} else {
        			second = cur;
        			break;
        		}
        	}
        	prev = cur;
        }

        swap(first, second);

    }
}