import java.util.*;

public class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        String result = "";
        if (denominator == 0) {
        	return result;
        }
        if (numerator == 0) {
        	return "0";
        }
        if (numerator < 0 ^ denominator < 0) {
        	result += "-";
        }

        long num = numerator;
        long den = denominator;
        num = Math.abs(num);
        den = Math.abs(den);

        long temp = num / den;
        result += String.valueOf(temp);
        long remainder = (num % den) * 10;
        if (remainder == 0) {
        	return result;
        }

        HashMap<Long, Integer> map = new HashMap<Long, Integer>();
        result += ".";
        while (remainder > 0) {
        	if (map.containsKey(remainder)) {
        		int pos = map.get(remainder);
        		String left = result.substring(0, pos - 1);
        		String right = result.substring(pos - 1, result.length());
        		result = left + "(" + right + ")";
        		return result;
        	}
        	temp = remainder / den;
        	result += String.valueOf(temp);
        	map.put(remainder, result.length());
        	remainder = (remainder % den) * 10;
        }

        return result;
    }

    public static void main(String[] args) {
    	Solution sol = new Solution();
    	System.out.println(sol.fractionToDecimal(0, -5));
    }
}