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

    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (root.left == null && root.right == null) {
            return true;
        }
        if (root.left == null || root.right == null) {
            return false;
        }

        Queue<TreeNode> leftQueue = new LinkedList<TreeNode>();
        Queue<TreeNode> rightQueue = new LinkedList<TreeNode>();
        leftQueue.offer(root.left);
        rightQueue.offer(root.right);

        while (!leftQueue.isEmpty() && !rightQueue.isEmpty()) {
            TreeNode left = leftQueue.poll();
            TreeNode right = rightQueue.poll();
            if (left == null && right == null) {
                continue;
            }
            if (left == null || right == null) {
                return false;
            }
            if (left.val != right.val) {
                return false;
            } else {
                leftQueue.offer(left.left);
                leftQueue.offer(left.right);
                rightQueue.offer(right.right);
                rightQueue.offer(right.left);
            }
        }

        return true;
    }
}