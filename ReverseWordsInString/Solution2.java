public class Solution {
    public String reverseWords(String s) {
        if (s == null || s.length() == 0) {
        	return "";
        }

        String[] arr = s.split(" ");
        StringBuilder sb = new StringBuilder();

        for (int i = arr.length - 1; i >= 0; i--) {
            if (!arr[i].equals("")) {
                sb.append(arr[i]).append(" ");
            }
        }

        //remember to remove the last " "
        return sb.length() == 0 ? "" : sb.substring(0, sb.length() - 1);
    }

    public static void main(String[] args) {
    	Solution sol = new Solution();
    	System.out.println(sol.reverseWords(" 1 "));
    }
}