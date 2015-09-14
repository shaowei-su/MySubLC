import java.util.*;

public class Solution {
    public String largestNumber(int[] nums) {
        if (nums == null || nums.length == 0) {
        	return "";
        }

        HashMap<Integer, ArrayList<Integer>> map = new HashMap<Integer, ArrayList<Integer>>();

        for (int i = 0; i < nums.length; i++) {
        	int f = nums[i];
        	while (f >= 10) {
        		f /= 10;
        	}
        	if (map.containsKey(f)) {
        		ArrayList<Integer> temp = map.get(f);
        		int num = nums[i];
        		while (num % 10 == 0) {
        			num /= 10;
        		}
        		temp.add(num);
        	} else {
        		ArrayList<Integer> temp = new ArrayList<Integer>();
        		int num = nums[i];
        		while (num % 10 == 0) {
        			num /= 10;
        		}
        		temp.add(num);
        		map.put(f, temp);
        	}
        }

        int[] arr = new int[map.keySet().size()];
        int ind = 0;
        for (int i: map.keySet()) {
        	arr[ind] = i;
        	ind++; 
        }

        Arrays.sort(arr);
        String res = "";
        for (int i = arr.length - 1; i >= 0; i--) {
        	ArrayList<Integer> temp = map.get(arr[i]);
        	Collections.sort(temp);
        	for (int val: temp) {
        		res += String.valueOf(val);
        	}
        }

        return res;
    }

    public static void main(String[] args) {
    	Solution sol = new Solution();
    	int[] nums = {3, 30, 34, 5, 9};
    	System.out.println(sol.largestNumber(nums));
    }
}