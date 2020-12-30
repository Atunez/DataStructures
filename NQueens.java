import java.util.Scanner;

public class NQueens {
	static boolean[][] board;
	static int n;

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.print("Enter the number of queens: ");
		n = scanner.nextInt();

		board = new boolean[n][n];

		int solutions = checkRow(0);

		System.out.println("The number of valid arrangements is " + solutions);
		scanner.close();
	}

	public static int checkRow(int row) {
		if(row >= n){
			return 1;
		}

		int solutions = 0; 

		for (int col = 0; col < n; col++) {
			if(PogChamp(row, col)) {
				board[row][col] = true; 
				solutions += checkRow(row + 1);
				board[row][col] = false;
			}
		}

		return solutions;
	}

	public static boolean PogChamp(int prow, int pcol) {
		for (int r = prow; r >= 0; r--) {
			if(board[r][pcol]){
				return false;
			}
		}

		for (int r = prow, c = pcol; r >= 0 && c >= 0; r--, c--) {
			if(board[r][c]){
				return false;
			}
		}

		for (int r = prow, c = pcol; r >= 0 && c < n; r--, c++) {
			if(board[r][c]){
				return false;
			}
		}

		return true; 
	}
}
