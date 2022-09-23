package boj.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 1. 1을 덮는데 필요한 색종이의 최소 개수를 구한다. 단, 덮을 수 없으면 -1을 출력 
 * 2. 색종이는 5종류로 각각 5장씩 존재한다. 
 */
public class _17136_색종이붙이기 {
	static class Point {
		int x, y;

		Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	static final int N = 10; // 10*10개의 줄
	static int[][] paper = new int[10][10];
	static int[] colorsCnt = { 0, 5, 5, 5, 5, 5 }; // 색종이들의 개수

	static int cnt, minCnt; // 개수

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		for (int i = 0; i < 10; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 10; j++) {
				paper[i][j] = Integer.parseInt(st.nextToken());

			}
		}
		// 색종이의 개수를 알아낸다 .. 재귀를 이용해서
		// 1이면 가장 큰 종이부터 붙일 수 있는지 탐색한다
		// 단, 큰 종이를 붙여도 작은 종이가 개수가 더 적은 경우가 존재한다 => 완전탐색 해야 함
		minCnt = Integer.MAX_VALUE;
		cnt = 0; // 현재까지 색종이 최소 개수
		perm(0, 0, 0);

		minCnt = (minCnt == Integer.MAX_VALUE) ? -1 : minCnt;
		System.out.println(minCnt);

	}

	// 붙일 수 있는지
	public static boolean isStickerble(int r, int c, int size) {
		for (int i = r; i < r + size; i++) {
			for (int j = c; j < c + size; j++) {
				if (paper[i][j] == 0 || i >= 10 || j >= 10) { // i, j 범위 넘어가면 붙일 수 없음
					return false;
				}
			}
		}
		return true;
	}

	// 붙였다 뗐다하는 메소드
	public static void isSticked(int r, int c, int size) {
		for (int i = r; i < r + size; i++) {
			for (int j = c; j < c + size; j++) {
				paper[i][j] = (paper[i][j] == 0) ? 1 : 0;
			}
		}
	}

	// 색종이.. 순열?
	public static void perm(int i, int j, int cnt) {
		if (cnt > minCnt) {
			return;
		}
		if (i == 9 && j == 10) { // 색종이 다 고르면
			minCnt = Math.min(cnt, minCnt);
			return;
		}

		if (j > 9) { // 맨 끝열로 가면
			i += 1; // 행 증가
			j = 0; // 열 초기화
		}

		switch (paper[i][j]) {
		case 0: // 0이면
			perm(i, j + 1, cnt);
			break;

		case 1: // 1이면 종이 붙일 수 있는지 확인하자
			for (int s = 5; s > 0; s--) {
				if (isStickerble(i, j, s) && colorsCnt[s] > 0) { // 붙일 수 있으면 붙였다 뗐다.. dfs..
					colorsCnt[s]--; // 종이 개수 하나 뺌
					isSticked(i, j, s); // 붙였다!
					perm(i, j + 1, cnt + 1);
					colorsCnt[s]++; // 종이 개수 하나 더함
					isSticked(i, j, s);
				}
			}
			break;
		}
	}

}
