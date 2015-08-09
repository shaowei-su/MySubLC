package leetcode;

public class RegularExpressionMatching {
	
    public boolean isMatch(String s, String p) {
    	//p is null
    	if (p.length() == 0) {
    		return s.length() == 0;
    	}
    	//p contains one element
    	if (p.length() == 1) {
    		if (s.length() < 1) {
    			return false;
    		} else if (p.charAt(0) != s.charAt(0) && p.charAt(0) != '.') {
    			return false;
    		} else {
    			return isMatch(s.substring(1), p.substring(1));
    		}
    	}
    	//p contains more than two elements, need take care of '*'
    	if (p.charAt(1) != '*') {
    		if (s.length() < 1) {
    			return false;
    		} else if (p.charAt(0) != s.charAt(0) && p.charAt(0) != '.') {
    			return false;
    		} else {
    			return isMatch(s.substring(1), p.substring(1));
    		}
    	} else {
    		//possibly none
    		if (isMatch(s, p.substring(2))) {
    			return true;
    		}
    		//iterate entire s
    		int i = 0;
    		while(i < s.length() && (s.charAt(i) == p.charAt(0) || p.charAt(0) == '.')) {
    			if (isMatch(s.substring(i + 1), p.substring(2))) {
    				return true;
    			}
    			i++; //the increasing of index i in fact eliminate the duplicated front char of string s
    		} 
    	}
    	
    	return false;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RegularExpressionMatching r = new RegularExpressionMatching();
		boolean res = r.isMatch("a", ".*..a*");
		System.out.println(res);
	}

}
