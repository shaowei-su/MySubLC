public class Solution {
    public boolean isPowerOfTwo(int n) {
        int res = (n - 1) & n;
        return res == 0;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.isPowerOfTwo(12));
    }
}
