public class Solution {
    public String convertToTitle(int n) {
        if (n <= 0) {
        	return "";
        }
        StringBuilder res = new StringBuilder();
        while (n > 0) {
        	if (n % 26 == 0) {
        		res.append('Z');
        		n = n / 26 - 1;
        	} else {
	        	char crt = (char)('A' + n % 26 - 1);
	        	res.append(crt);
	        	n = n / 26;        		
        	}

        }

        return res.reverse().toString();
    }

    public static void main(String[] args) {
    	Solution sol = new Solution();
    	System.out.println(sol.convertToTitle(52));
    }
}