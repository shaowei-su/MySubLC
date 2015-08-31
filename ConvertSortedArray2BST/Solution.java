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

	public TreeNode bstHelper(int[] nums, int start, int end) {
		if (start == end) {
			return new TreeNode(nums[start]);
		}
		if (start > end) {
			return null;
		}
		int mid = start + (end - start) / 2;
		TreeNode cur = new TreeNode(nums[mid]);
		cur.left = bstHelper(nums, start, mid - 1);
		cur.right = bstHelper(nums, mid + 1, end);

		return cur;
	}

    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null || nums.length == 0) {
        	return null;
        }

        return bstHelper(nums, 0, nums.length - 1);
    }
}