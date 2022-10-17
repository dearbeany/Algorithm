package boj.gold.mst;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class _1922_네트워크연결 {
	static class Edge implements Comparable<Edge> {
		int v, w;

		Edge(int v, int w) {
			this.v = v;
			this.w = w;
		}

		@Override
		public int compareTo(Edge o) {
			return this.w - o.w;
		}

		@Override
		public String toString() {
			return "Edge [v=" + v + ", w=" + w + "]";
		}

	}

	static int V, E;
	static ArrayList<ArrayList<Edge>> graph;
	static int[] p, dist;
	static boolean[] visited;
	static final int INF = Integer.MAX_VALUE;
	static PriorityQueue<Edge> pq;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		V = Integer.parseInt(br.readLine()); // 컴퓨터 수
		E = Integer.parseInt(br.readLine()); // 간선 개수

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
		// 확인
//		for (List<Edge> list : graph) {
//			System.out.println(list);
//		}

		visited = new boolean[V + 1];
		pq = new PriorityQueue<>();

		visited[1] = true;
		pq.addAll(graph.get(1));

		int pick = 1;
		int minCost = 0;

		while (pick != V) {
			Edge edge = pq.poll();
			if (visited[edge.v]) {
				continue;
			}
			minCost += edge.w;
			pq.addAll(graph.get(edge.v));
			visited[edge.v] = true;
			pick++;
		}

		System.out.println(minCost);

	}
}
