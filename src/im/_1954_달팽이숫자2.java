package im;

import java.util.Scanner;

public class _1954_달팽이숫자2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {
			int n = sc.nextInt();
			int[][] map = new int[n][n];

			int num = 1, r = 0, c = 0, d = 0;

			while (num <= n * n) {
				map[r][c] = num++;

				switch (d) {
				case 0: // 우로 가기
					if (c + 1 < n && map[r][c + 1] == 0) {
						c++;
					} else {
						d = 1; // 하로 바꿔
						r++;
					}
					break;

				case 1: // 아래로 가기
					if (r + 1 < n && map[r + 1][c] == 0) {
						r++;
					} else {
						d = 2; // 좌로 바꿔
						c--;
					}
					break;

				case 2: // 좌로 가기
					if (c - 1 >= 0 && map[r][c - 1] == 0) {
						c--;
					} else {
						d = 3; // 상으로 바꿔
						r--;
					}
					break;

				case 3: // 위로 가기
					if (r - 1 >= 0 && map[r - 1][c] == 0) {
						r--;
					} else {
						d = 0; // 우로 바꿔
						c++;
					}
					break;
				}
			} // end of while

			System.out.printf("#%d\n", tc);
			print(map);
		}

	}

	public static void print(int[][] arr) {
		for (int[] aa : arr) {
			for (int a : aa) {
				System.out.print(a + " ");
			}
			System.out.println();
		}
	}
}
