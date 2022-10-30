package boj.silver.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * 아기상어끼리의 거리가 아님
 * 빈칸을 bfs해야함
 * 안전거리 : 빈칸에서 가장 가까운 아기상어와의 거리 
 * 이 안전거리의 최댓값? 
 * 즉, 가장 가까운 1까지의 거리가 가장 커야.. 
 */
public class _17086_아기상어2 {
	static class Node {
		int r, c, d;

		Node(int r, int c, int d) {
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
	static int[][] drc = { { -1, 0 }, { -1, 1 }, { 0, 1 }, { 1, 1 }, { 1, 0 }, { 1, -1 }, { 0, -1 }, { -1, -1 } };
	static Queue<Node> q;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int[n][m];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int dis = 0; // 가장 가까운 아기상어와 거리
		int res = 0; // 최대 안전거리
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (map[i][j] == 0) {
					dis = bfs(i, j);
					res = dis > res ? dis : res;
				}
			}
		}
		System.out.println(res);
	}

	private static int bfs(int r, int c) {
		boolean[][] visited = new boolean[n][m];
		q = new ArrayDeque<>();

		q.add(new Node(r, c, 0));
		visited[r][c] = true;

		while (!q.isEmpty()) {
			Node curr = q.poll();
			for (int i = 0; i < 8; i++) {
				int nr = curr.r + drc[i][0];
				int nc = curr.c + drc[i][1];

				if (!is_in(nr, nc) || visited[nr][nc]) {
					continue;
				}
				if (map[nr][nc] == 1) {
					return curr.d + 1;
				}
				q.add(new Node(nr, nc, curr.d + 1));
				visited[nr][nc] = true;
			}
		}
		return 0;
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
