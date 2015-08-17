import java.util.*;

public class Solution2 {
    public boolean isScramble(String s1, String s2) {
        if (s1 == null || s2 == null || s1.length() == 0 || s2.length() == 0 || s1.length() != s2.length()) {
        	return false;
        }
        if (s1.equals(s2)) {
        	return true;
        }
        int len = s1.length();

        boolean[][][] res = new boolean[len][len][len + 1];
        for (int i = 0; i < len; i++) {
        	for (int j = 0; j < len; j++) {
        		res[i][j][1] = s1.charAt(i) == s2.charAt(j);
        	}
        }

        for (int sub = 2; sub <= len; sub++) {
        	for (int i = 0; i < len - sub + 1; i++) {
        		for (int j = 0; j < len - sub + 1; j++) {
        			for (int k = 1; k < sub; k++) {
        				res[i][j][sub] |= (res[i][j][k] && res[i + k][j + k][sub - k]
        								|| res[i][j + sub - k][k] && res[i + k][j][sub - k]);
        			}
        		}
        	}
        }

        return res[0][0][len];

    }

    public static void main(String[] args) {
    	Solution2 sol = new Solution2();
    	System.out.println("res = " + sol.isScramble("great", "rgeat"));
    }
}