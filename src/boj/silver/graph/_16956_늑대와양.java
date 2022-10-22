package boj.silver.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * 늑대W가 양S에게 갈 수 없도록 울타리D를 설치하는데,
 * 갈 수 없게 할 수 있으면 1
 * 울타리 아무리 설치해도 양을 만나면 0
 * 
 */
public class _16956_늑대와양 {
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

	static int n, m, ans; // 목장 크기
	static char[][] map;
	static boolean[][] visited;
	static int[][] drc = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
	static Queue<Node> q, wq;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		map = new char[n][m];
		visited = new boolean[n][m];
		q = new ArrayDeque<>();
		wq = new ArrayDeque<>();

		for (int i = 0; i < n; i++) {
			String str = br.readLine();
			for (int j = 0; j < m; j++) {
				map[i][j] = str.charAt(j);
				if (map[i][j] == 'W') {
					q.add(new Node(i, j));
					wq.add(new Node(i, j));

					visited[i][j] = true;
				}
			}
		}
		setFence();

		// 양 만나면 0, 못 만나면 1
		if (isMeetable()) {
			System.out.println(0);
		} else {
			System.out.println(1);
			print();
		}
	}

	private static boolean isMeetable() {
		while (!wq.isEmpty()) {
			Node curr = wq.poll();

			for (int i = 0; i < 4; i++) {
				int nr = curr.r + drc[i][0];
				int nc = curr.c + drc[i][1];

				// W가 S만나면
				if (is_in(nr, nc) && map[nr][nc] == 'S') {
					return true;
				}
			}
		}
		return false;

	}

	private static void setFence() {
		while (!q.isEmpty()) {
			Node curr = q.poll();

			for (int i = 0; i < 4; i++) {
				int nr = curr.r + drc[i][0];
				int nc = curr.c + drc[i][1];

				if (is_in(nr, nc) && map[nr][nc] == 'S') {
					return;
				}

				// 범위 안 && 방문 안 했고 && .면 이동
				if (is_in(nr, nc) && !visited[nr][nc] && map[nr][nc] == '.') {
//					q.add(new Node(nr, nc));
//					visited[nr][nc] = true; 
					map[nr][nc] = 'D';
					// 어차피 W인접한 상하좌우로 울타리 설치할 거니까
					// 인접한 .들을 큐에 넣지 않아줘도 된다.. 어차피 못 움직이거든
				}
			}
		}
	}

	private static boolean is_in(int r, int c) {
		return r >= 0 && c >= 0 & r < n && c < m;
	}

	private static void print() {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				System.out.print(map[i][j]);
			}
			System.out.println();
		}

	}
}
