package Programmers;

public class 파괴되지_않은_건물 {
	static int row, col;
	public int solution(int[][] board, int[][] skill) {
		int answer = 0;

		row = board.length;
		col = board[0].length;

		int[][] mask = go(skill, board);

		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				board[i][j] += mask[i][j];
			}
		}

		for (int i = 0; i < row; i++) {
			for(int j = 0; j < col; j++) {
				if (board[i][j] > 0) answer++;
			}
		}

		return answer;
	}

	static int[][] go(int[][] skill, int[][] board) {
		int[][] mask = new int[row + 1][col + 1];
		for (int[] s : skill) {
			int r1 = s[1];
			int c1 = s[2];
			int r2 = s[3];
			int c2 = s[4];
			int degree = s[0] == 1 ? -s[5] : s[5];

			mask[r1][c1] += degree;
			mask[r1][c2 + 1] += -degree;
			mask[r2 + 1][c1] += -degree;
			mask[r2 + 1][c2 + 1] += degree;

		}

		for (int i = 0; i < row; i++) {
			for (int j = 1; j < col; j++) {
				mask[i][j] += mask[i][j - 1];
			}
		}

		for (int i = 0; i < col; i++) {
			for (int j = 1; j < row; j++) {
				mask[j][i] += mask[j - 1][i];
			}
		}

		return mask;
	}
}