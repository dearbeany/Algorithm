package boj.silver.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _21736_헌내기는친구가필요해_BFS {
	static class Node {
		int r, c;

		Node(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}

	static int n, m, cnt;
	static char[][] campus;
	static int[][] drc = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
	static boolean[][] visited;
	static Queue<Node> q;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		campus = new char[n][m];
		visited = new boolean[n][m];

		for (int i = 0; i < n; i++) {
			String str = br.readLine();
			for (int j = 0; j < m; j++) {
				campus[i][j] = str.charAt(j);
			}
		}
		q = new LinkedList<>();

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (campus[i][j] == 'I') {
					// 상하좌우 사방탐색 시작
					bfs(i, j);
				}
			}
		}

		if (cnt == 0) {
			System.out.println("TT");
		} else {
			System.out.println(cnt);
		}
	}

	private static void bfs(int i, int j) {
		q.add(new Node(i, j));
		visited[i][j] = true;

		while (!q.isEmpty()) {
			Node curr = q.poll();

			for (int d = 0; d < 4; d++) {
				int nr = curr.r + drc[d][0];
				int nc = curr.c + drc[d][1];

				if (!is_in(nr, nc) || visited[nr][nc] || campus[nr][nc] == 'X') {
					continue;
				}
				if (campus[nr][nc] == 'P') {
					cnt++;
				}
				q.add(new Node(nr, nc));
				visited[nr][nc] = true;
			}
		}
	}

	private static boolean is_in(int r, int c) {
		return (r >= 0 && c >= 0 && r < n && c < m);
	}

	private static void bprint() {
		for (boolean[] bb : visited) {
			for (boolean b : bb) {
				int res = b == true ? 1 : 0;
				System.out.print(res);
			}
			System.out.println();
		}
	}
}
