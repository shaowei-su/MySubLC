package leetcode;
/*
 * There are two sorted arrays nums1 and nums2 of size m and n respectively.
 *  Find the median of the two sorted arrays.
 *   The overall run time complexity should be O(log (m+n))
 */
public class MedianOfTwoSortedArrays {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int l1 = nums1.length, l2 = nums2.length;
        
        if ((l1 + l2) % 2 == 0) {
        	return (double)((findKth(nums1, nums2, (l1+l2)/2, 0, l1-1, 0, l2-1)+findKth(nums1, nums2, (l1+l2)/2 - 1, 0, l1-1, 0, l2-1)) / 2);
        } else {
        	return findKth(nums1, nums2, (l1+l2)/2, 0, l1-1, 0, l2-1);
        }
        
    }
    
    public int findKth(int[] a, int[] b, int k, int astart, int aend, int bstart, int bend) {
    	int aLen = aend - astart + 1;
    	int bLen = bend - bstart + 1;
    	
    	if (aLen == 0) {
    		return b[bstart + k];
    	}
    	if (bLen == 0) {
    		return a[astart + k];
    	}
    	if (k == 0) {
    		return (a[astart] > b[bstart]) ? b[bstart] : a[astart];
    	}
    	
    	int aKth = k * aLen / (aLen + bLen);
    	int bKth = k - aKth - 1;
    	
    	aKth = astart + aKth;
    	bKth = bstart + bKth;
    	
    	if (a[aKth] > b[bKth]) {
    		k = k - (bKth - bstart + 1);
    		bstart = bKth + 1;
    		aend = aKth;
    	} else if (a[aKth] < b[bKth]) {
    		k = k - (aKth - astart + 1);
    		astart = aKth + 1;
    		bend = bKth;
    	} 
    	
    	return findKth(a, b, k, astart, aend, bstart, bend);
    	
    	    	
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MedianOfTwoSortedArrays m = new MedianOfTwoSortedArrays();
		int[] a1 = {2, 3, 4, 5};
		int[] a2 = {6, 9};
		double a3 = m.findMedianSortedArrays(a1, a2);
		
		System.out.printf("a3 = %f \n", a3);
	}

}
