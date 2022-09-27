package boj.gold.bfs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _16973_직사각형탈출 {

	static class Node {
		int r, c, cnt;

		Node(int r, int c, int cnt) {
			this.r = r;
			this.c = c;
			this.cnt = cnt;
		}
	}

	static int[][] drc = { { 1, 0 }, { -1, 0 }, { 0, -1 }, { 0, 1 } }; // 상하좌우
	static int[][] board;
	static int N, M, H, W, sx, sy, fx, fy;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken()); // 격자판 크기 N줄
		M = Integer.parseInt(st.nextToken()); // M개 정수

		// 0 = 빈칸, 1 = 벽
		board = new int[N][M];
		boolean[][] visited = new boolean[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		st = new StringTokenizer(br.readLine());
		H = Integer.parseInt(st.nextToken()); // 직사각형 세로
		W = Integer.parseInt(st.nextToken()); // 직사각형 가로
		sx = Integer.parseInt(st.nextToken()) - 1; // 시작 x 좌표
		sy = Integer.parseInt(st.nextToken()) - 1; // 시작 y 좌표
		fx = Integer.parseInt(st.nextToken()) - 1; // 도착 x 좌표
		fy = Integer.parseInt(st.nextToken()) - 1; // 도착 y 좌표

		// 직사각형의 최소 이동 횟수?
		Queue<Node> q = new LinkedList<>();
		q.add(new Node(sx, sy, 0));
		visited[sx][sy] = true;

		while (!q.isEmpty()) {
			Node n = q.poll();

			if (n.r == fx && n.c == fy) {
				System.out.println(n.cnt);
				bw.write(n.cnt + " ");
				return;
			}
			for (int i = 0; i < 4; i++) {
				int nr = n.r + drc[i][0];
				int nc = n.c + drc[i][1];

				if (isIn(nr, nc) || !isMovable(nr, nc, i) || visited[nr][nc]) {
					continue;
				}
				q.add(new Node(nr, nc, n.cnt + 1));
				visited[nr][nc] = true;
			}
		}
		bw.write(-1 + " ");
		bw.flush();
		bw.close();
	}

	public static boolean isIn(int r, int c) {
		return (r >= 0 && c >= 0 && r <= N && c <= M);
	}

//	public static boolean rectCheck(int x, int y) {
//		// 직사각형이 격자판 인덱스 내에 포함되는지 검사
//		if (x + H > N || y + W > M) {
//			return false;
//		}
//
//		// 직사각형의 범위 내에 1이 있는지 검사
//		for (int i = x; i < x + H; i++) {
//			for (int j = y; j < y + W; j++) {
//				if (board[i][j] == 1) { // 벽이 하나라도 있으면
//					return false;
//				}
//			}
//		}
//		return true;
//	}

	public static boolean isMovable(int r, int c, int dir) {
		// 상 = 0, 하 = 1, 좌 = 2, 우 =3
		switch (dir) {
		case 0: // 상
			if (!isIn(r + H - 1, c + W - 1))
				return false;

			for (int i = c; i < c + W; i++)
				if (board[r + H - 1][i] == 1)
					return false;

			return true;

		case 1: // 하단
			if (!isIn(r + H - 1, c + W - 1))
				return false;

			for (int i = c; i < c + W; i++)
				if (board[r + H - 1][i] == 1)
					return false;

			return true;

		case 2: // 좌측
			for (int i = r; i < r + H; i++)
				if (board[i][c] == 1)
					return false;

			return true;

		case 3: // 우측 이동시 우측 테두리 탐색
			if (!isIn(r + H - 1, c + W - 1))
				return false;

			for (int i = r; i < r + H; i++)
				if (board[i][c + W - 1] == 1)
					return false;

			return true;
		}
		return false;
	}

}
