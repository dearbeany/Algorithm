package boj.silver.dp;

import java.util.Scanner;

public class _9095_123더하기 {

	static int n; // 만들어야 하는 합
	static int[] dp = new int[11]; // 인덱스에 해당하는 값을 1,2,3으로 만든 방법의 수가 저장

	public static void main(String[] args) {
		// n을 1,2,3의 합으로 나타내는 방법의 수?
		// n = 1) 1
		// n = 2) 1+1, 2
		// n = 3) 1+1+1, 1+2, 2+1, 3
		// n = 4)
		// n = 1일 때 경우의 수에 3을 더한다) 1+3
		// n = 2일 때 경우의 수에 2를 더한다) 1+1+2, 2+2
		// n = 3일 때 경우의 수에 1을 더한다) 1+1+1+1, 1+2+1, 2+1+1, 3+1
		// 즉, 또 계산되는 걸 막기 위해 중복되는 값들은 배열에 저장해놓고 쓰자
		dp[1] = 1;
		dp[2] = 2;
		dp[3] = 4;

		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int tc = 0; tc < T; tc++) {
			n = sc.nextInt();
			int res = func(n);
			System.out.println(res);
		}
	}

	private static int func(int num) {
		if (dp[num] == 0) { // 값 아직 안 구했으면
			dp[num] = func(num - 3) + func(num - 2) + func(num - 1);
		}
		return dp[num];
	}
}
