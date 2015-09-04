public class Solution {
    public String reverseWords(String s) {
        if (s == null || s.length() == 0) {
        	return "";
        }
        StringBuilder sb = new StringBuilder();
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
        	if (s.charAt(i) == ' ') {
        		if (sb.length() == 0) {
        			continue;
        		} else {
	        		res.append(sb.reverse());
	        		if (i != s.length() - 1) {
	        			res.append(" ");
	        		}
	        		sb.delete(0, sb.length());        			
        		}
        	} else {
        		sb.append(s.charAt(i));
        	}
        }

        res.append(sb.reverse());

        return res.reverse().toString();
    }

    public static void main(String[] args) {
    	Solution sol = new Solution();
    	System.out.println(sol.reverseWords(" 1 "));
    }
}