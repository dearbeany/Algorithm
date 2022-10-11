package im;

import java.util.Scanner;

public class _12712_파리퇴치3 {
	// 0~3은 +방향, 4~7은 x방향
	static int[][] drc = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 1 }, { 1, 1 }, { 1, -1 }, { -1, -1 } };
	static int n;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {
			n = sc.nextInt();
			int M = sc.nextInt();

			int[][] map = new int[n][n];
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					map[i][j] = sc.nextInt();
				}
			}

			int psum = 0, xsum = 0;

			// + 방향
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					int tmp = map[i][j];

					for (int d = 0; d < 4; d++) {
						for (int m = 1; m < M; m++) {
							int nr = i + m * drc[d][0];
							int nc = j + m * drc[d][1];

							if (!is_in(nr, nc)) {
								continue;
							}
							tmp += map[nr][nc];
						}
					}
					psum = Math.max(psum, tmp);
				}
			}

			// x 방향
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					int tmp = map[i][j];

					for (int d = 4; d < 8; d++) {
						for (int m = 1; m < M; m++) {
							int nr = i + m * drc[d][0];
							int nc = j + m * drc[d][1];

							if (!is_in(nr, nc)) {
								continue;
							}
							tmp += map[nr][nc];
						}
					}
					xsum = Math.max(xsum, tmp);
				}
			}

			int res = Math.max(psum, xsum);

			System.out.printf("#%d %d\n", tc, res);
		}
	}

	private static boolean is_in(int r, int c) {
		return (r >= 0 && c >= 0 && r < n && c < n);
	}
}
