public class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if (prerequisites == null) {
        	return false;
        }
        if (prerequisites.length == 0) {
        	return true;
        }
        int len = prerequisites.length;
        int[] reqCourses = new int[numCourses];
        for (int i = 0; i < len; i++) {
        	reqCourses[prerequisites[i][0]]++;
        }

        LinkedList<Integer> queue = new LinkedList<Integer>();
        for (int i = 0; i < numCourses; i++) {
        	if (reqCourses[i] == 0) {
        		queue.offer(i);
        	}
        }
        int noPre = queue.size();
        while (!queue.isEmpty()) {
        	int top = queue.poll();
        	for (int i = 0; i < len; i++) {
        		if (prerequisites[i][1] == top) {
        			reqCourses[prerequisites[i][0]]--;
        			if (reqCourses[prerequisites[i][0]] == 0) {
        				queue.offer(prerequisites[i][0]);
        				noPre++;
        			}
        		}
        	}
        }

        return noPre == numCourses;
    }
}