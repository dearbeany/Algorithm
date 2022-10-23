package algo.lesson.그래프;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/*
 * (1) indegree 0인 모든 노드를 큐에 add
 * (2) 큐가 empty 까지 수행 
 *   - 큐에서 poll 해서 해당 노드에서 나가는 간선을 제거 
 *   - 새롭게 indegree 0이 된 노드 큐에 add 
 * 
 * 결과 : 큐에서 꺼내진 순서가 위상정렬 수행한 결과 
 */
public class 위상정렬 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = 2;
		for (int tc = 1; tc <= T; tc++) {
			int V = sc.nextInt();
			int E = sc.nextInt();
			int[] in_degree = new int[V];
			int[][] adj = new int[V][V];

			System.out.print("#" + tc + " ");

			for (int i = 0; i < E; i++) {
				int from = sc.nextInt() - 1;
				int to = sc.nextInt() - 1;
				adj[from][to] = 1;
				in_degree[to]++;
			}
			// in_degree가 0인 노드를 큐에 삽입
			Queue<Integer> queue = new LinkedList<Integer>();
			for (int i = 0; i < V; i++) {
				if (in_degree[i] == 0)
					queue.add(i);
			}
			// 큐가 빌때까지
			while (!queue.isEmpty()) {
				// 하나꺼내서 결과로 출력
				int node = queue.poll();
				System.out.print(node + 1 + " ");
				// 해당 노드로부터 나가는 간선의 목적지의 in_degree를 1 감소
				for (int i = 0; i < V; i++) {
					if (adj[node][i] == 1) {
						in_degree[i]--;
						// 0이되면 큐에 삽입
						if (in_degree[i] == 0)
							queue.add(i);
					}
				}
			}
			System.out.println();
		}
	}
}