public class Solution {
    public int titleToNumber(String s) {
        if (s == null || s.length() == 0) {
        	return 0;
        }
        char[] arr = s.toCharArray();
        int res = 0;
        for (int i = arr.length - 1; i >= 0; i--) {
        	int temp = (int)Math.pow(26, arr.length - 1 - i) * (arr[i] - 'A' + 1);
        	res += temp;
        }

        return res;
    }

    public static void main(String[] args) {
    	Solution sol = new Solution();
    	System.out.println(sol.titleToNumber("A"));
    }
}