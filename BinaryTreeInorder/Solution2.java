import java.util.*;

public class Solution {

    public ArrayList<Integer> inorderTraversal(TreeNode root) {
    	ArrayList<Integer> res = new ArrayList<Integer>();

    	if (root == null) {
    		return res;
    	}

    	ArrayList<Integer> left = inorderTraversal(root.left);
    	ArrayList<Integer> right = inorderTraversal(root.right);

    	res.addAll(left);
    	res.add(root.val);
    	res.addAll(right);

    	return res;
    }
}