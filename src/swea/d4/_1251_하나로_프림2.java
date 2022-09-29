package swea.d4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class _1251_하나로_프림2 {
	static class Node implements Comparable<Node> {
		int idx;
		double w;

		Node(int idx, double w) {
			this.idx = idx;
			this.w = w;
		}

		@Override
		public int compareTo(Node o) {
			return (int) (this.w - o.w);
		}
	}

	static int V; // 섬 개수
	static int[][] island;
	static double tax;
	static boolean[] visited;
	static PriorityQueue<Node> pq;

	public static void main(String[] args) throws NumberFormatException, IOException {
		// minCost = 환경 부담세율(E) * 해저터널길이(L)^2

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			V = Integer.parseInt(br.readLine()); // 섬의 개수

			visited = new boolean[V];

			island = new int[V][2]; // 0 : x, 1: y

			st = new StringTokenizer(br.readLine());
			StringTokenizer st2 = new StringTokenizer(br.readLine());
			for (int i = 0; i < V; i++) {
				island[i][0] = Integer.parseInt(st.nextToken());
				island[i][1] = Integer.parseInt(st2.nextToken());
			}

			tax = Double.parseDouble(br.readLine()); // 환경부담세율

			double minCost = 0; // 최소비용

			pq = new PriorityQueue<>();
			pq.add(new Node(0, 0)); // 0번 정점부터 시작하자

			while (!pq.isEmpty()) {
				Node n = pq.poll(); // pq로 정렬했으니까 w가 작은 게 뽑힌다

				if (visited[n.idx]) {// 이미 방문했다면 패스
					continue;
				}
				visited[n.idx] = true; // 위에서 방문했어
				minCost += n.w; // 비용을 더해주자

				// 다른정점과 가중치를 구해서 큐에 넣어
				for (int i = 0; i < V; i++) {
					pq.add(new Node(i, isWeight(island[n.idx][0], island[n.idx][1], island[i][0], island[i][1])));
				}
			} // end of while
			System.out.println("#" + tc + " " + Math.round(tax * minCost)); // 반올림해서 출력하자
		}
	}

	// 정점 간 가중치를 구하는 함수
	private static double isWeight(int x1, int y1, int x2, int y2) {
		return Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2);
	}

}
