package im;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class _1964_스도쿠검증2_미통과 {
	static List<Integer> list = new ArrayList<>();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {
			int[][] sudoku = new int[9][9];

			for (int i = 0; i < 9; i++) {
				for (int j = 0; j < 9; j++) {
					sudoku[i][j] = sc.nextInt();
				}
			}

			int res = (isRowOk(sudoku) && isColOk(sudoku) && isGridOk(sudoku)) ? 1 : 0;
			System.out.printf("#%d %d\n", tc, res);
		}
	}

	private static void setList() {
		for (int i = 1; i <= 9; i++) {
			list.add(i);
		}
	}

	// 가로 한 줄에 1~9
	private static boolean isRowOk(int[][] sudoku) {
		for (int i = 0; i < 9; i++) {
			setList();
			for (int j = 0; j < 9; j++) {
				list.remove(Integer.valueOf(sudoku[i][j]));
			}
			if (list.size() != 0) {
				return false;
			}
		}
		return true;
	}

	// 세로 한 줄에 1~9
	private static boolean isColOk(int[][] sudoku) {
		for (int i = 0; i < 9; i++) {
			setList();
			for (int j = 0; j < 9; j++) {
				list.remove(Integer.valueOf(sudoku[j][i]));
			}
			if (list.size() != 0) {
				return false;
			}
		}
		return true;
	}

	// 3x3 격자에 1~9
	private static boolean isGridOk(int[][] sudoku) {
		for (int i = 0; i < 9; i += 3) {
			for (int j = 0; j < 9; j += 3) {
				setList();
				for (int r = i; r < i + 3; r++) {
					for (int c = j; c < j + 3; c++) {
						list.remove(Integer.valueOf(sudoku[r][c]));
					}
				}
				if (list.size() != 0) {
					return false;
				}
			}
		}
		return true;
	}
}
