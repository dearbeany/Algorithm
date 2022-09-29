package algo.lesson.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 그래프_03_크루스칼_우선순위큐 {
	// 간선 정보 클래스
	static class Edge implements Comparable<Edge> {
		int s;
		int e;
		int w;

		public Edge(int s, int e, int w) {
			this.s = s;
			this.e = e;
			this.w = w;
		}

		// 우선 순위 큐 활용
		@Override
		public int compareTo(Edge e) {
			return this.w - e.w;
		}

		static StringTokenizer st;
		static int V; // 정점의 개수
		static int E; // 간선의 개수
		static int[] p;
		static PriorityQueue<Edge> queue; // 간선 정보 저장

		public static void main(String[] args) throws IOException {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

			st = new StringTokenizer(br.readLine());

			V = Integer.parseInt(st.nextToken());
			E = Integer.parseInt(st.nextToken());
			queue = new PriorityQueue<>();
			p = new int[V + 1];

			// 부모노드 세팅
			for (int i = 1; i <= V; i++) {
				p[i] = i;
			}

			// 간선 정보 입력
			for (int i = 0; i < E; i++) {
				st = new StringTokenizer(br.readLine());

				int s = Integer.parseInt(st.nextToken());
				int e = Integer.parseInt(st.nextToken());
				int w = Integer.parseInt(st.nextToken());

				queue.offer(new Edge(s, e, w));
			}

			// 사이클 확인 (union-find)
			int minCost = 0;
			while (!queue.isEmpty()) {
				Edge cur = queue.poll(); // 가중치가 가장 작은 간선
				// 부모노드가 다를때만 (사이클X)
				if (findSet(cur.s) != findSet(cur.e)) {
					union(cur.s, cur.e);
					minCost += cur.w;
				}
			}
			System.out.println(minCost);

		}

		// 합치기
		public static void union(int x, int y) {
			int px = findSet(x);
			int py = findSet(y);

			if (px < py)
				p[py] = px; // 부모가 다르면 y의 부모를 x로 바꿔준다
			else
				p[px] = py;
		}

		// 부모 노드 찾기
		public static int findSet(int n) {
			if (p[n] == n) { // 원소 n의 부모가 n이면 그대로 n을 리턴
				return n;
			}
			// 만약 아니라면 n의 부모를 find에 보내 재귀호출을 해 n의 부모 찾기
			return p[n] = findSet(p[n]);
		}
	}
}
