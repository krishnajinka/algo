package ds.matrix;

public class RotateMatrix {

	public static void main(String[] args) {
		int[][] M = new int[][] { { 1, 2, 0, 3 }, { 4, 0, 5, 6 },
				{ 7, 8, 0, 9 }, { 10, 11, 12, 13 } };
		print(M);
		rotate(M);
		print(M);
	}

	private static void print(int[][] m) {
		System.out.println("--------------------");
		for (int i = 0; i < m.length; i++) {
			for (int j = 0; j < m[0].length; j++) {
				System.out.print(" " + m[i][j]);
			}
			System.out.println();
		}
	}

	private static void rotate(int[][] M) {
		if (M.length == 0 || M.length != M[0].length)
			return;
		int n = M.length;
		// only repeat it for half
		for (int layer = 0; layer < n / 2; layer++) {
			int first = layer;
			int last = n - 1 - layer;
			for (int i = first; i < last; i++) {
				int offset = i - first;
				int top = M[first][i];// save top
				M[first][i] = M[last - offset][first];// left->top
				M[last-offset][first]=M[last][last-offset];//bottom -> left
				M[last][last-offset]=M[i][last];//right -> bottom
				M[i][last]=top; //saved -> right
			}
		}
	}

}
