package boj.silver.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class _2468_안전영역_DFS {

	static int N;
	static int[][] map;
	static int cnt, maxCnt;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	static boolean[][] visited;

	public static void main(String[] args) throws NumberFormatException, IOException {
		// 장마철 물에 잠기지 않는 안전영역의 최대 개수?
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		visited = new boolean[N][N];
		Set<Integer> set = new HashSet<>();

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				set.add(map[i][j]);
			}
		}

		Integer[] hlist = set.toArray(new Integer[0]); // 높이들을 담은 리스트

		// 맵을 탐색하면서 특정 높이 이하면 다 잠긴다
		// 안전영역은 상 하 좌 우로 인접해야 한다
		maxCnt = 1;

		for (int h = 0; h < hlist.length; h++) {
			cnt = 0;
			visited = new boolean[N][N];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (map[i][j] > hlist[h] && !visited[i][j]) {
						dfs(i, j, hlist[h]);
						cnt++;
					}
				}
			}
			maxCnt = Math.max(cnt, maxCnt);
		}
		System.out.println(maxCnt);
	}

	public static void dfs(int r, int c, int h) {
		visited[r][c] = true;

		for (int d = 0; d < 4; d++) { // dfs가 d의 범위 벗어나면 알아서 리턴된다
			int nr = r + dr[d];
			int nc = c + dc[d];

			if (nr < 0 || nc < 0 || nr >= N || nc >= N || map[nr][nc] <= h || visited[nr][nc]) {
				continue;
			}
			dfs(nr, nc, h);
		}
	}
}
