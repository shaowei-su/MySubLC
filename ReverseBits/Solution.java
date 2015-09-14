public class Solution {

	public int swapBits(int n, int a, int b) {
		int aint = (n >> a) & 1;
		int bint = (n >> b) & 1;

		if ((aint ^ bint) != 0) {
			n = n ^ (1 << a);
			n = n ^ (1 << b);
		}
		return n;
	}

    // you need treat n as an unsigned value
    public int reverseBits(int n) {
    	for (int i = 0; i < 16; i++) {
    		n = swapBits(n, i, 32 - i - 1);
    	}
    	return n;
    }

    public static void main(String[] args) {
    	Solution sol = new Solution();
    	System.out.println(sol.reverseBits(43261596));
    }
}