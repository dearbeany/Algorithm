package boj.silver.graph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class _1260_DFS와BFS {

	static int n, m, v; // 정점 개수, 간선 개수, 탐색시작 정점
	static int[][] adjArr;
	static boolean[] visited;
	static Queue<Integer> q;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		v = sc.nextInt();

		adjArr = new int[n][n];
		visited = new boolean[n];

		for (int i = 1; i < m + 1; i++) {
			int st = sc.nextInt() - 1; // 시작정점 0번부터 시작하도록 구현
			int ed = sc.nextInt() - 1;

			adjArr[st][ed] = 1;
			adjArr[ed][st] = 1;
		}

		dfs(v - 1);
		System.out.println();
		bfs(v - 1);

	}

	private static void dfs(int v) {
		visited[v] = true;

		System.out.print(v + 1 + " ");

		for (int i = 0; i < adjArr.length; i++) {
			if (!visited[i] && adjArr[v][i] == 1) {
				dfs(i);
			}
		}
	}

	private static void bfs(int v) {
		visited = new boolean[n];
		q = new LinkedList<>();
		q.add(v);
		visited[v] = true;

		while (!q.isEmpty()) {
			int curr = q.poll();
			System.out.print(curr + 1 + " ");

			for (int i = 0; i < adjArr.length; i++) {
				if (!visited[i] && adjArr[curr][i] == 1) {
					q.add(i);
					visited[i] = true;
				}
			}
		}
	}

}
