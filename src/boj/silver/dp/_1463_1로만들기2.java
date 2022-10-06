package boj.silver.dp;

import java.util.Scanner;

/*
 * 3으로 나눠 떨어지면 3으로 나누기 
 * 2로 나눠 떨어지면 2로 나누기 
 * 1빼기 
 * 
 * 위 연산 3개로 최소연산횟수?
 */
public class _1463_1로만들기2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(); // 정수

		int[] dp = new int[n + 1];

		dp[1] = 0;
		for (int i = 2; i <= n; i++) {
			dp[i] = dp[i - 1] + 1;
			if (i % 3 == 0) {
				dp[i] = Math.min(dp[i / 3] + 1, dp[i]);
			}
			if (i % 2 == 0) {
				dp[i] = Math.min(dp[i / 2] + 1, dp[i]);
			}
		}
		System.out.println(dp[n]);
	}
}
