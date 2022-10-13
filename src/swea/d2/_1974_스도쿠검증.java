package swea.d2;

import java.util.Scanner;

public class _1974_스도쿠검증 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {
			int[][] sudoku = new int[9][9];
			int res = 1;

			for (int i = 0; i < 9; i++) {
				for (int j = 0; j < 9; j++) {
					sudoku[i][j] = sc.nextInt();
				}
			}

			// 가로
			for (int i = 0; i < 9; i++) {
				int[] cnt = new int[10]; // 가로 한 줄 씩 1~9 모두 있는지 검사
				for (int j = 0; j < 9; j++) {
					cnt[sudoku[i][j]]++;
				}

				for (int k = 1; k <= 9; k++) {
					if (cnt[k] != 1) { // 1~9까지 개수가 1이 아니라면
						res = 0; // 스도쿠 실패
						break;
					}
				}
			}

			// 세로
			for (int i = 0; i < 9; i++) {
				int[] cnt = new int[10]; // 세로 한 줄씩 검사
				for (int j = 0; j < 9; j++) {
					cnt[sudoku[j][i]]++;
				}

				for (int k = 1; k <= 9; k++) {
					if (cnt[k] != 1) {
						res = 0;
						break;
					}
				}
			}

			// 격자
			for (int r = 0; r < 9; r += 3) {
				for (int c = 0; c < 9; c += 3) {
					int[] cnt = new int[10]; // 3x3크기 격자 하나씩 검사하자

					for (int i = r; i < r + 3; i++) {
						for (int j = c; j < c + 3; j++) {
							cnt[sudoku[i][j]]++;
						}
					}
					for (int k = 1; k <= 9; k++) {
						if (cnt[k] != 1) {
							res = 0;
							break;
						}
					}
				}
			}
			System.out.printf("#%d %d\n", tc, res);
		}
	}
}
