package swea.d2;

import java.util.Scanner;

public class _1984_중간평균값구하기 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		int N = 10;
		for (int tc = 1; tc <= T; tc++) {
			int[] arr = new int[N];
			for (int i = 0; i < N; i++) {
				arr[i] = sc.nextInt();
			}

			int max = arr[0];
			int min = arr[0];
			int maxIdx = 0, minIdx = 0;
			double sum = 0;

			for (int i = 0; i < N; i++) {
				if (arr[i] > max) {
					max = arr[i];
					maxIdx = i;
				}
				if (arr[i] < min) {
					min = arr[i];
					minIdx = i;
				}
			}

			for (int i = 0; i < N; i++) {
				if (i == maxIdx || i == minIdx) {
					continue;
				} else {
					sum += arr[i];
				}
			}
			double res = Math.round(sum / (N - 2));

			System.out.printf("#%d %d\n", tc, (int) res);

		}
	}
}
