package boj.gold.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * 바이러스는 상하좌우 인접한 빈칸으로 퍼짐 
 * 새로 세우는 벽은 3개 
 * 벽 3개 세운 후 바이러스 퍼질 수 없는 곳이 안전영역
 * 안전영역 크기의 최댓값? 
 * 0=빈칸 1=벽 2=바이러스 
 * 
 */
public class _14502_연구소 {
	static class Node {
		int r, c;

		Node(int r, int c) {
			this.r = r;
			this.c = c;
		}

		@Override
		public String toString() {
			return "Node [r=" + r + ", c=" + c + "]";
		}

	}

	static int n, m;
	static int[][] map;
	static final int VIRUS = 2;
	static final int WALL = 1;
	static final int EMPTY = 0;
	static int[][] drc = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
	static int res = Integer.MIN_VALUE; // 안전영역 최대개수

	public static void main(String[] args) throws IOException {
		// 안전영역은 0의 개수의 최댓값
		// 2에서 시작해서 1이면 지나치고
		// 0이면 2로 바꾼다
		// 2근처로 벽 3개 세워보고 그 중 최댓값을 구하자
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int[n][m];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		// 원본 연구소 안 바꾸기 위한 카피맵
//		for (int i = 0; i < n; i++) {
//			copyMap[i] = map[i].clone();
//		}
//		copyMap = map;
		// 카피됐는지 확인
//		for (int[] a : copyMap) {
//			System.out.println(Arrays.toString(a));
//		}

		dfs(0);

		System.out.println(res);

	}

	private static void dfs(int wall) {
		// 벽 3개면 바이러스 뿌리자
		if (wall == 3) {
			bfs();
			return;
		}

		// 벽 3개 못 세웠으면 다시 세우기
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (map[i][j] == EMPTY) { // 빈칸이면
					map[i][j] = WALL; // 벽 세우고
					dfs(wall + 1); // 다음 dfs
					map[i][j] = EMPTY; // 다시 돌려놓고
				}
			}
		}
	}

	// 최대 안전영역 개수 찾는 함수
	private static void countSafeZone(int[][] copyMap) {
		int cnt = 0; // 안전영역 개수

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (copyMap[i][j] == EMPTY) {
					cnt++;
				}
			}
		}
		res = Math.max(cnt, res);
	}

	private static void bfs() {
		// 원본 연구소 안 바꾸기 위한 카피맵
		int[][] copyMap = new int[n][m];
		for (int i = 0; i < n; i++) {
			copyMap[i] = map[i].clone();
		}

		Queue<Node> q = new ArrayDeque<>();

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (copyMap[i][j] == VIRUS) {
					q.add(new Node(i, j));
				}
			}
		}

		while (!q.isEmpty()) {
			Node curr = q.poll();
//			System.out.println(curr);

			for (int i = 0; i < 4; i++) {
				int nr = curr.r + drc[i][0];
				int nc = curr.c + drc[i][1];

				if (is_in(nr, nc) && copyMap[nr][nc] == EMPTY) {
					copyMap[nr][nc] = VIRUS; // 바이러스 옮겼다 !!
					q.add(new Node(nr, nc)); // 큐에 넣엉
				}
			}
		}
		countSafeZone(copyMap);
	}

	private static boolean is_in(int r, int c) {
		return r >= 0 && c >= 0 && r < n && c < m;
	}
}
