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
    	Stack<TreeNode> stack = new Stack<TreeNode>();

    	if (root == null) {
    		return res;
    	}

    	TreeNode prev = null;
        stack.push(root);
    	while (!stack.empty()) {
            TreeNode cur = stack.peek();
            
            // begining of loop or downwards!
            // no pop as long as cur node has left/right
            if (prev == null || prev.left == cur || prev.right == cur) {
                if (cur.left != null) {
                    stack.push(cur.left);
                } else if (cur.right != null) {
                    stack.push(cur.right);
                } else {
                    stack.pop();
                    res.add(cur.val);
                }
            } else if (cur.left == prev) {
                // left subtree is done
                if (cur.right != null) {
                    stack.push(cur.right);
                } else {
                    stack.pop();
                    res.add(cur.val);
                }
            } else if (cur.right == prev) {
                // right is done
                stack.pop();
                res.add(cur.val);
            }

            prev = cur;
    	}

        return res;
    }
}