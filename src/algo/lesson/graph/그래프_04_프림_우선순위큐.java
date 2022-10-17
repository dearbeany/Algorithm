package algo.lesson.graph;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

/* 우선순위 큐를 이용한 프림
 * (1) 임의의 정점 하나 선택해 pq 에 넣는다
 * (2) pq에서 정점 하나 꺼내기 (pq의해 비용 가장 작은 정점이 나온다)
 * (3) pq에서 꺼낸 정점이 이미 visited라면, 다른 거 꺼내기 
 * (4) pq에서 꺼낸 정점이 아직 visited 아니면, 방문처리 후 정점의 비용 더하기
 * (5) 4의 정점과 인접한 정점들 중 방문하지 않은 정점들 pq에 넣기 
 * (6) pq 빌 때까지 2~5 반복 
 * 
 */
public class 그래프_04_프림_우선순위큐 {
	static class Edge implements Comparable<Edge> {
		int st, ed, cost;

		Edge(int st, int ed, int cost) {
			this.st = st;
			this.ed = ed;
			this.cost = cost;
		}

		@Override
		public int compareTo(Edge o) {
			return this.cost - o.cost; // 최소힙. 루트노드가 가장 작으며, 루트부터 cost 오름차순 정렬
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(input);

		int V = sc.nextInt(); // 정점의 개수, 0번부터 시작
		int E = sc.nextInt(); // 간선의 개수

		// 인접리스트를 이용하여 간선의 정보를 저장한다
		List<Edge>[] adjList = new ArrayList[V]; // 리스트들의 배열
		for (int i = 0; i < V; i++) {
			adjList[i] = new ArrayList<>();
		}

		for (int i = 0; i < E; i++) {
			int st = sc.nextInt();
			int ed = sc.nextInt();
			int cost = sc.nextInt();

			adjList[st].add(new Edge(st, ed, cost));
			adjList[ed].add(new Edge(ed, st, cost)); // 무향 그래프이므로
		}

		boolean[] visited = new boolean[V];

		PriorityQueue<Edge> pq = new PriorityQueue<>();

		// 시작정점을 하나 뽑는다. 0번 정점부터 시작한다
		visited[0] = true;
		pq.addAll(adjList[0]); // 0번 정점과 인접한 정점들 모두 넣자

		int pick = 1; // 확보한 정점의 개수. 0번 정점을 하나 뽑았다
		int minCost = 0; // 최소비용

		while (!pq.isEmpty()) {
//		while (pick != V) {
			Edge edge = pq.poll(); // 우선순위큐에서 정렬기준을 정해줬으므로 cost 가장 작은 게 뽑힌다
			if (visited[edge.ed]) { // 이미 뽑은 정점이었다면 넘겨
				continue;
			}
			minCost += edge.cost;
			pq.addAll(adjList[edge.ed]); // 다음으로 인접한 정점들 모두 넣어주자
			visited[edge.ed] = true;
			pick++;
		}
		System.out.println(minCost);
	}

	static String input = "7 11\r\n" + "0 1 32\r\n" + "0 2 31\r\n" + "0 5 60\r\n" + "0 6 51\r\n" + "1 2 21\r\n"
			+ "2 4 46\r\n" + "2 6 25\r\n" + "3 4 34\r\n" + "3 5 18\r\n" + "4 5 40\r\n" + "4 6 51\r\n" + "";
}
