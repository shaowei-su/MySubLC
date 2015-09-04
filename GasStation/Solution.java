public class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        //edge casa
        if (gas == null || cost == null || gas.length != cost.length) {
        	return -1; 
        }

        int N = gas.length;

        for (int i = 0; i < N; i++) {
        	int total = 0;
        	int j = i;
        	for (; j < N + i; j++) {
        		int pos = j % N;
        		total += gas[pos];
        		if (total < cost[pos]) {
        			break;
        		} else {
        			total -= cost[pos];
        		}
        	}
        	if (j == N + i) {
        		return i;
        	}
        }

        return -1;
    }
}