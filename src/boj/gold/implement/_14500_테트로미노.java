package boj.gold.implement;

import java.util.Scanner;

/*
 * 테트로미노(정사각형 4개를 이어붙인 폴리오미노)
 * map 위에 19가지의 테트로미노 중 map위 숫자의 합이 가장 최대?? 
 */
public class _14500_테트로미노 {
	static int n, m, maxSum;
	static int[][] map;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		map = new int[n][m];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		maxSum = Integer.MIN_VALUE;

		checkTetro();
		System.out.println(maxSum);

	}

	// 테트로미노 검사하는 함수
	// 테트로미노는 (i,j)를 포함한 좌표 4개의 합
	// 이런 게 19개고
	// 하나 할 때마다 값 비교 해보자
	private static void checkTetro() {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				// (i, j) (i, j+1) (i, j+2) (i-1, j+2)

			}
		}
	}

	private static boolean is_in(int r, int c) {
		return r >= 0 && c >= 0 && r < n && c < m;
	}
}
