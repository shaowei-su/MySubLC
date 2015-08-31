/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
// without recursion
public class Solution {
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
        	return false;
        }
        Queue<TreeNode> nodes = new LinkedList<TreeNode>();
        Queue<Integer> values = new LinkedList<Integer>();
        nodes.offer(root);
        values.offer(root.val);

        while (!nodes.isEmpty()) {
        	TreeNode cur = nodes.poll();
        	int sumValue = values.poll();

        	if (cur.left == null && cur.right == null && sumValue == sum) {
        		return true;
        	}
        	if (cur.left != null) {
        		nodes.offer(cur.left);
        		values.offer(sumValue + cur.left.val);
        	}
        	if (cur.right != null) {
        		nodes.offer(cur.right);
        		values.offer(sumValue + cur.right.val);
        	}
        }

        return false;
    }
}