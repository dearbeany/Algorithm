package swea.d4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;

/*
 * 1. 거리가 저장되는 배열 dist를 무한대로 세팅
 * 2. 임의의 정점으로부터 시작. 시작노드는 PQ에 넣어주기 
 * 3. PQ(정렬기준이 명시된)에서 시작노드를 꺼내면서 인접노드들 탐색 (단, 이미 방문한 건 패스)
 * 4. 최단경로의 비용으로 갱신하자  
 * - 인접노드의 dist > 현재노드의 dist + 인접노드의 값 이라면 갱신
 * 5. 갱신한 값이 담긴 노드를 다시 큐에 넣어주기 
 */

public class _1249_보급로_다익스트라 {
	static class Node implements Comparable<Node> {
		int r, c, time;

		Node(int r, int c, int time) {
			this.r = r;
			this.c = c;
			this.time = time;
		}

		@Override
		public int compareTo(Node o) {
			return Integer.compare(this.time, o.time);
		}
	}

	static int n;
	static int[][] adjArr, dist;
	static boolean[][] visited;
	static final int INF = Integer.MAX_VALUE;
	static int[][] drc = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			n = Integer.parseInt(br.readLine());
			adjArr = new int[n][n];
			visited = new boolean[n][n];

			for (int i = 0; i < n; i++) {
				String str = br.readLine();
				for (int j = 0; j < n; j++) {
					adjArr[i][j] = str.charAt(j) - '0';
				}
			}

			dist = new int[n][n]; // 복구시간들이 저장되는 배열
			for (int i = 0; i < n; i++) {
				Arrays.fill(dist[i], INF); // 무한대 값으로 세팅 해주고
			}

			// (0,0) 출발 ~ (n-1, n-1) 도착
			dijkstra(new Node(0, 0, 0)); // 출발위치 (0,0)에서 깊이는 0으로 시작
			System.out.printf("#%d %d\n", tc, dist[n - 1][n - 1]); // 마지막 위치에 저장된 값이 내 최단 거리
		}
	}

	private static void dijkstra(Node node) {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.add(node);
		dist[0][0] = 0; // 시작노드까지 소요되는 시간은 0

		while (!pq.isEmpty()) {
			Node curr = pq.poll(); // 걸리는 시간이 가장 짧은 노드를 우선순위큐가 먼저 꺼내주도록 한다

			if (curr.r == n - 1 && curr.c == n - 1) { // 현재 노드가 마지막까지 탐색하면 리턴
				return;
			}

			if (visited[curr.r][curr.c]) { // 방문한 적 있다면 패스
				continue;
			}
			visited[curr.r][curr.c] = true; // 방문한 적 없으면 방문처리

			for (int d = 0; d < 4; d++) { // 현재 꺼낸 노드(curr)를 기준 사방으로 인접한 노드들 탐색
				int nr = curr.r + drc[d][0];
				int nc = curr.c + drc[d][1];

				if (!is_in(nr, nc)) { // 배열 범위 넘어나면 패스
					continue;
				}

				// 방문하지 않았고
				// 사방탐색하는 인접노드(node)까지의 시간 > 현재노드(curr)에 저장된 시간 + 깊이 보다 크다면
				if (!visited[nr][nc] && dist[nr][nc] > dist[curr.r][curr.c] + adjArr[nr][nc]) {
					dist[nr][nc] = dist[curr.r][curr.c] + adjArr[nr][nc]; // 다음위치까지의 시간을 갱신해주고
					pq.add(new Node(nr, nc, dist[nr][nc])); // 큐에 넣어줘
				}
			}
		}
	}

	private static boolean is_in(int r, int c) {
		return (r >= 0 && c >= 0 && r < n && c < n);
	}

}
