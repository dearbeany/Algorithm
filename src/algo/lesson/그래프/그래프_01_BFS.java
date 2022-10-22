package algo.lesson.그래프;

import java.util.LinkedList;
import java.util.Queue;

//와이파이야
public class 그래프_01_BFS {
	public static void main(String[] args) {
		// 인접행렬
		int N = 7;
		// 무방향 행렬, 대칭행렬
		int[][] adj = { { 0, 1, 1, 0, 0, 1, 0 }, { 1, 0, 0, 1, 0, 0, 1 }, { 1, 0, 0, 1, 0, 0, 0 },
				{ 0, 1, 1, 0, 0, 0, 1 }, { 0, 0, 0, 0, 0, 1, 1 }, { 1, 0, 0, 0, 1, 0, 0 }, { 0, 1, 0, 1, 1, 0, 0 } };

		Queue<Integer> queue = new LinkedList<>();
		boolean[] visited = new boolean[N];

		// 시작정점을 넣고 시작
		queue.add(0);
		visited[0] = true;

		while (!queue.isEmpty()) { // 큐가 빌 때까지
			int V = queue.poll(); // 정점을 꺼내고
			System.out.println(V + " -> ");

			// 나와 연결되어 있는 자식노드들을 큐에 추가
			for (int i = 0; i < adj.length; i++) {
				if (!visited[i] && adj[V][i] == 1) { // 방문하지 않았고 && V와 i가 연결되어있다면
					queue.add(i);
					visited[i] = true; // 방문처리
				}
			}

		}

	}
}
