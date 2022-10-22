package boj.gold.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/*
 * 친구관계가 존재하는지 안 하는지 
 * A B C D E가 이어져있어야 한다 
 * 즉, 일직선으로 연결된 노드가 5개여야 한다 
 */
public class _13023_ABCDE {

	static int V, E, depth; // 사람의 수, 간선의 수
	static ArrayList<ArrayList<Integer>> graph;
	static boolean[] visited;
	static boolean isFriend;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());

		graph = new ArrayList<>();
		for (int i = 0; i < V; i++) {
			graph.add(new ArrayList<>());
		}

		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			graph.get(start).add(end);
			graph.get(end).add(start);
		}

//		for (ArrayList<Integer> list : graph) {
//			System.out.println(list);
//		}
		isFriend = false;

		int ans = 0;
		visited = new boolean[V];
		for (int i = 0; i < V; i++) {
			dfs(i, 1);
			if (isFriend) {
				ans = 1;
				break;
			}
		}
		System.out.println(ans);

	}

	private static void dfs(int v, int depth) {
//		System.out.println("v:" + v + " , depth: " + depth);
		if (depth == 5) {
			isFriend = true;
			return;
		}
		visited[v] = true;
//		System.out.println(v);

		// 현재 정점과 인접하면서 방문하지 않았으면
		for (int adj : graph.get(v)) {
			if (!visited[adj]) {
				dfs(adj, depth + 1);
			}
		}
		visited[v] = false; // 다시 방문 초기화해줘야 모든 경로 탐색
	}
}
