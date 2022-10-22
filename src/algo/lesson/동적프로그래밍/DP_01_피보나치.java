package algo.lesson.동적프로그래밍;

import java.util.Arrays;
import java.util.Scanner;

public class DP_01_피보나치 {
	static long callCnt1, callCnt2;
	static int N;
	static long[] memo;

	static long fibo1(int n) {
		callCnt1++;
		if (n < 2)
			return n;
		return fibo1(n - 2) + fibo1(n - 1);
	}

	// Top-down 하향식
	static long fibo2(int n) {
		callCnt2++;

		if (memo[n] == -1) // n에 대해 계산한 적이 없다면
			memo[n] = fibo2(n - 2) + fibo2(n - 1);

		return memo[n];
	}

	// Bottom-up 상향식
	static long fibo3(int n) {
		long[] dp = new long[n + 1];
		dp[0] = 0;
		dp[1] = 1;
		for (int i = 2; i <= n; i++)
			dp[n] = dp[n - 2] + dp[n - 1];
		return dp[n];
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		memo = new long[N + 1];
		// 0번째는 0, 1번째는 1
		Arrays.fill(memo, -1);
		memo[0] = 0;
		memo[1] = 1;
//		System.out.println("fibo1 : " + fibo1(N));
//		System.out.println("fibo1 cnt : " + callCnt1);
//		System.out.println("======================");
		System.out.println("fibo2 : " + fibo2(N));
		System.out.println("fibo2 cnt : " + callCnt2);
	}
}
