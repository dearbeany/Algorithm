package boj.silver.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
 * 1. BFS로 풀이 하기 
 */
public class _2667_단지번호붙이기_BFS {
	static class Node {
		int r, c;

		Node(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}

	// 상 하 좌 우 연결
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	static int N, danzi, apart; // map의 크기, 단지의 개수, 아파트의 개수
	static int[][] map;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine()); // 지도 크기

		map = new int[N][N];

		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < N; j++) {
				map[i][j] = str.charAt(j) - '0';
			}
		}
		List<Integer> alist = new ArrayList<>(); // 단지 당 아파트의 개수가 저장돼있음

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] == 1) { // 집이 있으면 검색 시작
					danzi++;
					apart++;
					Queue<Node> queue = new LinkedList<>();
					queue.add(new Node(i, j)); // 첫 시작 노드를 큐에 삽입
					map[i][j] = 0; // 큐에 넣었으니까 얘는 방문 OK

					while (!queue.isEmpty()) {
						Node n = queue.poll(); // 큐에서 빼내서
						for (int d = 0; d < 4; d++) { // 단지가 연결 되려면 상하좌우가 연결돼있으니까 큐에서 빼낸 n을 기준으로 인접한 사방탐색 시작
							int nr = n.r + dr[d];
							int nc = n.c + dc[d];

							if (nr < 0 || nc < 0 || nr >= N || nc >= N || map[nr][nc] == 0) { // 다음 탐색 위치들이 벗어나거나 이미
																								// 방문했다면 넘겨
								continue;
							}

							queue.add(new Node(nr, nc)); // 큐에 다음 탐색할 곳들(현재 값이 1인 애들)을 넣어줘
							map[nr][nc] = 0; // 다음 위치들을 큐에 넣었으니깐 얘도 방문 OK, 1->0 으로 상태 바꿔줬음
							apart++; // 아파트개수 +1
						}
					}
				} // end of if
				if (apart > 0) {
					alist.add(apart); // 단지 하나 다 검색 했으면 아파트 개수 넣어주고
				}
				apart = 0; // 다른 단지 넘어가야하니까 아파트 다시 0부터 셀 거야
			} // end of for j
		} // end of for i

		Collections.sort(alist); // 아파트는 오름차순 정렬
		System.out.println(danzi);
		for (Integer i : alist) {
//			System.out.println(i);
		}
	}
}
