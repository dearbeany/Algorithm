package boj.silver.dp;

import java.util.Scanner;

/*
 * 계단 오르기 게임에서 얻을 수 있는 점수의 최댓값?
 * - 계단은 한 칸 or 두 칸 이동 가능
 * - 단, 세 칸 연속 선택 불가 
 * - 마지막 칸 무조건 선택 
 * 
 * 1. dp를 사용하여 풀이한다. (memo: n번째 계단에 도착할 때의 최적해)
 * 2. subproblem으로 나누어보자. 마지막 stair[n]은 반드시 포함해야하므로, 바로 이전인 
 * 3. stair[n-1]번째 원소 포함유무로 경우의 수를 나누어 둘 중 더 큰 값을 구한다.
 * - (n-1)번째 원소 포함 O -> memo[n-3] + stair[n-1] + stair[n] 
 * - (n-1)번째 원소 포함 X - > memo[n-2] + stair[n]
 */
public class _2579_계단오르기 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(); // 계단의 개수

		int[] stair = new int[n + 1]; // 1번부터 시작
		for (int i = 1; i < n + 1; i++) {
			stair[i] = sc.nextInt();
		}
		int[] dp = new int[n + 1]; // n번의 계단까지의 최대점수값을 저장

		dp[1] = stair[1];
		if (n >= 2) {
			dp[2] = stair[1] + stair[2];
		}

		for (int i = 3; i <= n; i++) {
			dp[i] = Math.max(dp[i - 3] + stair[i - 1] + stair[i], dp[i - 2] + stair[i]);
		}

		System.out.println(dp[n]);
	}
}
