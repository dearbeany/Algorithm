package swea.d6;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

/*
 * 1. 진입차수 0인 정점 큐에 넣기
 * 2. 큐 빌 때까지
 * 3. 노드 꺼내서 간선 없애자 
 * 4. 즉 진입차수 0이면 다시 큐 넣어
 */
public class _1267_작업순서_위상정렬2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb;
		int T = 10;
		for (int tc = 1; tc <= T; tc++) {
			sb = new StringBuilder();
			sb.append("#").append(tc).append(" ");

			int v = sc.nextInt();
			int e = sc.nextInt();
			int[][] adjArr = new int[v][v];
			int[] inDegree = new int[v];

			for (int i = 0; i < e; i++) {
				int st = sc.nextInt() - 1;
				int ed = sc.nextInt() - 1;
				adjArr[st][ed] = 1;
				inDegree[ed]++;
			}

			Queue<Integer> q = new ArrayDeque<>();
			for (int i = 0; i < v; i++) {
				if (inDegree[i] == 0) {
					q.add(i);
				}
			}

			while (!q.isEmpty()) {
				int node = q.poll();
				sb.append(node + 1).append(" ");

				for (int i = 0; i < v; i++) {
					if (adjArr[node][i] == 1) {
						inDegree[i]--;
						if (inDegree[i] == 0) {
							q.add(i);
						}
					}
				}
			}
			System.out.println(sb.toString());
		}
	}
}
