package swea.d2;

import java.util.Scanner;

public class _4835_구간합 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {
			int n = sc.nextInt(); // 정수 n개
			int m = sc.nextInt(); // 이웃한 m개의 합을 구하자

			int[] nums = new int[n];
			for (int i = 0; i < n; i++) {
				nums[i] = sc.nextInt();
			}

			int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;

			for (int i = 0; i <= n - m; i++) {
				int sum = 0;

				for (int j = i; j < i + m; j++) {
					sum += nums[j];

				}
				max = Math.max(sum, max);
				min = Math.min(sum, min);
			}

			int gap = max - min;
			System.out.printf("#%d %d\n", tc, gap);
		}
	}
}
