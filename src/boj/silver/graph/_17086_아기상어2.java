package boj.silver.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class _17086_아기상어2 {
	static class Node {
		int r, c, d;

		public Node(int r, int c, int d) {
			this.r = r;
			this.c = c;
			this.d = d;
		}

		@Override
		public String toString() {
			return "Node [r=" + r + ", c=" + c + ", d=" + d + "]";
		}

	}

	static int n, m;
	static int[][] map;
	static boolean[][] visited;
	static int[][] drc = { { -1, 0 }, { -1, 1 }, { 0, 1 }, { 1, 1 }, { 1, 0 }, { 1, -1 }, { 0, -1 }, { -1, -1 } };
	static Queue<Node> q;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		map = new int[n][m];
		q = new ArrayDeque<>();

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 1) {
					q.add(new Node(i, j, 0));
				}
			}
		}
		bfs();

	}

	private static void bfs() {
		visited = new boolean[n][m];

		while (!q.isEmpty()) {
			Node curr = q.poll();
			System.out.println(curr);

			for (int i = 0; i < 8; i++) {
				int nr = curr.r + drc[i][0];
				int nc = curr.c + drc[i][1];

				if (!is_in(nr, nc) || map[nr][nc] == 0 || visited[nr][nc]) {
					continue;
				}
				q.add(new Node(nr, nc, curr.d + 1));
				visited[nr][nc] = true;
			}
		}
	}

	private static boolean is_in(int r, int c) {
		return r >= 0 && c >= 0 && r < n && c < m;
	}

	private static void print() {
		// TODO Auto-generated method stub
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
	}
}
