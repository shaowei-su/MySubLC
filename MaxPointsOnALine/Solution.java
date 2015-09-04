import java.util.*;


 class Point {
      int x;
      int y;
      Point() { x = 0; y = 0; }
      Point(int a, int b) { x = a; y = b; }
 }

public class Solution {
    public int maxPoints(Point[] points) {
        if (points == null || points.length == 0) {
        	return 0;
        }

        HashMap<Double, Integer> map = new HashMap<Double, Integer>();
        int res = 0;
        for (int i = 0; i < points.length; i++) {
			int dup = 1; // indicate current point, so at least one
            int vertical = 0; // didn't imagine this
        	for (int j = i + 1; j < points.length; j++) {
        		
        		if (points[j].x == points[i].x) {
        			if (points[j].y == points[i].y) {
        				dup++;
        			} else {
        				vertical++;
        			}
        		} else {
        			double k = (points[j].y == points[i].y) ? 0.0 
                    : (double)(points[j].y - points[i].y) 
                    / (points[j].x - points[i].x);
                    if (!map.containsKey(k)) {
                        map.put(k, 1);
                    } else {
                        int crt = map.get(k);
                        map.put(k, crt + 1);
                    }
        		}
        	}
	        for (Integer value: map.values()) {
	        	res = Math.max(res, value + dup);
	        }
            res = Math.max(res, vertical + dup);
	        map.clear();        	
        }

        return res;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        Point[] points = {new Point(0, 0)};
        System.out.println("res = " + sol.maxPoints(points));
    }
}