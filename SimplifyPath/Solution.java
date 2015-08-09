import java.util.*;

public class Solution {
    public String simplifyPath(String path) {
        //edge cases
        if (path == null || path.length() == 0) {
        	return null;
        }

        LinkedList<String> stack = new LinkedList<String>();
        StringBuilder sb = new StringBuilder();

        int i = 0;
        while (i < path.length()) {
        	int index = i;
        	StringBuilder temp = new StringBuilder();
        	while (i < path.length() && path.charAt(i) != '/') {
        		temp.append(path.charAt(i));
        		i++;
        	}

        	if (i != index) {
        		String stringCombinated = temp.toString();
        		if (stringCombinated.equals("..")) {
        			if (! stack.isEmpty()) {
        				stack.pop();
        			}
        		} else if (! stringCombinated.equals(".")) {
        			stack.push(stringCombinated);
        		}

        	}

        	i++;
        }

        if (! stack.isEmpty()) {
	        String[] arr = stack.toArray(new String[stack.size()]);
	        for (int j = arr.length - 1; j >= 0; j--) {
	        	sb.append("/" + arr[j]);
	        }        	
        }

        if (sb.length() == 0) {
        	sb.append("/");
        }


        return sb.toString();
    }

    public static void main(String[] args) {
    	Solution s = new Solution();
    	String r = s.simplifyPath("/a/./b/../../c/");
    	System.out.println(r);
    }


}