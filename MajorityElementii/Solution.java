import java.util.*;

public class Solution {
    public List<Integer> majorityElement(int[] nums) {
    	List<Integer> res = new ArrayList<Integer>();
    	if (nums == null || nums.length == 0) {
    		return res;
    	}
        int ele1 = 0;
        int count1 = 0;
        int ele2 = 0;
        int count2 = 0;

        for (int i = 0; i < nums.length; i++) {
        	if (ele1 == nums[i]) {
        		count1++;
        	} else if (ele2 == nums[i]) {
        		count2++;

        	} else if (count1 == 0) {
        		ele1 = nums[i];
        		count1++;
        	} else if (count2 == 0) {
        		ele2 = nums[i];
        		count2++;
        	} else {
        		count1--;
        		count2--;
        	}
        }

        count1 = 0;
        count2 = 0;
        for (int i = 0; i < nums.length; i++) {
        	if (ele1 == nums[i]) {
        		count1++;
        	} else if (ele2 == nums[i]) {
        		count2++;
        	}
        }

        if (count1 > nums.length / 3) {
        	res.add(ele1);
        }
        if (count2 > nums.length / 3) {
        	res.add(ele2);
        }

        return res;
    }

    public static void main(String[] args) {
    	Solution sol = new Solution();
    	int[] nums = {1, 2, 3, 4};
    	List<Integer> res = sol.majorityElement(nums);
    	for (int i: res) {
    		System.out.println(i);
    	}
    }
}