import java.util.*;

public class Solution {

	public boolean isValid(String s) {
		if (s.charAt(0) == '0' && s.length() > 1) {
			return false;
		}
		int num = Integer.parseInt(s);
		return num >= 0 && num <= 255;
	}

	public void restoreHelper(List<String> res, String s, int pos, StringBuilder sb, int times) {
		if (sb.length() == s.length() + 3 && times == 4) {
			String temp = sb.toString();
			res.add(temp);
			return;
		} else {
			for (int i = 1; i <= 3 && pos + i <= s.length(); i++) {
				if (isValid(s.substring(pos, pos + i))) {
					if (sb.length() != 0) {
						sb.append(".");
					}
					sb.append(s.substring(pos, pos + i));//i element
					restoreHelper(res, s, pos + i, sb, times + 1);
					sb.delete(sb.length() - i, sb.length());
					if (sb.length() != 0) {
						sb.delete(sb.length() - 1, sb.length());
					}
				}
			}			
		}
		return ;
	}

    public List<String> restoreIpAddresses(String s) {
    	List<String> res = new ArrayList<String>();
        if (s == null || s.length() == 0 || s.length() > 12) {
        	return res;
        }

        StringBuilder sb = new StringBuilder();
        restoreHelper(res, s, 0, sb, 0);

        return res;
    }

    public static void main(String[] args) {
    	Solution sol = new Solution();
    	List<String> res = sol.restoreIpAddresses("010010");
    	for (String s: res) {
    		System.out.println(s);
    	}
    }
}