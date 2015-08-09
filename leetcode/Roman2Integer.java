package leetcode;

import java.util.*;
public class Roman2Integer {
	/**
	 * @param args
	 * 1 I
	 * 5 V
	 * 10 X
	 * 50 L
	 * 100 C
	 * 500 D
	 * 1000 M
	 */
	
    public int romanToInt(String s) {
        HashMap<Character, Integer> map = new HashMap<Character, Integer>(); 
        map.put('I',  1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M',1000);
        char[] nums = s.toCharArray();
        int length = nums.length;
        int result = map.get(nums[length - 1]);
        for (int i = s.length() - 2; i >= 0; i--) {
        	if (map.get(nums[i]) < map.get(nums[i + 1])) {
        		result -= map.get(nums[i]);
        	} else {
        		result += map.get(nums[i]);
        	}
        }
        return result;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Roman2Integer r = new Roman2Integer();
		System.out.println(r.romanToInt("MMMCDXLIV"));

	}

}
