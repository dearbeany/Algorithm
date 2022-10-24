package boj.gold.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * 1번부터 N번 과목까지 차례대로 최소 몇학기 이수할 수 있는지?
 * 
 */
public class _14567_선수과목 {
	static int V, E;
	static int[][] adjList;
	static int[] indegree;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		V = Integer.parseInt(st.nextToken()); // 과목 수
		E = Integer.parseInt(st.nextToken()); // 선수조건 수

		indegree = new int[V + 1];
		adjList = new int[V + 1][V + 1];

		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());

			adjList[start][end] = 1;
			indegree[end]++;
		}

		// indegree 0인 거 큐에 넣고
		// 큐 빌때까지 큐에서 하나씩 꺼내면서 indegree--
		// indegree 0 되면 다시 큐에 넣기

		Queue<Integer> q = new ArrayDeque<>();
		for (int i = 1; i < V + 1; i++) {
			if (indegree[i] == 0) {
				q.add(i);
			}
		}

//		int[] ans = new int[V + 1];
//		int pre = 1; // 최소 몇 학기

		while (!q.isEmpty()) {
			int curr = q.poll();
//			System.out.print(curr + " ");

			for (int i = 1; i < V + 1; i++) {
				if (adjList[curr][i] == 1) {
					indegree[i]--;

					if (indegree[i] == 0) {
						q.add(i);
					}
				}
			}
		}

		for (int i = 1; i < V + 1; i++) {
//			System.out.print(ans[i] + " ");
		}
	}
}
