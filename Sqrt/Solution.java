public class Solution {
    public int mySqrt(int x) {
 		//edge cases
 		if (x < 2) {
 			return x;
 		}

 		int lo = 1;
 		int hi = x;

 		while (lo <= hi) {
 			int mid = (lo + hi) / 2;
 			int divide = x / mid;

 			if (divide < mid) {
 				hi = mid - 1;
 			} else if (divide > mid) {
 				lo = mid + 1;
 			} else {
 				return mid;
 			}
 		}

 		return lo - 1;
    }

    public static void main(String[] args) {
    	Solution s = new Solution();
    	int r = s.mySqrt(3);
    	System.out.println(r);
    }
}