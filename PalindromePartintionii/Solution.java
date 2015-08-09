import java.util.*;

public class Solution {
        
        public boolean[][] isPalindrome(String s) {
            boolean[][] res = new boolean[s.length()][s.length()];
            for (int i = 0; i < s.length(); i++) {
                res[i][i] = true;
            }
            for (int i = 0; i < s.length() - 1; i++) {
                if (s.charAt(i) == s.charAt(i + 1)) {
                    res[i][i + 1] = true;
                }
            }
            for (int length = 2; length < s.length(); length++) {
                for (int start = 0; start + length < s.length(); start++) {
                    res[start][start + length] = res[start + 1][start + length - 1] && (s.charAt(start) == s.charAt(start + length));
                }
            }

            return res;
        }
        
        public int minCut(String s) {
            //edge cases
            if (s == null || s.length() == 0) {
                return -1;
            }

            //let cuts[i] stands for the minimum number of cuts to get palindromes
            int[] cuts = new int[s.length() + 1];
            boolean[][] getPalindrome = isPalindrome(s);
            for (int i = 0; i <= s.length(); i++) {
                cuts[i] = i - 1;
            }
            for (int i = 1; i <= s.length(); i++) {
                for (int j = 0; j < i; j++) {
                    if (getPalindrome[j][i - 1]) {
                        cuts[i] = Math.min(cuts[i], cuts[j] + 1);
                    }
                }
            }

            return cuts[s.length()];
        }

        public static void main(String[] args) {
            Solution sol = new Solution();
            String s = "aab";
            int r = sol.minCut(s);
            System.out.println(r);
        }
}
