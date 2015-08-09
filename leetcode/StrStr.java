package leetcode;

public class StrStr {

    public int strStr(String haystack, String needle) {
        //edge cases
    	if (haystack == null || needle == null) return -1;
    	if (needle.length() == 0) {
    		return 0;
    	}
    	int nLength = needle.length();
    	String temp = "";
    	for (int i = 0; i < haystack.length() - nLength  + 1; i++) {
    		temp = haystack.substring(i, i + nLength);
    		System.out.println("temp = " + temp);
    		if (temp.equals(needle)) {
    			return i;
    		}
    	}
    	return -1;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StrStr s = new StrStr();
		int r = s.strStr("mississippi", "issi");
		System.out.println(r);
	}

}
