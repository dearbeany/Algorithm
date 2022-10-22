package boj.gold.mst;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/*
 * 마을을 2개로 분리하려는데, 길의 유지비 합을 최소로 해야한다. 
 * 가중치 가장 높은 정점을 더해주지 않으면 된다 
 */
public class _1647_도시분할계획 {
	static class Edge implements Comparable<Edge> {
		int v, w;

		public Edge(int v, int w) {
			super();
			this.v = v;
			this.w = w;
		}

		@Override
		public int compareTo(Edge o) {
			return Integer.compare(this.w, o.w);
		}

		@Override
		public String toString() {
			return "Edge [v=" + v + ", w=" + w + "]";
		}

	}

	static int V, E;
	static ArrayList<ArrayList<Edge>> graph;
	static boolean[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());

		graph = new ArrayList<>();
		for (int i = 0; i < V + 1; i++) {
			graph.add(new ArrayList<>());
		}

		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());

			graph.get(start).add(new Edge(end, weight));
			graph.get(end).add(new Edge(start, weight));
		}

//		for (int i = 1; i < V + 1; i++) {
//			System.out.println(graph.get(i));
//		}

		PriorityQueue<Edge> pq = new PriorityQueue<>();
		visited = new boolean[V + 1];
		// 1번부터 시작
		pq.addAll(graph.get(1));
		visited[1] = true;

		int minCost = 0;
		int max = Integer.MIN_VALUE;

		while (!pq.isEmpty()) {
			Edge curr = pq.poll(); // 최소가중치인 거 뽑아

			if (visited[curr.v]) { // 방문했으면 넘겨
				continue;
			}
			visited[curr.v] = true;
			pq.addAll(graph.get(curr.v)); // 인접한 거 다 넣어주고
			minCost += curr.w;

			if (curr.w > max) {
				max = curr.w;
			}
		}
		System.out.println(minCost - max);
	}

}
