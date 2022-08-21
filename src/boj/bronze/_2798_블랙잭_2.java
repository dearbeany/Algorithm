package boj.bronze;

import java.util.Scanner;

public class _2798_블랙잭_2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt(); // 카드의 개수
		int M = sc.nextInt(); // 합

		int[] arr = new int[N];

		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}

		int sum = 0, max = 0;

		for (int i = 0; i < N; i++) {
			for (int j = i + 1; j < N; j++) {
				for (int k = j + 1; k < N; k++) {
					sum = arr[i] + arr[j] + arr[k];
					System.out.println(i + " " + j + " " + k);
					if (sum <= M) { // M 이하인 sum 중에서
						max = Math.max(sum, max); // sum 중 최대의 값
					}
				} // end of k
			} // end of j
		} // end of i
		System.out.println(max);
	}
}
