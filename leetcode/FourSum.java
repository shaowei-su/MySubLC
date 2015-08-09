package leetcode;

import java.util.*;
public class FourSum {

    public List<List<Integer>> fourSum(int[] nums, int target) {
    	ArrayList<List<Integer>> res = new ArrayList<List<Integer>>();
    	HashSet<List<Integer>> map = new HashSet<List<Integer>>();
    	//edge
    	if (nums.length < 4) {
    		return res;
    	}
    	//sort
    	Arrays.sort(nums);
    	
    	for (int i = 0; i < nums.length; i++) {
    		int a = nums[i];
    		for (int j = i + 1; j < nums.length; j++) {
    			int b = nums[j];
    			int sum = target - a - b;
    			int left = j + 1;
    			int right = nums.length - 1;
    			
    			while (left < right) {
    				if (nums[left] + nums[right] == sum) {
    					ArrayList<Integer> temp = new ArrayList<Integer>();
    					temp.add(a);
    					temp.add(b);
    					temp.add(nums[left]);
    					temp.add(nums[right]);
    					
    					if(!map.contains(temp)){
    						res.add(temp);
    						map.add(temp);
    					}
    					
    					
    					left++;
    					right--;
    				} else if (nums[left] + nums[right] < sum) {
    					left++;
    				} else {
    					right--;
    				}
    			}
    		}
    	}
    	
    	return res;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FourSum f = new FourSum();
		int[] nums = {-3, -2, -1, 0, 0, 1, 2, 3};
		List<List<Integer>> r = f.fourSum(nums, 0);
		for (List<Integer> arr: r) {
			System.out.println(arr);
		}

	}

}
