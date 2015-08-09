package leetcode;

import java.util.*;
public class PermutationSequence2 {
	
    public String getPermutation(int n, int k) {
    	//edge cases
    	if (n < 0) {
    		return "";
    	}
    	//calculate the (n-1)!
    	int fac = 1;
    	for (int i = 2; i < n; i++) {
    		fac *= i;
    	}
    	//put all possible numbers into arraylist
    	ArrayList<Integer> list = new ArrayList<Integer>();
    	for (int i = 1; i <= n; i++) {
    		list.add(i);
    	}
    	//make k as subscript
    	k--;
    	//sb
    	StringBuilder sb = new StringBuilder();
    	//round stands for the number of round we are in
    	int round = n - 1; // this is used to update (n - 1)! cause round will decrease as n decrease
    	int index = 0;
    	while (round >= 0) {
    		index = k / fac;
    		k %= fac;
    		sb.append(list.get(index));
    		list.remove(index);
    		if (round > 0) {
    			fac /= round;
    		}
    		round--;
    	}
    	return sb.toString();
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PermutationSequence2 p = new PermutationSequence2();
		String r = p.getPermutation(9, 219601);
		System.out.println(r);
	}

}
