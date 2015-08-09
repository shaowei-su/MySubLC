public class Solution2 {
	public boolean searchMatrix(int[][] matrix, int target) {
		if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
        	return false;
        }

        int m = matrix.length;
        int n = matrix[0].length;

        int start = 0;
        int end = m * n - 1;

        while (start <= end) {
        	int mid = start + (end - start);
        	int xMid = mid / n;
        	int yMid = mid % n;

        	if (matrix[xMid][yMid] == target) {
        		return true;
        	} else if (matrix[xMid][yMid] < target) {
        		start = mid + 1;
        	} else {
        		end = mid - 1;
        	}
        }

        return false;

	}
}