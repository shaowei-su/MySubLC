import java.util.*;

public class Solution {
    public int longestConsecutive(int[] nums) {
        //edge cases
        if (nums == null || nums.length == 0) {
            return 0;
        }
        //insert into hashmap for quick search
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], 0); // 0 stands that this number has not been considered yet
        }
        int longest = 1;

        for (int i = 0; i < nums.length; i++) {
            if (map.get(nums[i]) == 1) {
                continue;        
            }
            int crtLongest = 1;
            int num = nums[i] + 1;
            while (map.containsKey(num)) {
                crtLongest++;
                map.put(num, 1);
                num++;
            }
            num = nums[i] - 1;
            while (map.containsKey(num)) {
                crtLongest++;
                map.put(num, 1);
                num--;
            }

            longest = Math.max(longest, crtLongest);
        }

        return longest;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] nums = {100, 4, 200, 1, 3, 2};
        System.out.println(sol.longestConsecutive(nums));
    }
}
