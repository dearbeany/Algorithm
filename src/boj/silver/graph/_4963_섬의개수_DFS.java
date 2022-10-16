package boj.silver.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _4963_섬의개수_DFS {

	static int w, h, cnt; // 너비, 높이, 섬의 개수
	static int[][] map;
	static boolean[][] visited; // 방문했는지
	static int[] dr = { 0, 1, 1, 1, 0, -1, -1, -1 };
	static int[] dc = { 1, 1, 0, -1, -1, -1, 0, 1 };

	public static void main(String[] args) throws IOException {
		// 1 = 땅, 0 = 바다
		// 가로, 세로, 대각선으로 연결되어있으면 섬
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		while (true) {
			st = new StringTokenizer(br.readLine());
			w = Integer.parseInt(st.nextToken()); // 너비
			h = Integer.parseInt(st.nextToken()); // 높이
			if (w * h == 0) { // 0 0 입력 시 종료
				break;
			}
			map = new int[h][w];
			visited = new boolean[h][w];
			cnt = 0;

			// map 세팅
			for (int i = 0; i < h; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < w; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			// map을 돌며 땅이면 섬의 개수를 카운트
			for (int i = 0; i < h; i++) {
				for (int j = 0; j < w; j++) {
					if (map[i][j] == 1 && !visited[i][j]) {
						dfs(i, j);
						cnt++;
					}
				}
			}
			System.out.println(cnt);
		} // end of while
	} // end of main

	public static void dfs(int r, int c) {
		visited[r][c] = true; // 방문체크

		for (int d = 0; d < 8; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];

			if (nr < 0 || nc < 0 || nr >= h || nc >= w || map[nr][nc] == 0) {
				continue;
			}
			if (map[nr][nc] == 1 && !visited[nr][nc]) { // 다음 탐색할 곳이 땅이고, 방문하지 않았다면
				dfs(nr, nc);
			}
		}
	}
}
