import java.util.*;


public class Solution {
    public int[] plusOne(int[] digits) {
        //edge cases
        if (digits == null || digits.length == 0) {
        	return null;
        }
        //reverse
        ArrayList<Integer> list = new ArrayList<Integer>(digits.length);
        for (int i = 0; i < digits.length; i++) {
        	list.add(digits[i]);
        }
        Collections.reverse(list);

        int pos = 0;
        while (pos < list.size()) {
        	if (list.get(pos) < 9) {
        		int res = list.get(pos) + 1;
        		list.remove(pos);
        		list.add(pos, res);
        		break;
        	} else {
        		list.remove(pos);
        		list.add(pos, 0);
        		pos++;
        	}
        }
        if (pos == list.size() && (list.size() > 1 || list.get(0) == 0)) {
        	list.add(1);
        }

        int[] result = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
        	result[i] = list.get(list.size() - 1 - i);
        }

        return result;
    }

    public static void main(String[] args) {
    	Solution s = new Solution();
    	int[] nums = {9};
    	int[] r = s.plusOne(nums);
    	for (int i: r) {
    		System.out.println(i);
    	}
    }
}