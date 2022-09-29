package swea.d4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class _1249_보급로2 {
	static class Node {
		int r, c, time;

		Node(int r, int c, int time) {
			this.r = r;
			this.c = c;
			this.time = time;
		}

		@Override
		public String toString() {
			return "Node [r=" + r + ", c=" + c + ", time=" + time + "]";
		}

	}

	static int n;
	static int[][] map;
	static boolean[][] visited;
	static int[][] drc = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		BufferedReader br = new BufferedReader(new InputStreamReader(input));
		int T = Integer.parseInt(br.readLine());

		n = Integer.parseInt(br.readLine());
		map = new int[n][n];
		visited = new boolean[n][n];

		for (int i = 0; i < n; i++) {
			String str = br.readLine();
			for (int j = 0; j < n; j++) {
				map[i][j] = str.charAt(j) - '0';
			}
		}

		Queue<Node> q = new LinkedList<>();
		q.add(new Node(0, 0, 0));
		visited[0][0] = true;

		// (0,0) 출발 ~ (n-1, n-1) 도착

//		int minTime = 0;
		int minTime = Integer.MAX_VALUE;

		while (!q.isEmpty()) {
			Node node = q.poll();
			System.out.println(node);

			if (minTime > node.time) {
				minTime = node.time;
			}

			if (node.r == n - 1 && node.c == n - 1) {
				System.out.println(minTime);
				return;
			}

			for (int d = 0; d < 4; d++) {
				int nr = node.r + drc[d][0];
				int nc = node.c + drc[d][1];

				if (!is_in(nr, nc) || visited[nr][nc]) {
					continue;
				}
				q.add(new Node(nr, nc, node.time + map[nr][nc]));
				visited[nr][nc] = true;
			}
//			minTime = Math.min(node.time, minTime);
		}
//		System.out.println(minTime);
	}

	private static boolean is_in(int r, int c) {
		return (r >= 0 && c >= 0 && r < n && c < n);
	}

}
