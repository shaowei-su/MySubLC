import java.util.*;
import java.lang.*;

public class Solution {

	public void grayHelper(List<Integer> res, int n, int pos, int[] arr) {
		int cur = 0;
		for (int i = 0; i < n; i++) {
			cur += arr[i] * Math.pow(2, i);
		}
		res.add(cur);

		
	}

    public List<Integer> grayCode(int n) {
    	List<Integer> res = new ArrayList<Integer>();
        if (n <= 0) {
        	return res;
        }

        int[] arr = new int[n];
        grayHelper(res, n, 0, arr);

        return res;
    }
}