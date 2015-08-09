public class Solution3 {

    public int climbStairs(int n) {
        //edge cases
        int f1 = 1;
        int f2 = 2;
        if (n == 1) {
            return f1;
        }
        if (n == 2) {
            return f2;
        }

        for (int i = 3; i <= n; i++) {
            int f3 = f1 + f2;
            f1 = f2;
            f2 = f3;
        }

        return f2;
    }

    public static void main(String[] args) {
    	Solution3 s = new Solution3();
    	int r = s.climbStairs(5);
    	System.out.println(r);
    } 
}