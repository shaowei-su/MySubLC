/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
import java.util.*;

public class Solution {

	public void sumHelper(List<List<Integer>> res, List<Integer> temp, TreeNode root, int sum) {
		if (sum == 0 && root.left == null && root.right == null) {
			List<Integer> saveHelper = new ArrayList<Integer>();
			saveHelper.addAll(temp);
			res.add(saveHelper);
			return; 
		}
		if (root.left != null) {
			temp.add(root.left.val);
			sumHelper(res, temp, root.left, sum - root.left.val);
			temp.remove(temp.size() - 1);
		}
		if (root.right != null) {
			temp.add(root.right.val);
			sumHelper(res, temp, root.right, sum - root.right.val);
			temp.remove(temp.size() - 1);
		}

		return;
	}

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (root == null) {
        	return res;
        }
        List<Integer> temp = new ArrayList<Integer>();
		// if (sum == root.val && root.left == null && root.right == null) {
		// 	temp.add(root.val);
		// 	List<Integer> saveHelper = new ArrayList<Integer>();
		// 	saveHelper.addAll(temp);
		// 	res.add(saveHelper);
		// 	return res; 
		// }
		temp.add(root.val);
        sumHelper(res, temp, root, sum - root.val);
        return res;
    }

    public static void main(String[] args) {
    	Solution sol = new Solution();
    	TreeNode root = new TreeNode(1);
    	List<List<Integer>> res = sol.pathSum(root, 1);
    	for (List<Integer> l : res) {
    		System.out.println(l);
    	}
    }
}