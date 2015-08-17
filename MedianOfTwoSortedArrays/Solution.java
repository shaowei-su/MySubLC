import java.util.*;

public class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null) {
        	return 0;
        }

        double[] res = new double[nums1.length + nums2.length];
        int i = 0;
        for (; i < nums1.length; i++) {
        	res[i] = nums1[i];
        }

        for (int j = 0; j < nums2.length; j++) {
        	res[i] = nums2[j];
        	i++;
        }

        Arrays.sort(res);
        double mid = (res.length % 2 == 0) ? (res[res.length / 2] + res[res.length / 2 - 1]) / 2 : res[res.length / 2];
        return mid;
    }

    public static void main(String[] args) {
    	Solution sol = new Solution();
    	int[] nums1 = {1, 2, 3};
    	int[] nums2 = {4, 5, 6};
    	System.out.println(sol.findMedianSortedArrays(nums1, nums2));
    }
}