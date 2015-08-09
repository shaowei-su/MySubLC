import java.util.*;

public class Solution3 {

    public ArrayList<Integer> inorderTraversal(TreeNode root) {
    	ArrayList<Integer> res = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();

        if (root == null) {
            return res;
        }

        TreeNode cur = root;
        while (cur != null || !stack.empty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.peek();
            stack.pop();
            res.add(cur.val);
            cur = cur.right;
        }

        return res;
    }
}