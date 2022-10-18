package boj.silver.graph;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class _1012_유기농배추 {
	static class Node {
		int r, c, t;

		public Node(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
		public Node(int r, int c, int t) {
			super();
			this.r = r;
			this.c = c;
			this.t =t;
		}

		@Override
		public String toString() {
			return "Node [r=" + r + ", c=" + c + "]";
		}

	}

	static Queue<Node> q;
	static int n, m, k, cnt;
	static int[][] map;
	static boolean[][] visited;
	static int[][] drc = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {
			m = sc.nextInt(); // 세로 (입력은 좌표기준이므로 행렬에 맞게 바꿨음)
			n = sc.nextInt(); // 가로
			k = sc.nextInt(); // 배추 심어진 위치 개수

			map = new int[m][n];
			visited = new boolean[m][n];
			for (int i = 0; i < k; i++) {
				map[sc.nextInt()][sc.nextInt()] = 1;
			}

			cnt = 0;
			q = new ArrayDeque<>();
			for (int i = 0; i < m; i++) {
				for (int j = 0; j < n; j++) {
					if (map[i][j] == 1 && !visited[i][j]) { // 1이고 방문하지 않았을 때 카운트
						bfs(i, j);
						cnt++;
					}
				}
			}
			System.out.println(cnt);
//			print(map);
		}
	}

	private static void bfs(int r, int c) {
		q.add(new Node(r, c));

		while (!q.isEmpty()) {
			Node curr = q.poll();
			visited[curr.r][curr.c] = true;

			if (curr.r == m - 1 && curr.c == n - 1) {
				return;
			}

			for (int d = 0; d < 4; d++) {
				int nr = curr.r + drc[d][0];
				int nc = curr.c + drc[d][1];

				if (!is_in(nr, nc) || map[nr][nc] == 0 || visited[nr][nc]) {
					continue;
				}
				q.add(new Node(nr, nc));
				visited[nr][nc] = true;
			}
		}
	}

	private static boolean is_in(int r, int c) {
		return (r >= 0 && c >= 0 && r < m && c < n);
	}

	private static void print(int[][] arr) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	}
}
