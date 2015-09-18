import java.util.*;

public class Solution {

	public boolean dfs(HashMap<Integer, ArrayList<Integer>> map, int[] rightCourses, int crt, ArrayList<Integer> res) {
		if (rightCourses[crt] == -1) {
			return false;
		}
		if (rightCourses[crt] == 1) {
			return true;
		}
		rightCourses[crt] = -1;
		if (map.containsKey(crt)) {
			for (int i = 0; i < map.get(crt).size(); i++) {
				if (!dfs(map, rightCourses, map.get(crt).get(i), res)) {
					return false;
				}

			}
		}
        res.add(crt);
		rightCourses[crt] = 1;
		return true;
	}

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        // if (prerequisites == null || prerequisites.length == 0) {
        //     return null;
        // }

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
        ArrayList<Integer> res = new ArrayList<Integer>();
        for (int i = 0; i < numCourses; i++) {
            if (dfs(map, rightCourses, i, res)) {

            }
        }
        if (res.size() == numCourses) {
            int[] arr = new int[res.size()];
            for (int i = 0; i < res.size(); i++) {
                arr[i] = res.get(i);
            }
            return arr;
        }

        return new int[0];
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[][] prerequisites = {{1, 0}, {2, 0}, {3, 1}, {3, 2}};
        int[] res = sol.findOrder(4, prerequisites);
        for (int i: res) {
            System.out.println(i);
        }
    }
}