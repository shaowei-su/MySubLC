/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution2 {

    public ArrayList<Integer> postorderTraversal(TreeNode root) {
    	ArrayList<Integer> res = new ArrayList<Integer>();
    	Stack<Integer> stack = new Stack<Integer>();

    	if (root == null) {
    		return res;
    	}

    	TreeNode cur = root;

    	while (cur != null || !stack.empty()) {
    		while (cur != null) {
    			stack.add(cur);
    			cur = cur.left;
    		}
    	}

    }
}