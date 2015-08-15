public class Solution {
    public double myPow(double x, int n) {
		if (n == 0) return 1;
		double temp = x;
		n /= 2;
		while (n / 2 >= 1) {
			temp *= temp;
			n /= 2;
		}

		return  n == 1 ? temp * x : temp;
	}

	public static void main(String[] args) {
		Solution sol = new Solution();
		System.out.println(sol.myPow(2, 4));
	}

}