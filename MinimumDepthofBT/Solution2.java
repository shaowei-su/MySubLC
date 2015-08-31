/**
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
    //without recursion
    //level order travesal 
    public int minDepth(TreeNode root) {
        if (root == null) {
        	return 0;
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        int level = 1;
        int numberLeft = 1;
        int curNumberOneLevel = 0;
        queue.offer(root);

        while (!queue.isEmpty()) {
            TreeNode crt = queue.poll();
            numberLeft--;
            if (crt.left == null && crt.right == null) {
                return level;
            }
            if (crt.left != null) {
                queue.offer(crt.left);
                curNumberOneLevel++;
            }
            if (crt.right != null) {
                queue.offer(crt.right);
                curNumberOneLevel++;
            }
            if (numberLeft == 0) {
                level++;
                numberLeft = curNumberOneLevel;
                curNumberOneLevel = 0;
            }
        }
        return 0;
    }
}