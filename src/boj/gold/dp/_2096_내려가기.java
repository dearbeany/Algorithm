package boj.gold.dp;

import java.util.Scanner;

public class _2096_내려가기 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[][] map = new int[n][3]; // 최대값 저장
		int[][] map2 = new int[n][3]; // 최소값 저장

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < 3; j++) {
				map[i][j] = map2[i][j] = sc.nextInt();
			}
		}

		for (int i = 1; i < n; i++) {
			map[i][0] = Math.max(map[i - 1][0], map[i - 1][1]) + map[i][0];
			map[i][1] = Math.max(Math.max(map[i - 1][0], map[i - 1][1]), map[i - 1][2]) + map[i][1];
			map[i][2] = Math.max(map[i - 1][1], map[i - 1][2]) + map[i][2];

			map2[i][0] = Math.min(map2[i - 1][0], map2[i - 1][1]) + map2[i][0];
			map2[i][1] = Math.min(Math.min(map2[i - 1][0], map2[i - 1][1]), map2[i - 1][2]) + map2[i][1];
			map2[i][2] = Math.min(map2[i - 1][1], map2[i - 1][2]) + map2[i][2];

		}
		int max = Math.max(Math.max(map[n - 1][0], map[n - 1][1]), map[n - 1][2]);
		int min = Math.min(Math.min(map2[n - 1][0], map2[n - 1][1]), map2[n - 1][2]);

		System.out.println(max + " " + min);
	}

//	private static void print(int[][] arr) {
//		for (int i = 0; i < arr.length; i++) {
//			for (int j = 0; j < arr[i].length; j++) {
//				System.out.print(arr[i][j] + " ");
//			}
//			System.out.println();
//		}
//	}
}
