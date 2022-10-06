package boj.gold.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Tomato {
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
		// 위, 아래, 왼, 오, 앞, 뒤
//        int[][] dhrc = { { 1, 0, 0 }, { -1, 0, 0 }, { 0, 0, -1 }, { 0, 0, 1 }, { 0, -1, 0 }, { 0, 1, 0 } };

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
//        for (int h = 0; h < H; h++) {
//            for (int r = 0; r < N; r++) {
//                for (int c = 0; c < M; c++) {
//                    // 만약 토마토가 익었으면 1, 6방을 탐색한다
//                    // 6방탐색해서 안 익었으면, 즉 지금 0일 때 익게 한다. 상태를 1로 바꾼다
//                    // 모두 1이면 탐색 멈춘다
//                    if (tomato[h][r][c] == 1) { // 토마토 익으면

		Queue<Node> queue = new LinkedList<>();
		while (!tmt.isEmpty()) {
			Node t = tmt.poll();
			queue.offer(t);
			visited[t.h][t.r][t.c] = true;

		}

		// 위의 3중 for문의 경우 익은 토마토가 여러 곳일 때 동시에 익힐 수 없습니다. 하나의 토마토가 전체 배열의 익힐 수 있는 모든 토마토를
		// 익히고 나서야 다음 토마토에대해 bfs탐색하게 될 텐데
		// 그 경우 이미 visited처리되어 올바른 답을 찾을 수 없게 됩니다.
		// 아래 두 줄의 '큐에 add하는 부분'은 위의 whlie문에서 처리했습니다.

//                        queue.add(new Node(h, r, c)); // 큐에 넣어준다
//                        visited[h][r][c] = true; // 큐에 넣어줬으니깐 방문했어

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
//                    }
//                }
//            }
//        }
		int max = 0;
		search: for (int h = 0; h < H; h++) {
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < M; c++) {
					max = Math.max(dayCnt[h][r][c], max); // 최대 일수
					if (tomato[h][r][c] == 0 && !visited[h][r][c]) { // 토마토가 있어야 할 곳임에도 (tomato[h][r][c] == 0) 방문하지 않은
																		// 경우 (!visited[h][r][c])에 -1 처리해주었습니다.
//                    if (dayCnt[h][r][c] == 0) {                //첫 익은토마토의 시작지점은 여전히 0일것이므로 적절하지 않습니다.
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

//        for (int i = 0; i < H; i++) {
//            for (int j = 0; j < N; j++) {
//                for (int k = 0; k < M; k++) {
//                    System.out.print(box[i][j][k] + " ");
//                }
//                System.out.println();
//            }
//            System.out.println();
//        }
}