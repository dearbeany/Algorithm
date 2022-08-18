package boj.bronze;

import java.util.Scanner;

public class _2798_블랙잭 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt(); // 숫자의 개수
		int M = sc.nextInt(); // 합

		int[] arr = new int[N];

		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}

		int result = 0;

		for (int i = 0; i < N - 2; i++) {
			for (int j = i + 1; j < N - 1; j++) {
				for (int k = j + 1; k < N; k++) {

					int sum = arr[i] + arr[j] + arr[k]; // 세 카드의 합

					// 세카드의 합이 M과 같을 때
					if (sum == M) {
						result = sum;
						break;
					}

					// 세카드의 합이 M보다 작을 때
					if (sum < M) {
						// 이전 저장한 값이 더 크면 새로운 sum으로 지정
						if (result < sum) {
							result = sum;
						}
					}
				} // end of for k
			} // end of for j
		} // end of for i
		System.out.println(result);

	}
}
