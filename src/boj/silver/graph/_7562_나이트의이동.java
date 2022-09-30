package boj.silver.graph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class _7562_나이트의이동 {
	static class Node {
		int r, c, m;

		Node(int r, int c, int m) {
			this.r = r;
			this.c = c;
			this.m = m; // move
		}
	}

	static int n, nowX, nowY, finX, finY, moveCnt;
	static int[][] chess;
	static boolean[][] visited;
	static int[][] drc = { { -2, -1 }, { -2, 1 }, { -1, 2 }, { 1, 2 }, { 2, 1 }, { 2, -1 }, { 1, -2 }, { -1, -2 } };
	static Queue<Node> q;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int tc = 0; tc < T; tc++) {
			n = sc.nextInt(); // 체스판 크기
			chess = new int[n][n];
			visited = new boolean[n][n];

			nowX = sc.nextInt();
			nowY = sc.nextInt();

			finX = sc.nextInt();
			finY = sc.nextInt();

			q = new LinkedList<>();
			bfs();
		}
	}

	private static void bfs() {
		int r = nowX;
		int c = nowY;

		q.add(new Node(r, c, 0));
		visited[r][c] = true;

		while (!q.isEmpty()) {
			Node curr = q.poll();

			if (curr.r == finX && curr.c == finY) {
				System.out.println(curr.m);
				return;
			}

			for (int d = 0; d < 8; d++) {
				int nr = curr.r + drc[d][0];
				int nc = curr.c + drc[d][1];

				if (!is_in(nr, nc) || visited[nr][nc]) {
					continue;
				}
				q.add(new Node(nr, nc, curr.m + 1));
				visited[nr][nc] = true;
			}
		}
	}

	private static boolean is_in(int r, int c) {
		return (r >= 0 && c >= 0 && r < n && c < n);
	}
}
