package leetcode;

import java.util.*;
public class GenerateParentheses {

	
    public List<String> generateParenthesis(int n) {
        ArrayList<String> res = new ArrayList<String>();
        ArrayList<Integer> diff = new ArrayList<Integer>();
        //init
        res.add("");
        diff.add(0);
        //iterate all the characters on i
        for (int i = 0; i < 2 * n; i++) {
        	ArrayList<String> temp1 = new ArrayList<String>();
        	ArrayList<Integer> temp2 = new ArrayList<Integer>();
        	
        	for (int j = 0; j < res.size(); j++) {
        		String s = res.get(j);
        		int d = diff.get(j);
        		//all bits before the last one is possible for a (
        		if (i < 2 * n - 1) {
        			temp1.add(s + '(');
        			temp2.add(d + 1);
        		}
        		//all bits with diff > 0 is possible for a ) and also the last one must be a )
        		if (d > 0 && i < 2 * n - 1 || d == 1 && i == 2 * n - 1) {
        			temp1.add(s + ')');
        			temp2.add(d - 1);
        		}
        	}
        	res = temp1;
        	diff = temp2;
        }
        
        return res;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GenerateParentheses g = new GenerateParentheses();
		List<String> a = g.generateParenthesis(3);
		System.out.println(a);

	}

}
