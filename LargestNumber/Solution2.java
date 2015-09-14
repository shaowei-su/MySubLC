import java.util.*;
class stringComparator implements Comparator<String> {
    public int compare(String s1, String s2) {
        String left = s1 + s2;
        String right = s2 + s1;
        return -left.compareTo(right);
    }
}

public class Solution2 {
    public String largestNumber(int[] nums) {
        if (nums == null || nums.length == 0) {
        	return "";
        }

        String[] arr = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            arr[i] = String.valueOf(nums[i]);
        }

        Arrays.sort(arr, new stringComparator());

        StringBuilder sb = new StringBuilder();
        for (String s: arr) {
            sb.append(s);
        }

        while (sb.charAt(0) == '0' && sb.length() > 1) {
            sb.deleteCharAt(0);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
    	Solution2 sol = new Solution2();
    	int[] nums = {3, 30, 34, 5, 9};
    	System.out.println(sol.largestNumber(nums));
    }
}