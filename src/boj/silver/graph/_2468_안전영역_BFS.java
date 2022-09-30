package boj.silver.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

public class _2468_안전영역_BFS {

	static int N;
	static int[][] map;
	static int cnt, maxCnt;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	static boolean[][] visited;

	static class Node {
		int r, c;

		Node(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		// 장마철 물에 잠기지 않는 안전영역의 최대 개수?
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		visited = new boolean[N][N];
		Set<Integer> set = new HashSet<>();

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				set.add(map[i][j]);
			}
		}

		Integer[] hlist = set.toArray(new Integer[0]); // 높이들을 담은 리스트

		// 맵을 탐색하면서 특정 높이 이하면 다 잠긴다
		// 안전영역은 상 하 좌 우로 인접해야 한다
		maxCnt = 1;

		for (int h = 0; h < hlist.length; h++) {
			cnt = 0;
			visited = new boolean[N][N];

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (map[i][j] > hlist[h] && !visited[i][j]) { // 안전지대면 개수를 세자
						Queue<Node> queue = new LinkedList<>();
						queue.add(new Node(i, j)); // 시작하는 거 큐에 넣어
						visited[i][j] = true; // 큐에 넣었으니깐 얘는 방문했어

						while (!queue.isEmpty()) {
							Node n = queue.poll(); // 큐에서 꺼낸 걸로 사방탐색 해보자

							for (int d = 0; d < 4; d++) {
								int nr = n.r + dr[d];
								int nc = n.c + dc[d];

								// 다음 탐색위치가 배열범위 넘거나, 불안전지대거나, 방문했으면
								if (nr < 0 || nc < 0 || nr >= N || nc >= N || map[nr][nc] <= hlist[h]
										|| visited[nr][nc]) {
									continue;
								}
								queue.add(new Node(nr, nc));
								visited[nr][nc] = true; // 방문했어
							}
						}
						cnt++; // 인접 끝났을 때 카운트 하자
					}
				} // end of for j
			} // end of for i
			maxCnt = Math.max(cnt, maxCnt);
		} // end if for h
		System.out.println(maxCnt);

	}

}
