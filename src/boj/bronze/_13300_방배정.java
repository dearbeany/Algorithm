package boj.bronze;

import java.util.Scanner;

public class _13300_방배정 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt(); // 최대 인원 이하여야

		int[][] map = new int[7][2]; // 1~6학년, 0은 여 1은 남

		for (int i = 0; i < n; i++) {
			int gender = sc.nextInt();
			int grade = sc.nextInt();

			map[grade][gender]++;
		}

		for (int i = 1; i < 7; i++) {
			for (int j = 0; j < 2; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
	}
}
