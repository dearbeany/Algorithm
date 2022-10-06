package boj.silver.dp;

import java.util.Scanner;

/*
 * 연속된 몇 개 수 선택해 구할 수 있는 최대 합 
 */
public class _1912_연속합 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(); // 정수 개수

		int[] arr = new int[n];
		int[] dp = new int[n];

		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}

		dp[0] = (arr[0] > 0) ? arr[0] : 0;
		for (int i = 1; i < n; i++) {
			if (dp[i - 1] + arr[i] >= dp[i]) {
				dp[i] = dp[i - 1] + arr[i];
			}
		}

		int res = Integer.MIN_VALUE, max = Integer.MIN_VALUE;
		for (int i : dp) {
			res = Math.max(i, res);
		}

		// 첫 원소가 음수일 경우 합을 0으로 세팅 해줬다
		// 그래서 arr이 모두 음수일 경우에 dp가 죄다 0으로 초기화됨 ...
		// 이럴 경우를 대비해 arr에서 가장 큰 원소를 고르자
		for (int i : arr) {
			max = Math.max(i, max);
		}

		res = (res == 0) ? max : res;
		System.out.println(res);
	}

}
