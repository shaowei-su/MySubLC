public class Solution {

	public boolean dfs(HashMap<Integer, ArrayList<Integer>> map, int[] rightCourses, int crt) {
		if (rightCourses[crt] == -1) {
			return false;
		}
		if (rightCourses[crt] == 1) {
			return true;
		}
		rightCourses[crt] = -1;
		if (map.containsKey(crt)) {
			for (int i = 0; i < map.get(crt).size(); i++) {
				if(!dfs(map, rightCourses, map.get(crt).get(i))) {
					return false;
				}

			}
		}
		rightCourses[crt] = 1;

		return true;
	}

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if (prerequisites == null) {
        	return false;
        }
        if (prerequisites.length == 0) {
        	return true;
        }

        int[] rightCourses = new int[numCourses];
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<Integer, ArrayList<Integer>>();
        for (int i = 0; i < prerequisites.length; i++) {
        	if (map.containsKey(prerequisites[i][0])) {
        		map.get(prerequisites[i][0]).add(prerequisites[i][1]);
        	} else {
        		ArrayList<Integer> temp = new ArrayList<Integer>();
        		temp.add(prerequisites[i][1]);
        		map.put(prerequisites[i][0], temp);
        	}
        }

        for (int i = 0; i < numCourses; i++) {
        	if (!dfs(map, rightCourses, i)) {
        		return false;
        	}
        }

        return true;
    }
}