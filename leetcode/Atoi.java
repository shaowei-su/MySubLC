package leetcode;

import java.lang.Math;

public class Atoi {

    public int myAtoi(String str) {
    	//1. edge condition
        if (str == null || str.length() < 1) {
        	return 0;
        }
        //2. white space
        str = str.trim();
        //3. +/-
        boolean minus = false;
        int i = 0;
        if (str.charAt(i) == '-') {
        	minus = true;
        	i++;
        } else if (str.charAt(i) == '+') {
        	i++;
        }
        long res = 0;
        while(i < str.length() && str.charAt(i) >= '0' && str.charAt(i) <= '9') {
        	res = res * 10 + (str.charAt(i) - '0');
        	if (res > 0) {
	        	if (Integer.MAX_VALUE < res) {
	        		if (minus) {
	        			return Integer.MIN_VALUE;
	        		} else {
	        			return Integer.MAX_VALUE;
	        		}
	        	}        		
        	}

        	i++;
        }
        if (minus) {
        	res = -res;

        }

        return (int)res;
        
        
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Atoi a = new Atoi();
		int r = a.myAtoi("-2147483647");
		System.out.println(r);

	}

}
