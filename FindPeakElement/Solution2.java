public class Solution {
    public int findPeakElement(int[] nums) {
        if (nums == null || nums.length < 2) {
            return 0;
        }

        int left = 0;
        int right =  nums.length - 1;

        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (mid == 0 && nums[mid] > nums[mid + 1]) {
                return mid;
            } else if (nums[mid - 1] < nums[mid] && nums[mid] > nums[mid + 1]) {
                return mid;
            }

            if (nums[mid] < nums[mid + 1]) {
                left = mid;
                continue;
            } else {
                right = mid;
                continue;
            }
        }

        return nums[left] > nums[right] ? left : right;
    }
}