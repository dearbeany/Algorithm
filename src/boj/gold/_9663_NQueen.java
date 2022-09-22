package boj.gold;

import java.util.Scanner;

/*
 * 1. N*N의 체스판 위 퀸 N개를 서로 공격할 수 없게 놓는다
 * 2. 같은 행, 열, 대각선 안 됨 
 */
public class _9663_NQueen {

	static boolean[][] chess;
	static int N, cnt; // 퀸 개수 동시에 체스판 크기, 경우의 수

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();

		N = sc.nextInt();

		// 퀸을 놓으면 true, 안 놓으면 false
		chess = new boolean[N][N];
		cnt = 0;
		putQueen(0);

		sb.append(cnt);
		System.out.print(sb);

	}

	public static void putQueen(int r) {
		if (r == N) {
			cnt++;
			return;
		}

		for (int c = 0; c < N; c++) {
			if (isPutable(r, c)) {
				chess[r][c] = true;
				putQueen(r + 1);
				chess[r][c] = false;
			}
		}

	}

	// 퀸 놓아도 되는지?
	public static boolean isPutable(int r, int c) {
		return (isPutableLeft(r, c) & isPutableRight(r, c) & isPutableTop(r, c));
	}

	// 좌상, 상, 우상방향이 비어있으면 놓을 수 있다
	// 좌상 (-1, -1) 탐색
	public static boolean isPutableLeft(int r, int c) {
		while (r >= 0 && c >= 0) {
			if (chess[r][c]) {
				return false;
			}
			r--;
			c--;
		}
		return true;
	}

	// 우상 (-1, 1) 탐색
	public static boolean isPutableRight(int r, int c) {
		while (r >= 0 && c < N) {
			if (chess[r][c]) {
				return false;
			}
			r--;
			c++;
		}
		return true;
	}

	// 위로 탐색 (1, 0)
	public static boolean isPutableTop(int r, int c) {
		while (r >= 0) {
			if (chess[r][c]) {
				return false;
			}
			r--;
		}
		return true;
	}
}
