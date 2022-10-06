package boj.silver.dp;

import java.util.Scanner;

/*
 * (1,1) 출발 ~ (n,m)도착 
 * 우, 하, 우하로만 이동 가능 
 */
public class _11048_이동하기 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();

		int[][] map = new int[n][m];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				map[i][j] = sc.nextInt();
			}
		}

		// 첫 행 채우기, 우방향으로밖에 못 오니깐
		for (int c = 1; c < m; c++) {
			map[0][c] = map[0][c - 1] + map[0][c];
		}

		// 첫 열 채우기, 하방향으로밖에 못 가니까
		for (int r = 1; r < n; r++) {
			map[r][0] = map[r - 1][0] + map[r][0];
		}

		// 첫행 첫열 제외하고
		// (1,1)부터 (n-1, m-1)까지 채우기
		for (int r = 1; r < n; r++) {
			for (int c = 1; c < m; c++) {
				// 현재 원소를 기준으로 좌상, 상, 좌인 세방향인 이전 원소로부터 오는 것 중에
				// 가장 최대값 + 현재 내 자리의 사탕개수 더해서 갱신하자
				map[r][c] = Math.max(Math.max(map[r - 1][c - 1], map[r - 1][c]), map[r][c - 1]) + map[r][c];
			}
		}

		System.out.println(map[n - 1][m - 1]); // 마지막에 저장된 게 사탕 최소값
	}

//	private static void print(int[][] map) {
//		for (int i = 0; i < map.length; i++) {
//			for (int j = 0; j < map[i].length; j++) {
//				System.out.print(map[i][j] + " ");
//			}
//			System.out.println();
//		}
//	}
}
