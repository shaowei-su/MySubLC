public class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
    	//this is indeed simple TAT why I cannot figure this out
        if (nums1 == null || nums2 == null || nums1.length < m || nums2.length < n) {
        	return ;
        }
        int i = m - 1; 
        int j = n - 1;
        int pos = m + n - 1;
        while (i >= 0 && j >= 0) {
        	if (nums1[i] > nums2[j]) {
        		nums1[pos--] = nums1[i--];
        	} else {
        		nums1[pos--] = nums2[j--];
        	}
        }

        while (i >= 0) {
        	nums1[pos--] = nums1[i--];
        }

        while (j >= 0) {
        	nums1[pos--] = nums2[j--];
        }
        return;
    }

    public static void main(String[] args) {
    	Solution sol = new Solution();
    	int[] nums1 = {1, 3, 5, 0, 0, 0};
    	int[] nums2 = {2, 4, 6};
    	sol.merge(nums1, 3, nums2, 3);
    	for (int i: nums1) {
    		System.out.println(i);
    	}
    }
}