package boj.silver.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _1926_그림_DFS {
	static class Node {
		int r, c;

		Node(int r, int c) {
			this.r = r;
			this.c = c;
		}

		@Override
		public String toString() {
			return "Node [r=" + r + ", c=" + c + "]";
		}

	}

	static int n, m, maxArea;
	static int[][] map;
	static boolean[][] visited;
	static int[][] drc = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int[n][m];
		visited = new boolean[n][m];

		int cnt = 0; // 그림의 개수

		maxArea = Integer.MIN_VALUE;

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 1 && !visited[i][j]) {
					cnt++;
					dfs(i, j);
				}
			}
		}
		System.out.println(cnt);

	}

	private static void dfs(int r, int c) {
		visited[r][c] = true;

		for (int i = 0; i < 4; i++) {
			int nr = r + drc[i][0];
			int nc = c + drc[i][1];

			// 범위 벗어나지 않고 && 방문 안 했고 && 1이면
			// 범위 안에 있고 && 방문 안 했고 && 1이면
			if (is_in(nr, nc) && !visited[nr][nc] && map[nr][nc] == 1) {
				dfs(nr, nc);
			}
		}

	}

	private static boolean is_in(int r, int c) {
		return r >= 0 && c >= 0 && r < n && c < m;
	}
}
