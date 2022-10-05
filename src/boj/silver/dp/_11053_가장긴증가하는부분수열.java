package boj.silver.dp;

import java.util.Scanner;

public class _11053_가장긴증가하는부분수열 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(); // 수열의 크기
		int[] arr = new int[n + 1]; // 수열
		int[] dp = new int[n + 1]; // n번째까지의 가장 긴 증가하는 부분수열의 길이

		for (int i = 1; i <= n; i++) {
			arr[i] = sc.nextInt();
		}

		dp[1] = 1;

		for (int i = 2; i <= n; i++) {
			dp[i] = 1;
			for (int j = 1; j < i; j++) { // 이전까지의 원소들과 비교해야한다
				if (arr[i] > arr[j] && dp[i] <= dp[j]) {
					dp[i] = dp[j] + 1;
				}
			}
		}
//		System.out.println(Arrays.toString(dp));
		int max = -1;
		for (int i : dp) {
			max = Math.max(i, max);
		}
		System.out.println(max);
	}
}
