package leetcode;

public class LengthofLastWord {

    public int lengthOfLastWord(String s) {
        //edge cases
    	if (s == null || s.length() == 0) {
    		return 0;
    	}
    	//remove end breaks
    	for (int i = s.length() - 1; i > 0; i--) {
    		if (s.charAt(i) == ' ') {
    			s = s.substring(0, i);
    		} else {
    			break;
    		}
    	}
    	int finalBreak = -1;
    	
    	for (int i = 0; i < s.length(); i++) {
    		if (s.charAt(i) == ' ') {
    			finalBreak = i;
    		}
    	}
    	return s.length() - finalBreak - 1;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LengthofLastWord l = new LengthofLastWord();
		int r = l.lengthOfLastWord("   day");
		System.out.println(r);
	}

}
