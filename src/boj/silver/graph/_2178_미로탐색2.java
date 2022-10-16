package boj.silver.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _2178_미로탐색2 {
	static class Node {
		int r, c, d;

		Node(int r, int c, int d) {
			this.r = r;
			this.c = c;
			this.d = d;
		}
	}

	static int n, m;
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

		for (int i = 0; i < n; i++) {
			String str = br.readLine();
			for (int j = 0; j < m; j++) {
				map[i][j] = str.charAt(j) - '0';
			}
		}

		// (1,1) 출발해 (n,m)도착할 때 최단거리?
		// (0,0) ~ (n-1, m-1)
		bfs(0, 0, 1);

	}

	private static void bfs(int r, int c, int d) {
		q = new LinkedList<>();
		q.add(new Node(r, c, d));
		visited[r][c] = true;

		while (!q.isEmpty()) {
			Node curr = q.poll();

			if (curr.r == n - 1 && curr.c == m - 1) {
				System.out.println(curr.d);
				return;
			}

			for (int i = 0; i < 4; i++) {
				int nr = curr.r + drc[i][0];
				int nc = curr.c + drc[i][1];

				// 맵 안에 있고, 1이고, 방문 안 했을 때 이동
				if (is_in(nr, nc) && map[nr][nc] == 1 && !visited[nr][nc]) {
					q.add(new Node(nr, nc, curr.d + 1));
					visited[nr][nc] = true;
				}
			}
		}

	}

	private static boolean is_in(int r, int c) {
		return r >= 0 && c >= 0 && r < n && c < m;
	}
}
