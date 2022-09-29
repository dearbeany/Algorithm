package swea.d4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class _1249_보급로 {
	static class Node implements Comparable<Node> {
		int v, w;

		Node(int v, int w) {
			this.v = v;
			this.w = w;
		}

		@Override
		public int compareTo(Node o) {
			return this.w - o.w;
		}
	}

	static int n;
	static int[][] adjArr;
	static boolean[][] visited;
	static int[][] drc = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		BufferedReader br = new BufferedReader(new InputStreamReader(input));
		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			n = Integer.parseInt(br.readLine());
			adjArr = new int[n][n];
			visited = new boolean[n][n];

			for (int i = 0; i < n; i++) {
				String str = br.readLine();
				for (int j = 0; j < n; j++) {
					adjArr[i][j] = str.charAt(j) - '0';
				}
			}

			// (0,0) 출발 ~ (n-1, n-1) 도착
			dijikstra(0, 0);
		}
	}

	private static void dijikstra(int r, int c) {
		PriorityQueue<Node> pq = new PriorityQueue<>();

		pq.add(new Node(0, 0));
		visited[r][c] = true;

		while (!pq.isEmpty()) {
			Node node = pq.poll();

			for (int i = 0; i < 4; i++) {

			}
		}

	}

	private static boolean is_in(int r, int c) {
		return (r >= 0 && c >= 0 && r < n && c < n);
	}

}
