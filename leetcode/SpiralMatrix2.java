package leetcode;

public class SpiralMatrix2 {

    public int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        if (n == 0) {
        	return res;
        }
        int counter = 1;
        int x = 0;
        int y = 0;
        res[x][y] = counter;
        int xMin = 0;
        int yMin = 0;
        int xMax = n - 1;
        int yMax = n - 1;
        while (true) {
        	while (x < xMax) {
        		res[y][++x] = ++counter;
        	}
        	if (++yMin > yMax) break;
        	while (y < yMax) {
        		res[++y][x] = ++counter;
        	}
        	if (--xMax < xMin) break;
        	while (x > xMin) {
        		res[y][--x] = ++counter;
        	}
        	if (--yMax < yMin) break;
        	while (y > yMin) {
        		res[--y][x] = ++counter;
        	}
        	if (++xMin > xMax) break;
        }
        return res;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SpiralMatrix2 s = new SpiralMatrix2();
		int[][] res = s.generateMatrix(3);
		for (int i = 0; i < 3; i++) {
			for (int j= 0; j < 3; j++) {
				System.out.println(res[i][j]);
			}
		}
	}

}
