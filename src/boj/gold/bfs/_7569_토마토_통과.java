package boj.gold.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _7569_토마토_통과 {
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
		boolean[][][] visited = new boolean[H][N][M];

		int[] dh = { 1, -1, 0, 0, 0, 0 };
		int[] dr = { 0, 0, 0, 0, -1, 1 };
		int[] dc = { 0, 0, -1, 1, 0, 0 };

		Queue<Node> tmt = new ArrayDeque<>();

		for (int h = 0; h < H; h++) {
			for (int r = 0; r < N; r++) {
				st = new StringTokenizer(br.readLine());
				for (int c = 0; c < M; c++) {
					int tmp = Integer.parseInt(st.nextToken());
					tomato[h][r][c] = tmp;
					if (tmp == 1)
						tmt.offer(new Node(h, r, c)); // 시작하는 시점에 익은 토마토가 여러 곳에 있다면 각각의 위치 주변으로 동시에 익기 시작할것이기에 bfs초기의 큐에
														// 한번에 넣어주어야 합니다.
				}
			}
		}

		Queue<Node> queue = new LinkedList<>();
		while (!tmt.isEmpty()) {
			Node t = tmt.poll();
			queue.offer(t);
			visited[t.h][t.r][t.c] = true;
		}

		while (!queue.isEmpty()) {
			Node n = queue.poll(); // 꺼내서 육방탐색 할 거야

			for (int d = 0; d < 6; d++) {
				int nh = n.h + dh[d];
				int nr = n.r + dr[d];
				int nc = n.c + dc[d];

				if (!isChecked(nh, nr, nc) || tomato[nh][nr][nc] == -1 || tomato[nh][nr][nc] == 1
						|| visited[nh][nr][nc]) {
					continue;
				}

				queue.add(new Node(nh, nr, nc)); // 큐에 넣어주고
				tomato[nh][nr][nc] = 1; // 토마토 익었다
				dayCnt[nh][nr][nc] = dayCnt[n.h][n.r][n.c] + 1; // 전에 탐색했던 거에서 일수가 1 늘어
				visited[nh][nr][nc] = true; // 방문했어
			}
		}
		int max = 0;
		search: for (int h = 0; h < H; h++) {
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < M; c++) {
					max = Math.max(dayCnt[h][r][c], max); // 최대 일수
					if (tomato[h][r][c] == 0 && !visited[h][r][c]) { // 토마토가 있어야 할 곳임에도 (tomato[h][r][c] == 0) 방문하지 않은
																		// 경우 (!visited[h][r][c])에 -1 처리해주었습니다.
						max = -1; // 하나라도 못 익으면 -1 출력
						break search; // 0이 발견되었을 때 max가 -1로 갱신되어도 다시 반복문이 돌면서 max값이 변할 수 있으므로 break해줬습니다.
					}

				}
			}
		}
		max = (max == 1) ? 0 : max; // 이미 다익었으면 0
		System.out.println(max);
	}

	public static boolean isChecked(int nh, int nr, int nc) {
		if ((nh >= 0 && nr >= 0 && nc >= 0 && nh < H && nr < N && nc < M)) { // ||에서 &&으로 수정했습니다.
			return true;
		} else {
			return false;
		}
	}

}