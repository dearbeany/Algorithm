package boj.gold.dp;

import java.util.Scanner;

/*
 * 파이프의 처음은 가로(0,0) (0,1)로 시작 
 * 마지막 (n-1, n-1) 올 때까지 방법의 수?
 * 이동 불가 시 0 출력 
 */
public class _17069_파이프옮기기2_Bottomup {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[][] map = new int[n + 1][n + 1];
		long[][][] dp = new long[n + 1][n + 1][3]; // 가로, 세로, 대각선 3방향으로 부터 오는 방법의 수를 저장

		for (int i = 1; i < n + 1; i++) {
			for (int j = 1; j < n + 1; j++) {
				map[i][j] = sc.nextInt();
			}
		}

		// 0 : 가로, 1 : 세로, 2: 대각선
		dp[1][2][0] = 1; // 맨처음 (1,2)의 가로방향 방법 1가지

		for (int r = 1; r <= n; r++) {
			for (int c = 3; c <= n; c++) {
				if (map[r][c] == 1) { // 벽이니까 패스
					continue;
				}
				// 가로
				// 파이프가 가로로 오므로, [열-1]에서 파이프는 가로 or 대각선 놓여있어야만 그로부터 가로로 이동 가능
				dp[r][c][0] = dp[r][c - 1][0] + dp[r][c - 1][2];

				// 세로
				// 파이프가 세로로 오므로, [행-1]에서 파이프는 세로 or 대각선으로부터 옴
				dp[r][c][1] = dp[r - 1][c][1] + dp[r - 1][c][2];

				// 대각선
				// 파이프가 대각선에서 오므로, [행-1][열-1]으로부터 가로, 세로, 대각선 모든 방향에서 대각선으로 이동 가능
				if (map[r - 1][c] == 1 || map[r][c - 1] == 1) { // 단, 가려고 하는 칸 상, 좌로 비어있어야 갈 수 있어
					continue; // 가려고 하는 칸 포함 세 칸이 비어있어야 하거든~
				}
				dp[r][c][2] = dp[r - 1][c - 1][0] + dp[r - 1][c - 1][1] + dp[r - 1][c - 1][2];
			}
		}
		long res = dp[n][n][0] + dp[n][n][1] + dp[n][n][2];
		System.out.println(res);

//		print(dp[0]);
//		print(dp[1]);
//		print(dp[2]);
	}

	private static void print(long[][] arr) {
		for (long a[] : arr) {
			for (long aa : a) {
				System.out.print(aa + " ");
			}
			System.out.println();
		}
	}
}
