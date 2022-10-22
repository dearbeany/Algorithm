package algo.lesson.그래프;

//빌리지 손가락
public class 그래프_01_DFS {
	// 인접행렬
	static int N = 7;
	static int[][] adj = { { 0, 1, 1, 0, 0, 1, 0 }, { 1, 0, 0, 1, 0, 0, 1 }, { 1, 0, 0, 1, 0, 0, 0 },
			{ 0, 1, 1, 0, 0, 0, 1 }, { 0, 0, 0, 0, 0, 1, 1 }, { 1, 0, 0, 0, 1, 0, 0 }, { 0, 1, 0, 1, 1, 0, 0 } };
	static boolean[] visited = new boolean[N];

	public static void main(String[] args) {
		dfs(0);
	}
	// 스택 직접 이용할 수도 있고
	// 재귀를 이용하면 알아서 시스템 스택을 이용한다

	static void dfs(int V) {
		visited[V] = true; // 방문처리
		System.out.println(V);

		for (int i = 0; i < N; i++) { // 인접행렬을 순회하면서
			if (!visited[i] && adj[V][i] == 1) // 방문하지 않았고, 그래프가 연결되어 있다면
				dfs(i);
		}
	}
}
