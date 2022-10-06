package boj.silver.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * bfs:간선의 비용이 모두 같을 때 최단거리를 구하기 위해 사용
 */
public class _2178_미로탐색 {
	static class Node {
		int x;
		int y;

		Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	static int N, M;
	static int[][] maze;
	static int cnt; // 지나야 하는 최소의 칸 수
	// 상 우 하 좌
	static int dx[] = { -1, 0, 1, 0 };
	static int dy[] = { 0, 1, 0, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken()); // N개의 줄
		M = Integer.parseInt(st.nextToken()); // M개의 정수 미로

		maze = new int[N][M];

		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < M; j++) {
				maze[i][j] = str.charAt(j) - '0';
			}
		}
		bfs(0, 0);
	}

	// (0,0)에서 출발 (N-1, M-1) 도착
	private static void bfs(int r, int c) {
		Queue<Node> q = new LinkedList<>();

		if (r == N - 1 && c == M - 1) { // 도착하면 리턴
			return;
		}

		for (int i = 0; i < 4; i++) {

		}

	}
}
