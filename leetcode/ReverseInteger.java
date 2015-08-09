package leetcode;

import java.lang.Math;
public class ReverseInteger {
	
    public int reverse(int x) {
    	int res = 0;
    	while (x != 0) {
    		if (res != 0 && Math.abs(Integer.MAX_VALUE / res) < 10) {
    			return 0;
    		}
    		res = res * 10 + x % 10;
    		x = x / 10;
    	}
    	return res;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ReverseInteger r = new ReverseInteger();
		int result = r.reverse(1534236469);
		System.out.println(result);
	}

}
