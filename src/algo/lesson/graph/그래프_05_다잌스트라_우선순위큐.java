package algo.lesson.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class 그래프_05_다잌스트라_우선순위큐 {
	static class Node implements Comparable<Node> {
		int v, weight;

		public Node(int v, int weight) {
			this.v = v;
			this.weight = weight;
		}

		@Override
		public int compareTo(Node o) {
			return Integer.compare(this.weight, o.weight);
		}
	}

	static final int INF = Integer.MAX_VALUE;
	static int V, E; // V : 정점 , E : 간선
	static List<Node>[] adjList; // 인접리스트
	static int[] dist; // 최단 길이를 저장할 값들.

	public static void main(String[] args) {
		Scanner sc = new Scanner(input);

		V = sc.nextInt(); // 0번부터 시작
		E = sc.nextInt();

		adjList = new ArrayList[V];
		for (int i = 0; i < V; i++)
			adjList[i] = new ArrayList<>();

		dist = new int[V];
		Arrays.fill(dist, INF);

		/////////////////////////////// 초기화 완료
		for (int i = 0; i < E; i++) {
			int st = sc.nextInt();
			int ed = sc.nextInt();
			int w = sc.nextInt();

			// 유향 그래프 였어요.
			adjList[st].add(new Node(ed, w)); // 인접 리스트에 넣기
		} // 입력끝

		dijkstra(0);

		System.out.println(Arrays.toString(dist));

	}

	private static void dijkstra(int st) {
		PriorityQueue<Node> pq = new PriorityQueue<>();

		boolean[] visited = new boolean[V]; // 박문철2 용도

		pq.add(new Node(st, 0)); // 시작 정점을 넣어 놓겠다.
		dist[st] = 0; // 시작 노드까지의 거리는 0

		while (!pq.isEmpty()) {
			Node curr = pq.poll();

			if (visited[curr.v])
				continue; // 이미 최단경로의 비용을 알고 있어
			visited[curr.v] = true; // 선택했어.

			// 현재 꺼낸 노드와 연결된 노드들을 하나씩 가져오세요.
			for (Node node : adjList[curr.v]) {
				if (!visited[node.v] && dist[node.v] > dist[curr.v] + node.weight) {
					dist[node.v] = dist[curr.v] + node.weight;
					pq.add(new Node(node.v, dist[node.v]));
				}
			}
		}
	}

	static String input = "6 11\r\n" + "0 1 4\r\n" + "0 2 2\r\n" + "0 5 25\r\n" + "1 3 8\r\n" + "1 4 7\r\n"
			+ "2 1 1\r\n" + "2 4 4\r\n" + "3 0 3\r\n" + "3 5 6\r\n" + "4 3 5\r\n" + "4 5 12\r\n" + "";
}
