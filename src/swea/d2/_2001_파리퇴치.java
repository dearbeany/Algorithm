package swea.d2;

import java.util.Scanner;

public class _2001_파리퇴치 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			int n = sc.nextInt(); // 파리 배열 크기
			int m = sc.nextInt(); // 파리채 크기

			int[][] map = new int[n][n];
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					map[i][j] = sc.nextInt();
				}
			}

			int max = -1;
			for (int i = 0; i < n - m + 1; i++) {
				for (int j = 0; j < n - m + 1; j++) {
					int sum = 0;
					for (int x = i; x < i + m; x++) {
						for (int y = j; y < j + m; y++) {
							sum += map[x][y];
						}
					}
					max = Math.max(max, sum);
				}
			}
			System.out.printf("#%d %d\n", tc, max);
		}
	}
}
