package boj.gold.bfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

//BFS, 소검스타일에 아주 가까움..ㅋ
public class Main {
	// 맵의 크기.
	static int N;
	static int M;
	// 움직일 직사각형의 크기
	static int H;
	static int W;
	// 맵과 방문배열
	static int[][] map;
	static boolean[][] visited;
	// 움직일 직사각형의 시작점
	static int Sr;
	static int Sc;
	// 목표하는 도착 점.
	static int Fr;
	static int Fc;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt(); // 2 ≤ N, M ≤ 1,000
		M = sc.nextInt();
		map = new int[N + 1][M + 1];
		visited = new boolean[N + 1][M + 1];
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= M; j++)
				map[i][j] = sc.nextInt();
		}
		H = sc.nextInt(); // 1 ≤ H ≤ N
		W = sc.nextInt(); // 1 ≤ W ≤ M
		Sr = sc.nextInt();
		Sc = sc.nextInt();
		Fr = sc.nextInt();
		Fc = sc.nextInt();
		Queue<Rect> queue = new LinkedList<>();
		// 시작점을 Rect객체로 만들어서 담고. 방문 췤
		queue.add(new Rect(Sr, Sc, 0));
		visited[Sr][Sc] = true;
		int ans = -1;
		while (!queue.isEmpty()) {
			Rect rect = queue.poll();
			if (rect.r == Fr && rect.c == Fc) {
				ans = rect.cnt;
				break;
			}
			// 4방으로. 갈수있으면 이동( 방문체크하고 큐에 삽입 )
			for (int i = 0; i < 4; i++) {
				if (movable(rect.r, rect.c, i)) {
					int nr = rect.r + dr[i];
					int nc = rect.c + dc[i];
					if (!visited[nr][nc]) {
						visited[nr][nc] = true;
						queue.add(new Rect(nr, nc, rect.cnt + 1));
					}
				}
			}
		}
		System.out.println(ans);
	}

	// 현재 r,c에서 dir방향으로 이동 가능?
	static boolean movable(int r, int c, int dir) {
		// 위로갈때는 내 위에부터 오른쪽으로 직사각형 열의크기만큼 동안 1이 없어야함.
		if (dir == 0) {
			// 아. 일단 나가지 말아야지ㅋ
			if (r - 1 <= 0)
				return false;
			for (int i = 0; i < W; i++) {
				if (map[r - 1][c + i] == 1)
					return false;
			}
		}
		if (dir == 1) {
			if (r + H > N)
				return false;
			for (int i = 0; i < W; i++) {
				if (map[r + H][c + i] == 1)
					return false;
			}
		}
		if (dir == 2) {
			if (c - 1 <= 0)
				return false;
			for (int i = 0; i < H; i++) {
				if (map[r + i][c - 1] == 1)
					return false;
			}
		}
		if (dir == 3) {
			if (c + W > M)
				return false;
			for (int i = 0; i < H; i++) {
				if (map[r + i][c + W] == 1)
					return false;
			}
		}
		return true;
	}

	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	static class Rect {
		int r, c, cnt;

		Rect(int r, int c, int cnt) {
			this.r = r;
			this.c = c;
			this.cnt = cnt;
		}
	}
}