public class Solution2 {

	public void swap(int[] nums, int left, int right) {
		int temp = nums[right];
		nums[right] = nums[left];
		nums[left] = temp;
	}

	public int helper(int[] nums, int k, int start, int end) {
		int left = start;
		int right = end;

		while (true) {
			while (left < right && nums[left] < nums[end]) {
				left++;
			}
			while (left < right && nums[right] >= nums[end]) {
				right--;
			}

			if (left == right) {
				break;
			}
			swap(nums, left, right);
		}

		swap(nums, left, end);

		if (left == k) {
			return nums[left];
		} else if (left > k) {
			return helper(nums, k, start, left - 1);
		} else {
			return helper(nums, k, left + 1, end);
		}
	}

    public int findKthLargest(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
        	return Integer.MIN_VALUE;
        }

        return helper(nums, nums.length - k, 0, nums.length - 1);
    }

    public static void main(String[] args) {
    	Solution2 sol = new Solution2();
    	int[] nums = {3, 2, 1, 5, 6, 4};
    	System.out.println(sol.findKthLargest(nums, 2));
    }
}