/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void connect(TreeLinkNode root) {
        if (root == null) {
        	return;
        }

        LinkedList<TreeLinkNode> queue = new LinkedList<TreeLinkNode>();
        queue.offer(root);
        int numsLeft = 1;
        int crtLevelNums = 0;

        while (!queue.isEmpty()) {
        	TreeLinkNode crt = queue.poll();
        	numsLeft--;
        	if (numsLeft == 0) {
        		crt.next = null;
        	} else {
        		TreeLinkNode peeked = queue.peek();
        		crt.next = peeked;
        	}
        	if (crt.left != null) {
        		queue.offer(crt.left);
        		crtLevelNums++;
        	}
        	if (crt.right != null) {
        		queue.offer(crt.right);
        		crtLevelNums++;
        	}
        	if (numsLeft == 0) {
        		numsLeft = crtLevelNums;
        		crtLevelNums = 0;
        	}
        }

        return;
    }
}