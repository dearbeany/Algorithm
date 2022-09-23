package boj.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * 큐에서 넣을 때 바다처리
 * 큐에서 꺼낼 때 인접노드 처리
 * 재귀함수에서의 매개변수는 상태공간트리의 노드 상태 
 */
public class _4963_섬의개수_BFS {

	static int w, h, cnt;
	static int[][] map;
	static int[] dr = { 0, 1, 1, 1, 0, -1, -1, -1 };
	static int[] dc = { 1, 1, 0, -1, -1, -1, 0, 1 };

	static class Node {
		int r, c;

		Node(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}

	public static void main(String[] args) throws IOException {
		// 1 = 땅, 0 = 바다
		// 가로, 세로, 대각선으로 연결되어있으면 섬
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		// 입력 0 0 종료
		while (true) {
			st = new StringTokenizer(br.readLine());
			w = Integer.parseInt(st.nextToken()); // 너비
			h = Integer.parseInt(st.nextToken()); // 높이
			if (w == 0 && h == 0) {
				break;
			}
			map = new int[h][w];
			cnt = 0;

			// map 세팅
			for (int i = 0; i < h; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < w; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			// map을 돌며 땅이면 섬의 개수를 카운트
			for (int i = 0; i < h; i++) {
				for (int j = 0; j < w; j++) {
					if (map[i][j] == 1) { // 땅이면 검사 시작
						cnt++; // 우선 섬의 개수 하나 더해준다
						// 8방 탐색 했을 때 내가 1일 때 주위가 0이어야 섬
						// 주위를 0으로 만들어준다

						Queue<Node> queue = new LinkedList<>();
						queue.add(new Node(i, j)); // 시작 위치를 큐에 삽입한다
						map[i][j] = 0; // 방문체크. 땅을 바다로 바꾼다

						while (!queue.isEmpty()) { // 큐에 원소 남아있으면 계속 돈다
//							print();
							Node n = queue.poll(); // 큐에 있는 노드를 꺼내면서 8방 탐색

							for (int d = 0; d < 8; d++) {
								int nr = n.r + dr[d];
								int nc = n.c + dc[d];

								if (nr < 0 || nc < 0 || nr >= h || nc >= w) { // 범위를 넘어가면 패스
									continue;
								}
								if (map[nr][nc] == 0) { // 8방탐색 했을 때 바다면도 패스
									continue;
								}
								map[nr][nc] = 0; // 8방 주위를 모두 바다로 만들어 버림
								queue.add(new Node(nr, nc)); // 바다로 만든 걸 넣음
//								System.out.println("(" + nr + "," + nc + ")");
							}
						}
					}
				}
			}
			System.out.println(cnt);
		}
	}

	public static void print() {
		for (int i = 0; i < h; i++) {
			for (int j = 0; j < w; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println("----------");
	}

}
