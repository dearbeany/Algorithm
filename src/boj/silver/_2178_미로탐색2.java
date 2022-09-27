package boj.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _2178_미로탐색2 {

	static class Node {
		int r, c, dist;

		Node(int r, int c, int dist) {
			this.r = r;
			this.c = c;
			this.dist = dist;
		}
	}

	static int N, M;
	static int[][] maze;
	static boolean[][] visited;
	static int[] dr = { 1, -1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		// N개의 줄 M개의 정수
		// 1 이동 가능, 0 이동 불가
		// (1,1) 출발 (N,M)도착까지 최소의 칸 수
		// (0,0)~(N-1,M-1)

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		maze = new int[N][M];
		visited = new boolean[N][M];

		Queue<Node> queue = new LinkedList<>();

		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < M; j++) {
				maze[i][j] = str.charAt(j) - '0';
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (i == 0 && j == 0) {
					queue.add(new Node(i, j, 1)); // 출발점
					visited[i][j] = true;
				}
			}
		}

		while (!queue.isEmpty()) {
			Node n = queue.poll(); // 큐에 있는 걸 꺼내서 인접한 거 탐색

			for (int i = 0; i < 4; i++) {
				int nr = n.r + dr[i];
				int nc = n.c + dc[i];
				int ndist = n.dist + 1;

				if (nr < 0 || nc < 0 || nr >= N || nc >= M || visited[nr][nc] || maze[nr][nc] == 0) {
					continue;
				}

				if (nr == N - 1 & nc == M - 1) { // 도착점이면 끝내야지
					System.out.println(ndist);
					return;
				}

				queue.add(new Node(nr, nc, ndist));
				visited[nr][nc] = true;
			}
		}
	}

}
