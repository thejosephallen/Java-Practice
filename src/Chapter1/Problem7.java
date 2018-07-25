package Chapter1;
/**1.7) Given an image represented by an NxN matrix, where each pixel in the image
 * is 4 bytes, write a method to rotate the image by 90 degrees. Can you do this in
 * place? 
 * 
 * Let each 4-byte pixel be represented with a 32-bit integer
 * 
 * My solution goes layer-by-layer through the matrix like it's an onion. Instead
 * of dividing each layer into 4 smaller arrays and swapping them, I iterate through
 * the values in these would-be arrays and swap them one at a time.
 * 
 */
public class Problem7{
	/**	Function that spirals clockwise around and into a matrix to unravel it 
	 * and turn it into a vector that maintains the layers of the matrix.
	 * Didn't end up using this part but keeping it because I think it is cool.
	 * 
	 * @param mat: an NxN matrix
	 * @param n: dimension N
	 * @return: the spiralVector
	 */
	/*public static void unravel(int[][] mat, int n) {
		int size = n*n;
		int[] spiralVector = new int[size];
		int index = 0;
		int low = 0;
		int high = n;
		int row = 0;
		int col = 0;
		while (index < size) {
			while (col < high) spiralVector[index++] = mat[row][col++];
			col--;
			while(row < high - 1) spiralVector[index++] = mat[++row][col];
			while(col > low) spiralVector[index++] = mat[row][--col];
			while(row > low + 1) spiralVector[index++] = mat[--row][col];
			col++;
			high--;
			low++;
		}
		for (int elem : spiralVector) System.out.printf("%d ", elem);
	}*/
	
	public static void printMatrix(int[][] mat) {
		System.out.println();
		for (int i = 0; i < mat.length; i++) {
			for (int j = 0; j < mat[0].length; j++) {
				System.out.printf("%4d ", mat[i][j]); 
			}
			System.out.println();
		}
	}
	
	public static int[][] createTestMatrix(int n){
		int[][] matrix = new int[n][n];
		int counter = 1;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				matrix[i][j] = counter++; 
			}
		}
		return matrix;
	}
	
	/**
	 * This is the function that rotates a given NxN matrix.
	 * @param mat - an NxN matrix
	 * @param n	- Dimension of given matrix
	 * @return	- the rotated matrix
	 */
	public static int[][] rotate90(int[][] mat, int n){
		int numLayers = (int)Math.ceil(n / 2.0);
		if (numLayers == 0) return null;
		int high, low;
		for (int i = 0; i < numLayers; i++) {
			low = i;
			high = n - 1 - i;
			if (low == high) break;
			for (int j = low; j < high; j++) {
				int temp = mat[low][j];
				mat[low][j] = mat[high - j][low];
				mat[high - j][low] = mat[high][high - j];
				mat[high][high - j] = mat[j][high];				
				mat[j][high] = temp;
				
			}
		}
		return mat;
	}
	
	public static void main(String[] args) {
		int matrixSize = 5;	//NxN
		int[][] matrix = createTestMatrix(matrixSize);
		printMatrix(matrix);
		/*System.out.println();
		unravel(matrix, matrixSize);
		System.out.println();*/
		
		matrix = rotate90(matrix, matrixSize);
		
		System.out.println();
		printMatrix(matrix);
		
	}
	
}
