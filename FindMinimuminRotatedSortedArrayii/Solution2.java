public class Solution {
    public int findMin(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }

        int left = 0;
        int right = nums.length - 1;

        while (left + 1 < right) {
            if (nums[right] > nums[left]) {
                return nums[left];
            }
            int mid = left + (right - left) / 2;
            if (nums[mid] > nums[left]) {
                left = mid;
                continue;
            } else if (nums[mid] < nums[right]) {
                right = mid;
                continue;
            } else {
                left++;
            }
        }

        return nums[left] < nums[right] ? nums[left] : nums[right];
    }

    public static void main(String[] args) {
    	Solution sol = new Solution();
    	int[] nums = {4, 5, 6, 7, 0, 1, 2};
    	System.out.println(sol.findMin(nums));
    }
}