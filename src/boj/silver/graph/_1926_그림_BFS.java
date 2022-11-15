package boj.silver.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * bfs를 이용해 1이 상하좌우로 연결된 그림의 개수와
 * 그 그림 중 가장 최대 넓이? 
 */
public class _1926_그림_BFS {
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
	static Queue<Node> q;
	static int[][] drc = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int[n][m];
		visited = new boolean[n][m];

		q = new ArrayDeque<>();

		int cnt = 0; // 그림의 개수

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		maxArea = Integer.MIN_VALUE;

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (map[i][j] == 1 && !visited[i][j]) {
					cnt++;
					bfs(i, j);
//					System.out.println(i + ", " + j + " 의 bfs 끝!  ");
				}
			}
		}
		System.out.println(cnt);
		maxArea = maxArea == Integer.MIN_VALUE ? 0 : maxArea; // 그림 하나도 없으면 0
		System.out.println(maxArea);

	}

	private static void bfs(int r, int c) {
		int area = 0;

		q.add(new Node(r, c));
		visited[r][c] = true;

		while (!q.isEmpty()) {
			Node curr = q.poll();

//			System.out.println(curr);
			area++;

			for (int i = 0; i < 4; i++) {
				int nr = curr.r + drc[i][0];
				int nc = curr.c + drc[i][1];

				// 범위 안에 있고 && 방문 안 했고 && 1이면
				if (is_in(nr, nc) && !visited[nr][nc] && map[nr][nc] == 1) {
					q.add(new Node(nr, nc));
					visited[nr][nc] = true;
				}
			}
			maxArea = Math.max(maxArea, area);
		}

	}

	private static boolean is_in(int r, int c) {
		return r >= 0 && c >= 0 && r < n && c < m;
	}
}
