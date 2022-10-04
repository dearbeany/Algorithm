package boj.gold;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class _17472_다리만들기2 {
	static class Edge implements Comparable<Edge> {
		int st, ed, w;

		Edge(int st, int ed, int w) {
			this.st = st;
			this.ed = ed;
			this.w = w;
		}

		@Override
		public String toString() {
			return "Edge [st=" + st + ", ed=" + ed + ", w=" + w + "]";
		}

		@Override
		public int compareTo(Edge o) {
			return this.w - o.w;
		}

	}

	static class Node {
		int r, c;

		Node(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}

	static int n, m, island;
	static int[][] tmp, map, imap; // imap은 섬들이 저장된 맵임
	static int[] dist;
	static boolean[] visited;
	static int[][] drc = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
	static List<Edge>[] adjList;
	static PriorityQueue<Edge> pq;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt(); // 세로크기
		m = sc.nextInt(); // 가로크기

		tmp = new int[n][m];
		map = new int[n][m];
		imap = new int[n][m]; // 섬들끼리는 같은 숫자를 가진다
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				map[i][j] = sc.nextInt();
				tmp[i][j] = map[i][j];
			}
		}
		groupIsland(); // 인접한 섬들끼리 번호를 그룹화 해줬다

		adjList = new ArrayList[island + 1];
		for (int i = 0; i < island + 1; i++) {
			adjList[i] = new ArrayList<>();
		}

		findBridge();

//		for (List<Edge> e : adjList) {
//			System.out.println(e);
//			for (Edge ee : e) {
//				System.out.println(ee);
//			}
//		}
		prim(1); // 1번부터 시작

		int res = 0;
		for (int i = 1; i < island + 1; i++) {
			res += dist[i];
		}

		System.out.println(res);
	}

	private static void prim(int st) {
		dist = new int[island + 1];
		Arrays.fill(dist, Integer.MAX_VALUE);

		visited = new boolean[island + 1];
		pq = new PriorityQueue<>();
		pq.addAll(adjList[st]);

		// 임의의 정점 선택
		dist[st] = 0;
		visited[st] = true;

		int pick = 1;
		while (pick < island) {
			Edge curr = pq.poll();

			if (curr == null) {
				System.out.println(-1);
				System.exit(0);
				return;
			}

			if (!visited[curr.ed] && dist[curr.ed] > curr.w) {
				dist[curr.ed] = curr.w;
				visited[curr.ed] = true;
				pq.addAll(adjList[curr.ed]);
				pick++;
			}
		}
	}

	private static void findBridge() {
		for (int r = 0; r < n; r++) {
			for (int c = 0; c < m; c++) {
				// 가로 다리를 먼저 찾자
				if (imap[r][c] != 0) {
					int nr = r;
					int nc = c; // 다음 섬까지 도달할 거야
					int cnt = 0;
					while (true) {
						nc++;
						if (!is_in(nr, nc)) { // 범위 벗어나면 멈춰
							break;
						}
						if (imap[nr][nc] != 0) { // 다른 섬을 만나면 멈춰
							break;
						}
						cnt++;
					}

					if (nc != m && cnt > 1) {
						adjList[imap[r][c]].add(new Edge(imap[r][c], imap[nr][nc], cnt));
						adjList[imap[nr][nc]].add(new Edge(imap[nr][nc], imap[r][c], cnt));
					}
				}
			}
		}
		for (int c = 0; c < m; c++) {
			for (int r = 0; r < n; r++) {
				// 세로 다리를 찾자
				if (imap[r][c] != 0) {
					int nr = r;
					int nc = c;
					int cnt = 0; // 다리 개수

					while (true) {
						nr++;
						if (!is_in(nr, nc)) { // 범위 벗어나면 멈춰
							break;
						}
						if (imap[nr][nc] != 0) { // 다른 섬을 만나면 멈춰
							break;
						}
						cnt++;
					}

					if (nr != n && cnt > 1) {
						adjList[imap[r][c]].add(new Edge(imap[r][c], imap[nr][nc], cnt));
						adjList[imap[nr][nc]].add(new Edge(imap[nr][nc], imap[r][c], cnt));
					}
				}
			}
		}
	}

	private static void groupIsland() {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (tmp[i][j] == 1) {
					island++;
					Queue<Node> queue = new LinkedList<>();
					queue.add(new Node(i, j)); // 첫 시작 노드를 큐에 삽입
					tmp[i][j] = 0; // 큐에 넣었으니까 얘는 방문 OK
					imap[i][j] = island;

					while (!queue.isEmpty()) {
						Node curr = queue.poll(); // 큐에서 빼내서
						for (int d = 0; d < 4; d++) { // 연결 되려면 상하좌우가 연결돼있으니까 큐에서 빼낸 n을 기준으로 인접한 사방탐색 시작
							int nr = curr.r + drc[d][0];
							int nc = curr.c + drc[d][1];

							if (!is_in(nr, nc) || tmp[nr][nc] == 0) {
								continue;
							}
							queue.add(new Node(nr, nc)); // 큐에 다음 탐색할 곳들(현재 값이 1인 애들)을 넣어줘
							tmp[nr][nc] = 0; // 다음 위치들을 큐에 넣었으니깐 얘도 방문 OK, 1->0 으로 상태 바꿔줬음
							imap[nr][nc] = island;
						}
					}
				} // end of if
			} // end of for j
		} // end of for i
	}

	private static boolean is_in(int r, int c) {
		return r >= 0 && c >= 0 && r < n && c < m;
	}

	private static void print() {
		for (int[] m : imap) {
			for (int mm : m) {
				System.out.print(mm + " ");
			}
			System.out.println();
		}
	}
}
