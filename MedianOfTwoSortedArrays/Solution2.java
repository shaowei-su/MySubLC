import java.util.*;

public class Solution2 {
	//find kth
	public double medianHelper(int[] nums1, int[] nums2, int s1, int s2, int k) {
		if (s1 >= nums1.length) {
			return nums2[s2 + k - 1];
		}
		if (s2 >= nums2.length) {
			return nums1[s1 + k - 1];
		}
		if (k == 1) {
			return Math.min(nums1[s1], nums2[s2]);
		}

		int nums1K = s1 + k / 2 - 1 < nums1.length
					? nums1[s1 + k / 2 - 1]
					: Integer.MAX_VALUE;
		int nums2K = s2 + k / 2 - 1 < nums2.length
					? nums2[s2 + k / 2 - 1]
					: Integer.MAX_VALUE;

		if (nums1K < nums2K) {
			return medianHelper(nums1, nums2, s1 + k / 2, s2, k - k / 2);
		} else {
			return medianHelper(nums1, nums2, s1, s2 + k / 2, k - k / 2);
		}

	}

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null) {
        	return 0;
        } 

        int len = nums1.length + nums2.length;

        if (len % 2 == 0) {
        	return (medianHelper(nums1, nums2, 0, 0, len / 2) + medianHelper(nums1, nums2, 0, 0, len / 2 + 1)) / 2.0;
        } else {
        	return medianHelper(nums1, nums2, 0, 0, len / 2 + 1);
        }

    }

    public static void main(String[] args) {
    	Solution2 sol = new Solution2();
    	int[] nums1 = {};
    	int[] nums2 = {1};
    	System.out.println(sol.findMedianSortedArrays(nums1, nums2));
    }

}