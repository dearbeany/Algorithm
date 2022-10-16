package boj.silver.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

/*
 * 정점번호는 내림차순으로 방문해야 한다 
 * 정점 i의 방문순서를 출력한다 
 */
public class _24480_깊이우선탐색2 {
	static ArrayList<ArrayList<Integer>> graph;
	static int[] seq; // 정점의 방문순서 저장
	static boolean[] visited;
	static int cnt;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int v = Integer.parseInt(st.nextToken()); // 정점 개수
		int e = Integer.parseInt(st.nextToken()); // 간선 개수
		int r = Integer.parseInt(st.nextToken()); // 시작 정점

		graph = new ArrayList<>();
		for (int i = 0; i < v + 1; i++) {
			graph.add(new ArrayList<>());
		}

		for (int i = 0; i < e; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());

			graph.get(start).add(end);
			graph.get(end).add(start);
		}

		seq = new int[v + 1];
		visited = new boolean[v + 1];

		// 인접 노드들은 내림차순으로 방문하자
		for (int i = 0; i < v + 1; i++) {
			Collections.sort(graph.get(i), Collections.reverseOrder());
		}
		cnt = 1;
		dfs(r);

		for (int i = 1; i < v + 1; i++) {
			System.out.println(seq[i]);
		}
	}

	private static void dfs(int r) {
		visited[r] = true;
		seq[r] = cnt++;

		for (int v : graph.get(r)) {
			if (!visited[v]) {
				dfs(v);
			}
		}
	}
}
