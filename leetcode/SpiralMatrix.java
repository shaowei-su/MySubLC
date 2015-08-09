package leetcode;

import java.util.*;
public class SpiralMatrix {

    public List<Integer> spiralOrder(int[][] matrix) {
        //edge cases
    	List<Integer> res = new ArrayList<Integer>();
    	if (matrix.length == 0 || matrix.length == 0 || matrix[0].length == 0) {
    		return res;
    	}
    	int row = matrix.length;
    	int col = matrix[0].length;

    	int xMin = 0;
    	int yMin = 0;
    	int xMax = col - 1;
    	int yMax = row - 1;
    	
    	int x = 0;
    	int y = 0;
    	res.add(matrix[0][0]);
    	
    	while (true) {
    		while (x < xMax) {
    			res.add(matrix[y][++x]);
    		}
    		if (++yMin > yMax) break;
    		while (y < yMax) {
    			res.add(matrix[++y][x]);
    		}
    		if (xMin > --xMax) break;
    		while (x > xMin) {
    			res.add(matrix[y][--x]);
    		}
    		if (yMin > --yMax) break;
    		while (y > yMin) {
    			res.add(matrix[--y][x]);
    		}
    		if (xMax < ++xMin) break;
    	}
    	
    	return res;

    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SpiralMatrix s = new SpiralMatrix();
		int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
		List<Integer> r = s.spiralOrder(matrix);
		for (int i: r) {
			System.out.println(i);
		}
	}

}
