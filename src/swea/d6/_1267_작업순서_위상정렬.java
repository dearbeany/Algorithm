package swea.d6;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/*
 * 위상정렬이란? 
 * (1) 순서가 있는 작업을 차례대로 진행 시 순서 결정위한 알고리즘 
 * (2) DAG(유향 비사이클)의 모든 노드를 순서 맞게 나열 
 * 
 * 풀이?
 * (1) 진입차수가 0인 정점 큐에 삽입 
 * (2) 큐 공백까지 수행 
 * - 큐에서 꺼낸 정점의 간선들 모두 삭제 즉, 인접한 정점들의 진입차수 -1
 * - 다시 진입차수 0인 정점 큐에 삽입
 * (3) 큐에서 꺼내지는 순서(= 들어온 순)가 위상정렬 결과 
 */
public class _1267_작업순서_위상정렬 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb;

		for (int tc = 1; tc <= 10; tc++) {
			sb = new StringBuilder();
			sb.append("#").append(tc).append(" ");

			int V = sc.nextInt();
			int E = sc.nextInt();

			int[][] adjArr = new int[V][V]; // 인접행렬
			int[] inDegree = new int[V]; // 각 정점들의 진입차수

			// 문제에서 정점은 1번부터 시작하나
			// 풀이에선 정점 0번부터 시작. 따라서 1씩 빼준다
			for (int i = 0; i < E; i++) {
				int st = sc.nextInt() - 1;
				int ed = sc.nextInt() - 1;
				adjArr[st][ed] = 1;
				inDegree[ed]++; // 정점으로 들어오는 차수 더해준다
			}

			// (1)
			Queue<Integer> q = new LinkedList<>();
			for (int i = 0; i < V; i++) {
				if (inDegree[i] == 0) {
					q.add(i);
				}
			}

			// (2)
			while (!q.isEmpty()) {
				int node = q.poll();
				sb.append(node + 1).append(" ");

				for (int i = 0; i < V; i++) {
					if (adjArr[node][i] == 1) {
						inDegree[i]--;

						if (inDegree[i] == 0) {
							q.add(i);
						}
					}
				}
			}
			System.out.println(sb);
		}
	}

}
