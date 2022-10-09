package algo.lesson.dp;

import java.util.Scanner;

public class DP_02_Knapsack {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// 아이템의 개수, 최대 가방 무게
		int N = sc.nextInt();
		int W = sc.nextInt();
		int[] weights = new int[N + 1];
		int[] profits = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			weights[i] = sc.nextInt();
			profits[i] = sc.nextInt();
		}
		int[][] dp = new int[N + 1][W + 1];
		// 아이템을 하나도 고려하지 않는 0번행은 모두 0으로 초기화.. 되있으니 생략.
		// 모든 아이템에 대해서 한번씩 처리
		for (int i = 1; i <= N; i++) {
			// 각각의 아이템별로, 모든 무게에 대해 최적해를 갱신한다.
			for (int w = 0; w <= W; w++) {
				// 현재 아이템의 무게가, 고려하는 배낭의 무게 보다 작거나 같다면
				if (weights[i] <= w) {
					// 아이템을 담을라면 담을 수 있음..
					// 현재 아이템을 담을 수 있는 상태의 이전 최적해 + 현재 아이템의 가치
					// dp[i-1][ w - weights[i] ] + profits[i]
					// 와
					// 이전에 알려진 w무게의 최적해
					// dp[i-1][w]
					// 저놈들 중 더 좋은놈을 현재 최적해로 갱신
					dp[i][w] = Math.max(dp[i - 1][w], dp[i - 1][w - weights[i]] + profits[i]);

				}
				// 아니라면, 이전의 최적해가 이번의 최적해
				else
					dp[i][w] = dp[i - 1][w];
			}
			System.out.println(dp[N][W]);
		}
	}
}
