package leetcode;

public class MultiplyStrings {

    public String multiply(String num1, String num2) {
        //edge cases
    	if (num1 == null || num2 == null || num1.length() == 0 || num2.length() == 0) {
    		return "";
    	}
    	
    	String reNum1 = new StringBuilder(num1).reverse().toString();
    	String reNum2 = new StringBuilder(num2).reverse().toString();
    	int[] digits = new int[num1.length() + num2.length()];
    	
    	for (int i = 0; i < num1.length(); i++) {
    		for (int j = 0; j < num2.length(); j++) {
    			digits[i + j] += (int)(reNum1.charAt(i) - '0') * (int)(reNum2.charAt(j) - '0');
    		}
    	}
    	
    	StringBuilder sb = new StringBuilder();
    	for (int i = 0; i < digits.length; i++) {
    		int modulo = digits[i] % 10;
    		int carry = digits[i] / 10;
    		if (carry > 0 && i < digits.length - 1) {
    			digits[i + 1] += carry;
    		}
    		sb.insert(0, modulo);
    	}
    	//trim the '0's
    	while (sb.charAt(0) == '0' && sb.length() > 1) {
    		sb.deleteCharAt(0);
    	}
    	
    	return sb.toString();
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
