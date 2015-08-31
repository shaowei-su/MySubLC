/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 * 
 * 知道是dfs， 但是怎么写
 * DIVEDE AND CONQUER!
 * 怎么分成左右子树
 * 左子树包括所有小于的数，同理
 * 
 */
public class Solution {

	public List<TreeNode> treeHelper(int start, int end) {
		List<TreeNode> root = new ArrayList<TreeNode>();
		if (start > end) {
			root.add(null);
			return root;
		}

		for (int i = start; i <= end; i++) {
			List<TreeNode> left = treeHelper(start, i - 1);
			List<TreeNode> right = treeHelper(i + 1, end);
			for (int j = 0; j < left.size(); j++) {
				for (int k = 0; k < right.size(); k++) {
					TreeNode node = new TreeNode(i);
					node.left = left.get(j);
					node.right = right.get(k);
					root.add(node);
				}
			}
		}

		return root;
	}

    public List<TreeNode> generateTrees(int n) {
    	List<TreeNode> res = new ArrayList<TreeNode>();
        if (n < 0) {
        	return res;
        }

        return treeHelper(1, n);
    }
}