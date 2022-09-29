package boj.gold.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _7576_토마토 {
	static class Node {
		int r, c, day;

		Node(int r, int c, int day) {
			this.r = r;
			this.c = c;
			this.day = day;
		}
	}

	static int[] dr = { 1, -1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int M = Integer.parseInt(st.nextToken()); // 세로 칸의 수
		int N = Integer.parseInt(st.nextToken()); // 가로 칸의 수

		int[][] tomato = new int[N][M];
		boolean[][] visited = new boolean[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				tomato[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		// 1=익은토마토, 0=익지 않은 토마토, -1=빈 칸
		// 토마토가 익기까지 최소날짜?

		Queue<Node> queue = new LinkedList<>();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (tomato[i][j] == 1) { // 익은 토마토들은 다 넣자
					queue.add(new Node(i, j, 0));
					visited[i][j] = true;
				}
			}
		}

		// 이미 토마토들이 다 익었으면 0
		// 토마토가 모두 익지는 못하면 -1

		int minDay = Integer.MAX_VALUE;

		while (!queue.isEmpty()) {
			Node n = queue.poll();

			for (int i = 0; i < 4; i++) {
				int nr = n.r + dr[i];
				int nc = n.c + dc[i];
				int nday = n.day + 1;

				if (nr < 0 || nc < 0 || nr >= N || nc >= M || visited[nr][nc] || tomato[nr][nc] == 1
						|| tomato[nr][nc] == -1) {
					continue;
				}

				minDay = Math.min(nday, minDay);

				queue.add(new Node(nr, nc, nday));
				visited[nr][nc] = true;
			}
		}
	}

}
