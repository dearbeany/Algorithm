package boj.gold.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * 며칠이 지나면 토마토가 모두 익는지 최소일수?
 * 상자에는 토마토가 들어있지 않을 수도 
 */
public class _7576_토마토 {
	static class Node {
		int r, c, t;

		Node(int r, int c, int t) {
			this.r = r;
			this.c = c;
			this.t = t;
		}

		@Override
		public String toString() {
			return "Node [r=" + r + ", c=" + c + ", t=" + t + "]";
		}

	}

	static int n, m, res; // 세로 가로
	static int[][] map;
	static int[][] drc = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
	static boolean[][] visited;
	static Queue<Node> q;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		m = Integer.parseInt(st.nextToken()); // 열의 개수
		n = Integer.parseInt(st.nextToken()); // 행의 개수

		q = new ArrayDeque<>();
		map = new int[n][m];
		visited = new boolean[n][m];

		// 1 = 익토, 0 = 안 익토, -1 = 빈칸
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 1) {
					q.add(new Node(i, j, 0));
					visited[i][j] = true;
				}
			}
		}
		res = 0;
		bfs();
//		print();

		// 모든 토마토가 이미 익어있으면 0 -> res도 0이다
		// 토마토가 익지 못하는 상황이면 -1 -> 0이 하나라도 있다
		res = isImpossible() ? -1 : res;
		System.out.println(res);
	}

	// 익지 못한 토마토 0 가 하나라도 있으면
	private static boolean isImpossible() {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (map[i][j] == 0) {
					return true;
				}
			}
		}
		return false;
	}

	private static void print() {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
	}

	private static void bfs() {
		while (!q.isEmpty()) {
			Node curr = q.poll();

			if (curr.t > res) {
				res = curr.t;
			}
			for (int i = 0; i < 4; i++) {
				int nr = curr.r + drc[i][0];
				int nc = curr.c + drc[i][1];

				// 범위 안에 있고, 0이면 익히기,
				if (is_in(nr, nc) && map[nr][nc] == 0) {
					map[nr][nc] = 1; // 익히고
					q.add(new Node(nr, nc, curr.t + 1));
					visited[nr][nc] = true;
				}
			}
		}

	}

	private static boolean is_in(int r, int c) {
		// TODO Auto-generated method stub
		return r >= 0 && c >= 0 && r < n && c < m;
	}
}
