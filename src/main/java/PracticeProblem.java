public class PracticeProblem {

	public static void main(String args[]) {

	}

	public static int searchMazeMoves(String[][] grid) {
		int row = grid.length-1;
		int col = 0;
		int a = searchMazeMovesReal(grid, row, col);
		if (a == Integer.MAX_VALUE) {
			return -1;
		}
		return a;
	}

	public static int searchMazeMovesReal(String[][] grid, int row, int col) {
		if (row < 0 || col >= grid[0].length || row >= grid.length || col < 0) {
			return Integer.MAX_VALUE;
		}
		if (grid[row][col].equals("F")) {
			return 0;
		}
		if (grid[row][col].equals("*")) {
			return Integer.MAX_VALUE;
		}
		grid[row][col] = "*";
		int a = searchMazeMovesReal(grid, row-1, col);
		int b = searchMazeMovesReal(grid, row, col+1);
		int c = searchMazeMovesReal(grid, row, col-1);
		int d = searchMazeMovesReal(grid, row+1, col);
		grid[row][col] = "";
		if (Math.min(Math.min(a, b), Math.min(c, d)) == Integer.MAX_VALUE) {
			return Integer.MAX_VALUE;
		}
		return Math.min(Math.min(a, b), Math.min(c, d))+1;
	}

}
