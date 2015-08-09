package leetcode;

public class CountandSay {

    public String countAndSay(int n) {
        //edge cases
    	if (n < 0) {
    		return null;
    	}
    	
    	int i = 1;
    	String result = "1";
    	int count = 1;
    	int length = 1;
    	while (i < n) {
    		StringBuilder sb = new StringBuilder();
    		length = result.length();
    		for (int j = 1; j < length; j++) {
    			if (result.charAt(j) == result.charAt(j - 1)) {
    				count++;
    			} else {
    				sb.append(count);
    				sb.append(result.charAt(j - 1));
    				count = 1;
    			}
    		}
    		sb.append(count);
    		sb.append(result.charAt(length - 1));
    		result = sb.toString();
    		count = 1;
    		i++;
    	}
    	
    	return result;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CountandSay c = new CountandSay();
		String r = c.countAndSay(5);
		System.out.println(r);
	}

}
