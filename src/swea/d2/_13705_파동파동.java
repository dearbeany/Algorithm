package swea.d2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _13705_파동파동 {
	// 상부터 시작해 시계방향으로 8방
	static int[][] drc = { { -1, 0 }, { -1, 1 }, { 0, 1 }, { 1, 1 }, { 1, 0 }, { 1, -1 }, { 0, -1 }, { -1, -1 } };
	static int n;

	static class Node {
		int r, c, w;

		Node(int r, int c, int w) {
			this.r = r;
			this.c = c;
			this.w = w;

		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken()); // 배열의 크기
			int m = Integer.parseInt(st.nextToken()); // 파동 시작값
			int r = Integer.parseInt(st.nextToken()) - 1; // 행
			int c = Integer.parseInt(st.nextToken()) - 1; // 열
			int d = Integer.parseInt(st.nextToken()); // 증감

			int[][] map = new int[n][n];
			boolean[][] visited = new boolean[n][n];

			// 맵을 세팅 한다
			// (r,c)에 m부터 시작해 d씩 증감하면서 bfs로 채워보자

			Queue<Node> q = new LinkedList<>();
			map[r][c] = m;
			q.add(new Node(r, c, m));
			visited[r][c] = true;

			while (!q.isEmpty()) {
				Node n = q.poll();

				for (int i = 0; i < 8; i++) {
					int nr = n.r + drc[i][0];
					int nc = n.c + drc[i][1];
					int nw = n.w + d;

					if (n.w + d < 0) { // 음수는 안 돼
						nw = 0;
					}
					if (n.w + d > 255) { // 최대값은 255로 설정
						nw = 255;
					}

					if (is_in(nr, nc) && !visited[nr][nc] && map[nr][nc] == 0) {
						map[nr][nc] = nw;
						q.add(new Node(nr, nc, nw));
						visited[nr][nc] = true;
					}
				}
			}
//			print(map);

			System.out.printf("#%d ", tc);
			for (int i = 0; i < n; i++) {
				int rowSum = 0;
				for (int j = 0; j < n; j++) {
					rowSum += map[i][j];
				}
				System.out.print(rowSum + " ");
			}
			System.out.println();
		}
	}

	public static boolean is_in(int r, int c) {
		return (r >= 0 && c >= 0 && r < n && c < n);
	}

	public static void print(int[][] arr) {
		for (int[] aa : arr) {
			for (int a : aa) {
				System.out.print(a + " ");
			}
			System.out.println();
		}
	}
}
