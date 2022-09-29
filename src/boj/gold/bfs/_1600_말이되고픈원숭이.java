package boj.gold.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _1600_말이되고픈원숭이 {
	static class Node {
		int r, c, dist, k;

		Node(int r, int c, int dist, int k) {
			this.r = r;
			this.c = c;
			this.dist = dist;
			this.k = k;
		}

		@Override
		public String toString() {
			return "Node [r=" + r + ", c=" + c + ", dist=" + dist + ", k=" + k + "]";
		}

	}

	static int[][] nite = { { -2, 1 }, { -1, 2 }, { 1, 2 }, { 2, 1 }, { 2, -1 }, { 1, -2 }, { -1, -2 }, { -2, -1 } };
	static int[][] drc = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int K = Integer.parseInt(br.readLine()); // 나이트 횟수
		st = new StringTokenizer(br.readLine());
		int W = Integer.parseInt(st.nextToken()); // 가로
		int H = Integer.parseInt(st.nextToken()); // 세로

		int[][] map = new int[H][W];
		boolean[][][] visited = new boolean[H][W][K + 1]; // 나이트를 쓰는 횟수

		for (int i = 0; i < H; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < W; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		// 원숭이는 최대 k횟수만큼 나이트 이동이 가능하다
		// 최소 횟수로 (h-1, w-1) 도착하는 법?
		// 0 = 평지, 1 = 장애물

		Queue<Node> q = new LinkedList<>();
		q.add(new Node(0, 0, 0, K));
		visited[0][0][0] = true;

		while (!q.isEmpty()) {
			Node n = q.poll();
//			System.out.println(n);

			if (n.r == H - 1 && n.c == W - 1) {
				System.out.println(n.dist);
				return;
			}

			// 상하좌우 인접한 곳을 방문
			for (int i = 0; i < 4; i++) {
				int nr = n.r + drc[i][0];
				int nc = n.c + drc[i][1];

				if (nr < 0 || nc < 0 || nr >= H | nc >= W || visited[nr][nc][n.k] || map[nr][nc] == 1) {
					continue;
				}
				q.add(new Node(nr, nc, n.dist + 1, n.k));
				visited[nr][nc][n.k] = true;
			}

			// 나이트로 k번 이동 가능
			if (n.k > 0) {
				for (int i = 0; i < 8; i++) {
					int nr = n.r + nite[i][0];
					int nc = n.c + nite[i][1];

					if (nr < 0 || nc < 0 || nr >= H | nc >= W || visited[nr][nc][n.k - 1] || map[nr][nc] == 1) {
						continue;
					}
					q.add(new Node(nr, nc, n.dist + 1, n.k - 1));
					visited[nr][nc][n.k - 1] = true;
				}
			}
		}
		System.out.println(-1);
	}
}
