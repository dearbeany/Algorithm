package boj.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _7569_토마토_BFS {
	static class Node {
		int h, r, c;

		Node(int h, int r, int c) {
			this.h = h;
			this.r = r;
			this.c = c;
		}

	}

	static int M, N, H;

	public static void main(String[] args) throws IOException {
		// 인접한 곳의 상, 하, 좌, 우, 앞, 뒤 익는다
		// 며칠이면 모든 토마토가 익는지 최소 일수?
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		M = Integer.parseInt(st.nextToken()); // 가로칸
		N = Integer.parseInt(st.nextToken()); // 세로칸
		H = Integer.parseInt(st.nextToken()); // 쌓이는 상자 개수

		// 1 = 익음, 0 = 익지 않음, -1 = 토마토 없음
		// 모든 토마토 1이면 0 출력
		// 모두 익지 못하면 -1 출력

		int[][][] tomato = new int[H][N][M];
		int[][][] dayCnt = new int[H][N][M];
		// 위, 아래, 왼, 오, 앞, 뒤
//		int[][] dhrc = { { 1, 0, 0 }, { -1, 0, 0 }, { 0, 0, -1 }, { 0, 0, 1 }, { 0, -1, 0 }, { 0, 1, 0 } };

		int[] dh = { 1, -1, 0, 0, 0, 0 };
		int[] dr = { 0, 0, 0, 0, -1, 1 };
		int[] dc = { 0, 0, -1, 1, 0, 0 };

		for (int h = 0; h < H; h++) {
			for (int r = 0; r < N; r++) {
				st = new StringTokenizer(br.readLine());
				for (int c = 0; c < M; c++) {
					tomato[h][r][c] = Integer.parseInt(st.nextToken());
				}
			}
		}
		for (int h = 0; h < H; h++) {
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < M; c++) {
					// 만약 토마토가 익었으면 1, 6방을 탐색한다
					// 6방탐색해서 안 익었으면, 즉 지금 0일 때 익게 한다. 상태를 1로 바꾼다
					// 모두 1이면 탐색 멈춘다
					if (tomato[h][r][c] == 1) { // 토마토 익으면
						Queue<Node> queue = new LinkedList<>();
						queue.add(new Node(h, r, c)); // 큐에 넣어준다

						while (!queue.isEmpty()) {
							Node n = queue.poll(); // 꺼내서 육방탐색 할 거야

							for (int d = 0; d < 6; d++) {
								int nh = n.h + dh[d];
								int nr = n.r + dr[d];
								int nc = n.c + dc[d];

								if (!isChecked(nh, nr, nc) || tomato[nh][nr][nc] == -1 || tomato[nh][nr][nc] == 1) {
									continue;
								}

								queue.add(new Node(nh, nr, nc)); // 큐에 넣어주고
								tomato[nh][nr][nc] = 1; // 토마토 익었다
								dayCnt[nh][nr][nc] = dayCnt[n.h][n.r][n.c] + 1; // 전에 탐색했던 거에서 일수가 1 늘어
							}
						}
					}
				}
			}
		}
		int max = 0;
		loop: for (int h = 0; h < H; h++) {
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < M; c++) {
					max = Math.max(dayCnt[h][r][c], max); // 최대 일수
					if (dayCnt[h][r][c] == 0) {
						max = -1; // 하나라도 못 익으면 -1 출력
						break loop;
					}

				}
			}
		}
		max = (max == 1) ? 0 : max; // 이미 다익었으면 0
		System.out.println(max);
	}

	public static boolean isChecked(int nh, int nr, int nc) {
		if ((nh >= 0 || nr >= 0 || nc >= 0 || nh < H || nr < N || nc < M)) {
			return true;
		} else {
			return false;
		}
	}

}
