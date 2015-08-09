package leetcode;

public class WildcardMatching {

    public boolean isMatch(String s, String p) {
        //edge cases
    	if (s == null || p == null) {
    		return false;
    	}
    	
    	int checkPoint = -1; // cp for s, record the position when meet * in p to stand for the matching state before *
    	int starPoint = -1; // where the star in p is 
    	int i = 0; // s index
    	int j = 0; // p index
    	
    	while (i < s.length()) {
    		if (j < p.length() && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '?')) {
    			i++;
    			j++;
    		} else if (j < p.length() && p.charAt(j) == '*') {
    			checkPoint = i;
    			starPoint = j;
    			j++;
    		} else if (starPoint != -1) {
    			i = ++checkPoint;
    			j = starPoint + 1;
    		} else {
    			return false;
    		}
    	}
    	
    	while (j < p.length() && p.charAt(j) == '*') {
    		j++;
    	}
    	
    	return (p.length() == j);
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WildcardMatching w = new WildcardMatching();
		boolean r = w.isMatch("aa", "a");
		System.out.println(r);
	}

}
