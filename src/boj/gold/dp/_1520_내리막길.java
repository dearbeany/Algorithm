package boj.gold.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _1520_내리막길 {
	static int m, n;
	static int[][] map;
	static long[][] dp;
	static int[][] drc = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		m = Integer.parseInt(st.nextToken()); // 세로 크기
		n = Integer.parseInt(st.nextToken()); // 가로 크기

		map = new int[m][n];

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		dp = new long[m][n];
		for (int i = 0; i < m; i++) {
			Arrays.fill(dp[i], -1);
		}
		long ans = dfs(0, 0);
		System.out.println(ans);
	}

	private static long dfs(int r, int c) {
		if (r == m - 1 && c == n - 1) {
			return 1;
		}
		if (dp[r][c] != -1) {
			return dp[r][c];
		}

		long res = 0;
		for (int d = 0; d < 4; d++) {
			int nr = r + drc[d][0];
			int nc = c + drc[d][1];

			if (!is_in(nr, nc) || map[nr][nc] >= map[r][c]) {
				continue;
			}
			res += dfs(nr, nc);
		}
		dp[r][c] = res;
		return res;
	}

	private static boolean is_in(int r, int c) {
		return (r >= 0 && c >= 0 && r < m && c < n);
	}
}
