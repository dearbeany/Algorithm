package boj.gold.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class _1916_최소비용구하기 {
	static class Node implements Comparable<Node> {
		int v, w;

		public Node(int v, int w) {
			super();
			this.v = v;
			this.w = w;
		}

		@Override
		public String toString() {
			return "Node [v=" + v + ", w=" + w + "]";
		}

		@Override
		public int compareTo(Node o) {
			return Integer.compare(this.w, o.w);
		}

	}

	static int V, E, stNode, finNode;
	static boolean[] visited;
	static ArrayList<ArrayList<Node>> graph;
	static int[] dist;
	static PriorityQueue<Node> pq;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		V = Integer.parseInt(br.readLine()); // 도시 개수
		E = Integer.parseInt(br.readLine()); // 도시 다니는 버스비용 개수

		graph = new ArrayList<>();
		for (int i = 0; i < V + 1; i++) {
			graph.add(new ArrayList<>());
		}

		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());

			graph.get(start).add(new Node(end, weight));
		}

//		for (int i = 1; i < V + 1; i++) {
//			System.out.println(graph.get(i));
//		}
		st = new StringTokenizer(br.readLine());
		stNode = Integer.parseInt(st.nextToken()); // 출발 도시
		finNode = Integer.parseInt(st.nextToken()); // 도착 도시

		visited = new boolean[V + 1];
		dist = new int[V + 1];
		Arrays.fill(dist, Integer.MAX_VALUE);

		dijkstra(stNode);
		System.out.println(dist[finNode]);

	}

	private static void dijkstra(int start) {
		pq = new PriorityQueue<>();

		dist[start] = 0;
		pq.add(new Node(start, 0));

		while (!pq.isEmpty()) {
			Node curr = pq.poll();

			if (visited[curr.v]) {
				continue;
			}
			visited[curr.v] = true;

			for (Node node : graph.get(curr.v)) {
				if (!visited[node.v] && dist[node.v] > dist[curr.v] + node.w) {
					dist[node.v] = dist[curr.v] + node.w;
					pq.add(new Node(node.v, dist[node.v]));
				}
			}

		}
	}
}
