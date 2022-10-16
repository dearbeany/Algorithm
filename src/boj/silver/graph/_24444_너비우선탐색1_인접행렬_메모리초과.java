package boj.silver.graph;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * 노드 방문 시, 그 노드를 몇 번째 방문했는지 알아야 하기에 seqVisited 도입 
 * bfs 후 한 번도 방문하지 않았다면 seqVisited의 해당 값이 0일 것 
 */
public class _24444_너비우선탐색1_인접행렬_메모리초과 {

	static int[][] adjArr;
	static int[] seqVisited; // 노드의 방문순서
	static boolean[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken()) - 1; // 시작 정점

		adjArr = new int[n][n]; // 예제입력은 정점 1번부터 시작함 주의
		seqVisited = new int[n]; // 각 노드를 몇 번째 방문했는지?
		visited = new boolean[n];

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken()) - 1;
			int end = Integer.parseInt(st.nextToken()) - 1;

			adjArr[start][end] = 1;
			adjArr[end][start] = 1; // 무방향이니깐
		}

		bfs(r);

		for (int cnt : seqVisited) {
			bw.write(cnt + "\n");
		}
		bw.flush();
		bw.close();

	}

	private static void bfs(int r) {
		Queue<Integer> q = new LinkedList<>();
		q.add(r);
		seqVisited[r] = 1;
		visited[r] = true;
		int cnt = 2; // 몇 번째로 방문했는지

		while (!q.isEmpty()) {
			int curr = q.poll();

			for (int i = 0; i < adjArr.length; i++) {
				if (!visited[i] && adjArr[curr][i] == 1) {
					q.add(i);
					seqVisited[i] = cnt++;
					visited[i] = true;
				}
			}
		}

	}
}