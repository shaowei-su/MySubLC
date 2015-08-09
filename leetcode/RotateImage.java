package leetcode;

public class RotateImage {

    public void rotate(int[][] matrix) {
        //edge cases
    	if (matrix == null || matrix.length == 0) {
    		return;
    	}
    	
    	int n = matrix.length;
    	//each layer is the out-most circle
    	for (int layer = 0; layer < n / 2; layer++) {
    		for (int i = layer; i < n - layer - 1; i++) {
    			int temp =  matrix[layer][i];
    			matrix[layer][i] = matrix[n - i - 1][layer];
    			matrix[n - i - 1][layer] = matrix[n - layer - 1][n - i - 1];
    			matrix[n - layer - 1][n - i - 1] = matrix[i][n - layer - 1];
    			matrix[i][n - layer - 1] = temp;
    		}
    	}
    	
    	return;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RotateImage r = new RotateImage();
		int[][] matrix = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
		r.rotate(matrix);
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix.length; j++) {
				System.out.println(matrix[i][j]);
			}
		}
	}

}
