import java.util.*;

public class Solution {

	public boolean isPalindrome(String s) {
		int i = 0;
		int j = s.length() - 1;
		while (i < j) {
			if (s.charAt(i) != s.charAt(j)) {
				return false;
			}
			i++;
			j--;
		}
		return true;
	}

	public void partitionHelper(List<List<String>> res, List<String> temp, String s, int pos) {
		if (pos == s.length()) {
			res.add(new ArrayList<String>(temp));
			return;
		}
		for (int i = pos + 1; i <= s.length(); i++) {
			if (isPalindrome(s.substring(pos, i))) {
				temp.add(s.substring(pos, i));
				partitionHelper(res, temp, s, i);
				temp.remove(temp.size() - 1);
			}
		}

		return;
	}

    public List<List<String>> partition(String s) {
        if (s == null || s.length() == 0) {
        	return null;
        }

        List<List<String>> res = new ArrayList<List<String>>();
        List<String> temp = new ArrayList<String>();

        partitionHelper(res, temp, s, 0);

        return res;
    }

    public static void main(String[] args) {
    	Solution sol = new Solution();
    	List<List<String>> res = sol.partition("aab");
    	for (List<String> list: res) {
    		System.out.println(list);
    	}
    }
}