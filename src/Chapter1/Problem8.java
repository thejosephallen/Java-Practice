package Chapter1;
/**
 * 1.8) Write an algorithm such that if an element in an MxN matrix is 0, its entire
 * row and column are set to 0.
 * @author joseph
 * 
 * My Solution iterates through the entire matrix and uses a boolean vector for both
 * the rows and the columns to track which ones have a 0. It then uses this info to 
 * check which rows and columns need to be zeroified and does so. 
 * 
 */
public class Problem8 {
	
	public static int[][] zeroify(int[][] mat){
		// boolean vectors to track which contain zeros
		boolean[] row = new boolean[mat.length];
		boolean[] col = new boolean[mat[0].length];
		//loop to find the zeros in the matrix and update the vectors above
		for (int i = 0; i < mat.length; i++) {
			for (int j = 0; j < mat[0].length; j++) {
				if (mat[i][j] == 0) {
					row[i] = true;
					col[j] = true;
				}
			}
		}
		//check which rows and columns should be zero and make these changes to the matrix
		for (int i = 0; i < col.length; i++) 
			if(col[i] == true) 
				for(int j = 0; j< row.length; j++) 
					mat[j][i] = 0;
		for (int i = 0; i < row.length; i++) 
			if(row[i] == true) 
				for(int j = 0; j < col.length; j++) 
					mat[i][j] = 0;
		return mat;
	}
	
	public static void main(String[] args) {
		int[][] matrix = {{ 1, 2, 3, 4, 5, 6},
						  { 7, 8, 0,10, 11,12},
						  {13,14,15,16,17,18},
						  {19,20,21,22,23, 0}};
		Problem7.printMatrix(matrix);
		matrix = zeroify(matrix);
		Problem7.printMatrix(matrix);
		
	}
}
