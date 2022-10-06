package boj.gold.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 부수고 온 자리와 부수지 않고 온 자리가 다르다 visited배열 2개 있어야 함
public class _2206_벽부수고이동 {
	static class Node {
		int r, c, dist;
		boolean crush;

		Node(int r, int c, int dist, boolean crush) {
			this.r = r;
			this.c = c;
			this.dist = dist;
			this.crush = crush; // 벽을 부쉈는지 안 부쉈는지
		}
	}

	static int[] dr = { 1, -1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		// 0 = 이동가능 하다 , 1 = 벽
		// (0,0) 출발 ~ (N-1, M-1) 도착 최단 경로
		// 벽은 1개까지만 부수기 가능
		// 불가능하면 -1 출력

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken()); // N개의 줄
		int M = Integer.parseInt(st.nextToken()); // M개의 정수

		int[][] map = new int[N][M];
		boolean[][][] visited = new boolean[N][M][2];
		// visited[N][M][0] : 벽 부수기 불가
		// visited[N][M][1] : 벽 부수기 가능

		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = str.charAt(j) - '0';
			}
		}

		Queue<Node> queue = new LinkedList<>();
		queue.add(new Node(0, 0, 1, false)); // 출발점
		visited[0][0][0] = true; // 큐에 넣었으니 방문
		visited[0][0][1] = true;

		// visited[N][M][0] : 벽 안 부수고 탐색
		// visited[N][M][1] : 벽 부수고 탐색

		// (1) map[i][j] == 1 벽임
		// 한 번도 벽 부신 적 없으면 부수고 -> visited[][][1] 방문

		// (2) map[i][j] == 0 벽 아님
		// 부신 벽 없으면 -> visited[][][0] 방문
		// 한 번 부신 적 있으면 -> visited[][][1] 방문

		while (!queue.isEmpty()) {
			Node n = queue.poll();

			if (n.r == N - 1 && n.c == M - 1) {
				System.out.println(n.dist);
				return;
			}

			for (int i = 0; i < 4; i++) {
				int nr = n.r + dr[i];
				int nc = n.c + dc[i];
				int dist = n.dist + 1;

				if (nr < 0 || nc < 0 || nr >= N || nc >= M) {
					continue;
				}

				if (map[nr][nc] == 1) { // 벽의 경우
					if (!n.crush) { // 부수지 않았다면
						queue.add(new Node(nr, nc, dist, true)); // 벽 부숴
						visited[nr][nc][1] = true;
					}
					// visited[][][0] <- 얘는 어차피 벽 못 부수니깐 신경 안 써도 됨
				} else if (map[nr][nc] == 0) { // 벽 아닐 경우
					if (!visited[nr][nc][0] && !n.crush) {
						queue.add(new Node(nr, nc, dist, false));
						visited[nr][nc][0] = true;
					}

					if (!visited[nr][nc][1] && n.crush) {
						queue.add(new Node(nr, nc, dist, true));
						visited[nr][nc][1] = true;
					}
				}
			}
		}
		System.out.println(-1);
	}
}
