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

		int room = 0;
		for (int i = 1; i < 7; i++) {
			for (int j = 0; j < 2; j++) {
				if (map[i][j] == 0) {
					continue;
				}
				if (map[i][j] > k) {
					room += Math.ceil((double) map[i][j] / k);
				} else {
					room++;
				}
			}
		}
		System.out.println(room);
	}
}
