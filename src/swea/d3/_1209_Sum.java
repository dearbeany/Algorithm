package swea.d3;

import java.util.Scanner;

public class _1209_Sum {
	static int rowSum, colSum, diaSum;
	static int[][] map;
	static int N = 100;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		for (int tc = 1; tc <= 10; tc++) {
			sc.next();
			map = new int[N][N];

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					map[i][j] = sc.nextInt();
				}
			}

			isRowSum();
			isColSum();
			isDiaSum();
			System.out.printf("#%d %d\n", tc, Math.max(Math.max(rowSum, colSum), diaSum));
		}
	}

	private static void isDiaSum() {
		int max = -1, sum1 = 0, sum2 = 0;
		for (int i = 0; i < N; i++) {
			sum1 += map[i][i]; // \ 대각선
			sum2 += map[i][N - 1 - i]; // / 대각선
		}
		diaSum = Math.max(sum1, sum2);
	}

	private static void isColSum() {
		int max = -1;
		for (int i = 0; i < N; i++) {
			int sum = 0;
			for (int j = 0; j < N; j++) {
				sum += map[j][i];
			}
			max = Math.max(sum, max);
		}
		colSum = max;
	}

	private static void isRowSum() {
		int max = -1;
		for (int i = 0; i < N; i++) {
			int sum = 0;
			for (int j = 0; j < N; j++) {
				sum += map[i][j];
			}
			max = Math.max(sum, max);
		}
		rowSum = max;
	}

}
