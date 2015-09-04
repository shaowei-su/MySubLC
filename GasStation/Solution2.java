public class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        //edge casa
        if (gas == null || cost == null || gas.length != cost.length) {
        	return -1; 
        }

        int N = gas.length;
        int total = 0;
        int sum = 0;
        int diff = 0;
        int res = -1;
        for (int i = 0; i < N; i++) {
            diff = gas[i] - cost[i];
            sum += diff;
            total += diff;

            if (sum < 0) {
                sum = 0;
                res = i;
            }
        }

        return total < 0 ? -1 : res + 1;
    }
}