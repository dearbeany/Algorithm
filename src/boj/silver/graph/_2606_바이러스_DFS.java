package boj.silver.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/*
 * 그래프에서 1번 컴퓨터가 웜 바이러스 걸렸을 때,
 * 1번과 인접하여서 바이러스 옮는 컴퓨터의 개수를 출력 
 */
public class _2606_바이러스_DFS {
	static int V, E, cnt;
	static ArrayList<ArrayList<Integer>> graph;
	static boolean[] visited;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		V = Integer.parseInt(br.readLine()); // 컴퓨터의 수
		E = Integer.parseInt(br.readLine()); // 연결된 간선의 수

		graph = new ArrayList<>();
		for (int i = 0; i < V + 1; i++) {
			graph.add(new ArrayList<>());
		}

		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			graph.get(start).add(end);
			graph.get(end).add(start);
		}

//		for (List<Integer> list : graph) {
//			System.out.println(list);
//		}
		visited = new boolean[V + 1];
		dfs(1);
		System.out.println(cnt);
	}

	private static void dfs(int i) {
		visited[i] = true;

		// 현재 정점과 인접하면서 방문하지 않았으면 dfs
		for (int v : graph.get(i)) {
			if (!visited[v]) {
				cnt++;
				dfs(v);
			}
		}

	}
}
