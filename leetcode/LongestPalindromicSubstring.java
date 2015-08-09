package leetcode;

public class LongestPalindromicSubstring {
	
    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0) return "";
        int length = s.length();
        int maxLen = 0;
        String result = "";
        boolean[][] record = new boolean[length][length];

        for (int i = length-1; i >= 0; i--) {
        	for (int j = i; j < length; j++) {
        		if (s.charAt(i) == s.charAt(j) && ((j - i < 2) || (record[i+1][j-1]))) {
        			record[i][j] = true;
        			if (maxLen < (j - i + 1)) {
        				maxLen = j - i + 1;
        				result = s.substring(i, j + 1);
        			}
        		}
        	}
        }
        
        
        return result;
        
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LongestPalindromicSubstring l = new LongestPalindromicSubstring();
		String t = "abb";
		String r = l.longestPalindrome(t);
		
		System.out.println(r);

	}

}
