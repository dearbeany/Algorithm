package boj.gold.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * 고슴도치S 가 비버굴D 로 이동할 수 있는 가장 빠른 시간?
 * 빈 곳 = '.', 물 = *, 돌 = X, 비버 = D, 고슴도치 = S 
 * 매 분 마다 (1) 상하좌우 이동 가능 (2) 물도 상하좌우 확장 
 */
public class _3055_탈출 {
	static class Node {
		int r, c, t;

		Node(int r, int c) {
			this.r = r;
			this.c = c;
		}

		Node(int r, int c, int t) {
			this.r = r;
			this.c = c;
			this.t = t;
		}
	}

	static int n, m;
	static char[][] map;
	static boolean[][] visited, wVisited;
	static int[][] drc = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
	static Queue<Node> wq = new ArrayDeque<>(); // 물
	static Queue<Node> q = new ArrayDeque<>(); // 고슴도치

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		map = new char[n][m];

		for (int i = 0; i < n; i++) {
			String str = br.readLine();
			for (int j = 0; j < m; j++) {
				map[i][j] = str.charAt(j);

				// 물 웅덩이는 여러 개일 수도 있으니까 한꺼번에 다 넣어놓고 돌려야..
				if (map[i][j] == '*') {
					wq.add(new Node(i, j));
				}
				if (map[i][j] == 'S') {
					q.add(new Node(i, j, 0));
				}
			}
		}
		bfs();

	}

	private static void bfs() {
		wVisited = new boolean[n][m]; // 물
		visited = new boolean[n][m]; // 고슴이

		while (!q.isEmpty()) {
			int size = wq.size();

			for (int i = 0; i < size; i++) {
				Node w = wq.poll();

				for (int d = 0; d < 4; d++) {
					int nr = w.r + drc[d][0];
					int nc = w.c + drc[d][1];

					if (is_in(nr, nc) && map[nr][nc] == '.' && !wVisited[nr][nc]) {
						wq.add(new Node(nr, nc));
						map[nr][nc] = '*';
						wVisited[nr][nc] = true;
					}
				}
			}

			int qsize = q.size(); // 고슴도치

			for (int i = 0; i < qsize; i++) {
				Node curr = q.poll();

				// 굴 도착하면 멈춰
				if (map[curr.r][curr.c] == 'D') {
					System.out.println(curr.t);
					return;
				}

				for (int d = 0; d < 4; d++) {
					int nr = curr.r + drc[d][0];
					int nc = curr.c + drc[d][1];

					// 범위 벗어나고, 돌이고, 물이면 넘겨
					if (!is_in(nr, nc) || map[nr][nc] == 'X' || map[nr][nc] == '*' || visited[nr][nc]) {
						continue;
					}
					q.add(new Node(nr, nc, curr.t + 1));
					visited[nr][nc] = true;
				}
			}
		}
	}

	private static boolean is_in(int r, int c) {
		return r >= 0 && c >= 0 && r < n && c < m;
	}
}
