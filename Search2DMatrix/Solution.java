public class Solution {

	public int matrix12(int[][] matrix, int counter) {
		int row = counter / matrix[0].length;
		int col = counter % matrix[0].length;
		return matrix[row][col];
	}

	public boolean helper(int[][] matrix, int startIndex, int endIndex, int target) {
		if (startIndex > endIndex) return false;
		if (target < matrix12(matrix, startIndex)) return false;
		if (target > matrix12(matrix, endIndex)) return false;

		int mid = startIndex + (endIndex - startIndex) / 2;
		if (matrix12(matrix, mid) == target) {
			return true;
		} else if (matrix12(matrix, mid) < target) {
			startIndex = mid + 1;
			return helper(matrix, startIndex, endIndex, target);
		} else {
			endIndex = mid - 1;
			return helper(matrix,startIndex, endIndex, target);
		}
	}

    public boolean searchMatrix(int[][] matrix, int target) {
        //edge cases
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
        	return false;
        }

        return helper(matrix, 0, matrix.length * matrix[0].length - 1, target);
    }
}