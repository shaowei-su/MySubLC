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

	public void sumHelper(TreeNode root, ArrayList<Integer> list, int crt) {
		int rootVal = root.val;
		crt = crt * 10 + rootVal;
		if (root.left == null && root.right == null) {
			list.add(crt);
			return;
		}
		if (root.left != null) {
			sumHelper(root.left, list, crt);
		}
		if (root.right != null) {
			sumHelper(root.right, list, crt);
		}
		
		return;
	}

    public int sumNumbers(TreeNode root) {
        if (root == null) {
        	return 0;
        }

        ArrayList<Integer> list = new ArrayList<Integer>();
        sumHelper(root, list, 0);

        int res = 0;
        for (int i: list) {
        	res += i;
        }

        return res;
    }
}