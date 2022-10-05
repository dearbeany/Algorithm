package boj.silver.dp;

import java.util.Scanner;

/*
 * 1. 한 행마다 RGB중 최소비용인 색상을 먼저 고른다
 * 2. 다음행 고를 때 이전행과 인접하지 않은 RGB중 최소비용 고른다 
 * 3. 마지막행에 최소비용들이 저장된다 
 */

public class _1149_RGB거리 {
	static int n;
	static int[][] map;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(); // 집의 수

		map = new int[n][3];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < 3; j++) {
				map[i][j] = sc.nextInt();
			}
		}

		for (int i = 1; i < n; i++) {
			map[i][0] = Math.min(map[i - 1][1], map[i - 1][2]) + map[i][0];
			map[i][1] = Math.min(map[i - 1][0], map[i - 1][2]) + map[i][1];
			map[i][2] = Math.min(map[i - 1][0], map[i - 1][1]) + map[i][2];
		}
		int minCost = Math.min(Math.min(map[n - 1][0], map[n - 1][1]), map[n - 1][2]);

		System.out.println(minCost);
	}

}
