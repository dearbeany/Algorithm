package boj.gold.dp;

import java.util.Scanner;

public class _17069_파이프옮기기2_Topdown {
	static int N;
	static int[][] map;

//	static int ans = 0;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++)
				map[i][j] = sc.nextInt();
		}
		memo = new long[N][N][3];
		long ans = dfs(0, 1, 0); // 0,1에서 가로 보고 시작
		System.out.println(ans);
	}

	static long[][][] memo;

	static long dfs(int r, int c, int dir) {
		if (r == N - 1 && c == N - 1) {
			return 1;
		}
		if (memo[r][c][dir] != 0)
			return memo[r][c][dir];

		long result = 0;
		// 오른쪽으로 갈 수 있으면 오른쪽으로 간다.
		if (dir != 1 && c + 1 < N && map[r][c + 1] == 0)
			result += dfs(r, c + 1, 0);
		// 아래로 갈 수 있으면 아래로 간다.
		if (dir != 0 && r + 1 < N && map[r + 1][c] == 0)
			result += dfs(r + 1, c, 1);
		// 대각으로 갈 수 있으면 대각으로 간다.
		if (r + 1 < N && c + 1 < N && map[r + 1][c] + map[r][c + 1] + map[r + 1][c + 1] == 0)
			result += dfs(r + 1, c + 1, 2);
		memo[r][c][dir] = result;
		return result;
	}
}
