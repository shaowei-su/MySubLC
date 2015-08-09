import java.util.*;

public class Solution3 {
    public List<Integer> preorderTraversal(TreeNode root) {
    	ArrayList<Integer> res = new ArrayList<Integer>();

    	if (root == null) {
    		return res;
    	}

    	ArrayList<Integer> left = preorderTraversal(root.left);
    	ArrayList<Integer> right = preorderTraversal(root.right);

    	res.add(root.val);
    	res.addAll(left);
    	res.addAll(right);

    	return res;
    }
}