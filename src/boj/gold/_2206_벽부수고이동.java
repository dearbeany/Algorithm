package boj.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 부수고 온 자리와 부수지 않고 온 자리가 다르다 visited배열 2개 있어야 함
public class _2206_벽부수고이동 {
	static class Node {
		int r, c, dist, wbreak;

		Node(int r, int c, int dist, int wbreak) {
			this.r = r;
			this.c = c;
			this.dist = dist;
			this.wbreak = wbreak;
		}

		@Override
		public String toString() {
			return "Node [r=" + r + ", c=" + c + ", dist=" + dist + "]";
		}
	}

	static int[] dr = { 1, -1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		// 0 = 이동O, 1 = 이동X
		// (0,0) 출발 ~ (N-1, M-1) 도착 최단 경로
		// 벽은 1개까지만 부수기 가능
		// 불가능하면 -1 출력

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken()); // N개의 줄
		int M = Integer.parseInt(st.nextToken()); // M개의 정수

		int[][] map = new int[N][M];
		boolean[][][] visited = new boolean[2][N][M]; // 방문했는지

		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = str.charAt(j) - '0';
			}
		}
		Queue<Node> queue = new LinkedList<>();
		queue.add(new Node(0, 0, 1, 0)); // 출발점
		visited[0][0][0] = true;

//		for (int i = 0; i < N; i++) {
//			for (int j = 0; j < M; j++) {
//				System.out.print(map[i][j]);
//			}
//			System.out.println();
//		}

		int nr, nc;
		int min = Integer.MAX_VALUE;

		while (!queue.isEmpty()) {
			Node n = queue.poll();
//			System.out.println(n);
			if (n.r == N - 1 && n.c == M - 1) {
				min = Math.min(min, n.dist);
			}

			for (int i = 0; i < 4; i++) {
				nr = n.r + dr[i];
				nc = n.c + dc[i];

				// 배열 범위 벗어나거나 방문한 적 있다면 패스
				if (nr < 0 || nc < 0 || nr >= N || nc >= M || visited[n.wbreak][nr][nc] || map[nr][nc] == 1) {
					continue;
				}
				visited[n.wbreak][nr][nc] = true;
				queue.offer(new Node(nr, nc, n.dist + 1, n.wbreak));
			}

			if (n.wbreak == 0) { // 벽 안 뚫었을 경우
				for (int i = 0; i < 4; i++) {
					nr = n.r + dr[i];
					nc = n.c + dc[i];

					if (nr < 0 || nc < 0 || nr >= N || nc >= M || visited[1][nr][nc] || map[nr][nc] == 0) {
						continue;
					}
					visited[1][nr][nc] = true;
					queue.offer(new Node(nr, nc, n.dist + 1, 1));

				}
			}

//				if (map[nr][nc] == 1) { // 벽 만났을 때
//					if (!n.wbreak) { // 이제껏 부순 적 없으면
//						n.wbreak = true; // 부수고 이동
//						queue.add(new Node(nr, nc, ndist, n.wbreak));
//						visited[nr][nc] = true;
//					} else {
//						continue;
//					}
//				} else { // 이동할 수 있으면 그냥 이동
//					queue.add(new Node(nr, nc, ndist, n.wbreak));
//					visited[nr][nc] = true;
//				}
		}
		min = min == Integer.MAX_VALUE ? -1 : min;

		System.out.println(min);
	}
}
