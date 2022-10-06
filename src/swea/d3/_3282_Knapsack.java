package swea.d3;

import java.util.Scanner;

/*
 * 물건 몇 개 선택해 최대가치?
 * 단, 부피 합 <= k
 */
public class _3282_Knapsack {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt(); // 물건 개수
			int V = sc.nextInt(); // 최대 부피

			int[] vols = new int[N + 1]; // 부피
			int[] vals = new int[N + 1]; // 가치

			for (int i = 1; i <= N; i++) {
				vols[i] = sc.nextInt(); // i번 물건 부피
				vals[i] = sc.nextInt(); // i번 물건 가치
			}
			int[][] dp = new int[N + 1][V + 1]; // n개까지의 최대 가치

			// 아이템 하나도 고려하지 않는 0번행은 모두 0이므로 생략
			// 모든 아이템에 대해 한 번씩 처리
			for (int i = 1; i <= N; i++) {
				// 각 아이템 별로 모든 부피에 대해 최적해를 갱신
				for (int v = 0; v <= V; v++) {
					if (vols[i] <= v) { // 현재 아이템의 부피 <= 고려하는 배낭무게
						dp[i][v] = Math.max(dp[i - 1][v], dp[i - 1][v - vols[i]] + vals[i]);
					} else { // 아니면 이전의 최적해가 현재 최적해로 갱신
						dp[i][v] = dp[i - 1][v];
					}
				}
			}
			System.out.printf("#%d %d\n", tc, dp[N][V]);
		}
	}
}
