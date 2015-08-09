public class Solution2 {
	public int[] plusOne(int[] digits) {
		if (digits == null || digits.length == 0) {
			return null;
		}
		int carry = 1;
		for (int i = digits.length - 1; i >= 0; i--) {
			int num = (digits[i] + carry) % 10;
			carry = (digits[i] + carry) / 10;
			digits[i] = num;
			if (carry == 0) {
				return digits;
			}
		}


		int[] result = new int[digits.length + 1];
		result[0] = 1;
		return result;
	}
    public static void main(String[] args) {
    	Solution2 s = new Solution2();
    	int[] nums = {9};
    	int[] r = s.plusOne(nums);
    	for (int i: r) {
    		System.out.println(i);
    	}
    }
}