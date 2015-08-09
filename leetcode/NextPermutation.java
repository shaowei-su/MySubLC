package leetcode;

public class NextPermutation {

	//reverse part of arrays
	public void reverse(int[] nums, int start, int end) {
		int temp = 0;
		while (start < end) {
			temp = nums[end];
			nums[end] = nums[start];
			nums[start] = temp;
			start++;
			end--;
		}
	}
    public void nextPermutation(int[] nums) {
        //edge cases
    	if (nums == null || nums.length < 2) return;
    	//find the one that violates the ascending condition, 
    	//in other words, if all the numbers are in ascend, then 
    	//it has no 'next permutation' at all and we need to reverse entire array
    	int vioIndex = -1;
    	for (int i = nums.length - 2; i >= 0; i--) {
    		if (nums[i] < nums[i + 1]) {
    			vioIndex = i;
    			break;
    		}
    	}
    	if (vioIndex < 0) {
    		reverse(nums, 0, nums.length - 1);
    		return;
    	}
    	int largerIndex = -1;
    	//find the number larger than voiIndex
    	for (int i = nums.length -1; i >= 0; i--) {
    		if (nums[i] > nums[vioIndex]) {
    			largerIndex = i;
    			break;
    		}
    	}
    	
    	int temp = 0;
    	temp = nums[largerIndex];
    	nums[largerIndex] = nums[vioIndex];
    	nums[vioIndex] = temp;
    	
    	reverse(nums, vioIndex + 1, nums.length - 1);
    	return;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		NextPermutation n = new NextPermutation();
		int[] nums = {2, 3, 1};
		n.nextPermutation(nums);
		for (int i: nums) {
			System.out.println(i);
		}

	}

}
