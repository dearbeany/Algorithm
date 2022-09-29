package boj.gold.mst;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

// 다익스트라
// i번째 줄에 i번 정점으로의 최단경로의 경로값 
public class _1753_최단경로_다익스트라 {
	static class Node implements Comparable<Node> {
		int v, w; // vertex와 weight

		Node(int v, int w) {
			this.v = v;
			this.w = w;
		}

		@Override
		public String toString() {
			return "Node [v=" + v + ", w=" + w + "]";
		}

		@Override
		public int compareTo(Node o) {
			return this.w - o.w;
		}

	}

	static List<Node>[] adjList;
	static int[] dist;
	static final int INF = Integer.MAX_VALUE;
	static int V, E, K;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
//		Scanner sc = new Scanner(input);

		V = sc.nextInt(); // 1번부터 시작
		E = sc.nextInt();
		K = sc.nextInt(); // 시작정점의 번호

//		System.out.println(V + " " + E + " " + K);
		adjList = new ArrayList[V + 1];
		for (int i = 0; i < V + 1; i++) {
			adjList[i] = new ArrayList<>();
		}

		dist = new int[V + 1];
		Arrays.fill(dist, INF);

		for (int i = 0; i < E; i++) {
			int s = sc.nextInt();
			int e = sc.nextInt();
			int w = sc.nextInt();
			adjList[s].add(new Node(e, w));
		}

//		for (List<Node> list : adjList) {
//			System.out.println(list);
//		}

		dijkstra(K);

		for (int i = 1; i < V + 1; i++) {
			if (dist[i] == INF) {
				System.out.println("INF");
			} else {
				System.out.println(dist[i]);
			}
		}
	}

	private static void dijkstra(int st) {
		PriorityQueue<Node> pq = new PriorityQueue<>();

		boolean[] visited = new boolean[V + 1];
		pq.add(new Node(st, 0));
		dist[st] = 0;

		while (!pq.isEmpty()) {
			Node curr = pq.poll();

			if (visited[curr.v]) {
				continue;
			}
			visited[curr.v] = true;

			for (Node node : adjList[curr.v]) {
				if (!visited[node.v] && dist[node.v] > dist[curr.v] + node.w) {
					dist[node.v] = dist[curr.v] + node.w;
					pq.add(new Node(node.v, dist[node.v]));
				}
			}
		}

	}

//	static String input = "5 6\r\n" + "1\r\n" + "5 1 1\r\n" + "1 2 2\r\n" + "1 3 3\r\n" + "2 3 4\r\n" + "2 4 5\r\n"
//			+ "3 4 6";
}
