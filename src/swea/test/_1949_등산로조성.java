package swea.test;

import java.util.Scanner;

public class _1949_등산로조성 {
	static int N, K, res;
	static int[][] map;
	static boolean[][] visited;
	static int[][] drc = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			N = sc.nextInt();
			K = sc.nextInt();

			map = new int[N][N];
			visited = new boolean[N][N];
			res = 0; // 최대 길이

			int maxPeak = 0; // 가장 높은 봉우리

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					map[i][j] = sc.nextInt();
					maxPeak = Math.max(maxPeak, map[i][j]);
				}
			}

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (map[i][j] == maxPeak) { // 시작지점
						visited[i][j] = true; // 방문했다
						dfs(i, j, 1, false);
						visited[i][j] = false;
					}
				}
			}
			System.out.printf("#%d %d\n", tc, res);
		}
	}

	private static void dfs(int r, int c, int len, boolean crush) {
		for (int d = 0; d < 4; d++) { // 사방탐색
			int nr = r + drc[d][0];
			int nc = c + drc[d][1];

			if (!is_in(nr, nc) || visited[nr][nc]) { // 범위 벗어나거나 이미 방문했으면 패스
				continue;
			}

			if (map[nr][nc] >= map[r][c]) { // 등산로 높이 나보다 이상이면
				if (crush == false) { // 아직 안 깎았으면
					for (int k = 1; k <= K; k++) { // 깎자
						if ((map[nr][nc] - k) < map[r][c]) {
							map[nr][nc] -= k; // k만큼 깎고
							dfs(nr, nc, len + 1, true);
							map[nr][nc] += k; // 다시 원래 높이로
						}
					}
				}
			} else { // 나보다 작을 땐
				visited[nr][nc] = true;
				dfs(nr, nc, len + 1, crush);
				visited[nr][nc] = false;
			}
		}
		res = Math.max(res, len);
	}

	private static boolean is_in(int r, int c) {
		return (r >= 0 && c >= 0 && r < N && c < N);
	}
}
