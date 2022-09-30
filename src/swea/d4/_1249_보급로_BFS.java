package swea.d4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class _1249_보급로_BFS {
	static class Node {
		int r, c;

		Node(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}

	static int n;
	static int[][] map, ans;
	static boolean[][] visited;
	static int[][] drc = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			n = Integer.parseInt(br.readLine());
			map = new int[n][n];
			ans = new int[n][n];
			visited = new boolean[n][n];

			for (int i = 0; i < n; i++) {
				String str = br.readLine();
				for (int j = 0; j < n; j++) {
					map[i][j] = str.charAt(j) - '0';
				}
			}

			Queue<Node> q = new LinkedList<>();
			q.add(new Node(0, 0));
			visited[0][0] = true;

			int minTime = Integer.MAX_VALUE;

			while (!q.isEmpty()) {
				Node node = q.poll();

				// (0,0) 출발 ~ (n-1, n-1) 도착
				if (node.r == n - 1 && node.c == n - 1) {
					minTime = Math.min(minTime, ans[node.r][node.c]);
				}

				if (minTime <= ans[node.r][node.c]) {
					continue;
				}

				for (int d = 0; d < 4; d++) {
					int nr = node.r + drc[d][0];
					int nc = node.c + drc[d][1];

					if (!is_in(nr, nc)) {
						continue;
					}
					if (!visited[nr][nc] || ans[nr][nc] > ans[node.r][node.c] + map[nr][nc]) {
						visited[nr][nc] = true;
						ans[nr][nc] = ans[node.r][node.c] + map[nr][nc];
						q.add(new Node(nr, nc));
					}
				}
			}
			System.out.printf("#%d %d\n", tc, minTime);
		}
	}

	private static boolean is_in(int r, int c) {
		return (r >= 0 && c >= 0 && r < n && c < n);
	}

}
