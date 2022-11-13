package boj.silver.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _1926_그림_DFS {

	static int n, m, maxArea, area;
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

		// 맵 세팅
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		maxArea = Integer.MIN_VALUE;

		// 맵 세팅을 미리 다 해놓고 dfs 돌리는 거 주의할 것
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (map[i][j] == 1 && !visited[i][j]) {
					cnt++;
					dfs(i, j);
//					System.out.println(i + ", " + j + "의 dfs 끝 !");
					maxArea = Math.max(area, maxArea);
					area = 0;
				}
			}
		}
		System.out.println(cnt);
		maxArea = maxArea == Integer.MIN_VALUE ? 0 : maxArea; // 그림 하나도 없으면 0
		System.out.println(maxArea);

	}

	private static void dfs(int r, int c) {
		visited[r][c] = true;
		area++;
//		System.out.println(r + ", " + c + ", " + area);

		for (int i = 0; i < 4; i++) {
			int nr = r + drc[i][0];
			int nc = c + drc[i][1];

			// 범위 벗어나지 않고 && 방문 안 했고 && 1이면
			if (is_in(nr, nc) && !visited[nr][nc] && map[nr][nc] == 1) {
				dfs(nr, nc);
			}
		}
	}

	private static boolean is_in(int r, int c) {
		return r >= 0 && c >= 0 && r < n && c < m;
	}
}
