class Bucket {
	int low;
	int high;

	public Bucket() {
		low = -1;
		high = -1;
	}
}

public class Solution {
    public int maximumGap(int[] nums) {
        if (nums == null || nums.length < 2) {
        	return 0;
        }
        int max = nums[0];
        int min = nums[0];

        for (int i = 1; i < nums.length; i++) {
        	min = Math.min(min, nums[i]);
        	max = Math.max(max, nums[i]);
        }

        Bucket[] buckets = new Bucket[nums.length + 1];
        for (int i = 0; i <= nums.length; i++) {
        	buckets[i] = new Bucket();
        }

        double interval = (double)nums.length / (max - min); //notice the the maximun gap must be greater than interval

        for (int i = 0; i < nums.length; i++) {
        	int ind = (int)((nums[i] - min) * interval);
        	if (buckets[ind].low == -1) {
        		buckets[ind].low = nums[i];
        		buckets[ind].high = nums[i];
        	} else {
        		buckets[ind].low = Math.min(buckets[ind].low, nums[i]);
        		buckets[ind].high = Math.max(buckets[ind].high, nums[i]);
        	}
        }

        int prev = buckets[0].high;
        int res = 0;
        for (int i = 1; i <= nums.length; i++) {
        	if (buckets[i].low != -1) {
	        	res = Math.max(res, buckets[i].low - prev);
	        	prev = buckets[i].high;
        	}
        }

        return res;
    }

    public static void main(String[] args) {
    	Solution sol = new Solution();
    	int[] nums = {1, 1, 1, 1, 1, 5, 5, 5, 5, 5};
    	System.out.println(sol.maximumGap(nums));
    }
}