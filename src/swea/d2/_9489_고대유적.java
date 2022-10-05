package swea.d2;

import java.util.Scanner;

public class _9489_고대유적 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {
			int n = sc.nextInt();
			int m = sc.nextInt();

			int[][] arr = new int[n][m];

			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					arr[i][j] = sc.nextInt();
				}
			}

			int cnt, rmax = -1, cmax = -1;
			// 가로 탐색
			for (int i = 0; i < n; i++) {
				cnt = 0;
				for (int j = 0; j < m; j++) {
					cnt = (arr[i][j] == 1) ? cnt + 1 : 0;
					rmax = Math.max(rmax, cnt);
				}
			}
			// 세로 탐색
			for (int j = 0; j < m; j++) {
				cnt = 0;
				for (int i = 0; i < n; i++) {
					cnt = (arr[i][j] == 1) ? cnt + 1 : 0;
					cmax = Math.max(cmax, cnt);
				}
			}
			int res = Math.max(rmax, cmax);
			System.out.printf("#%d %d\n", tc, res);
		}
	}
}
