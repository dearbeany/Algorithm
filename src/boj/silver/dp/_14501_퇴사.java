package boj.silver.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * T : 상담에 걸리는 시간 
 * P : 상담 수익 
 * (N+1)일자에 퇴사하므로 N일까지 근무. 1~N일까지 근무 할 때 각 일자마다 상담 할지 말지?
 * N일 동안 최대한 많은 상담하려할 때 최대 이익?
 * 
 * dp[i] : i일까지의 최대 이익 
 * i번째 날 일하면 -> i + T[i]번째 날에 돈 받는다 
 * 
 */
public class _14501_퇴사 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine()); // 퇴사일

		int[] T = new int[N + 2]; // 상담 소요 시간
		int[] P = new int[N + 2]; // 상담 수익

		for (int i = 1; i < N + 1; i++) {
			st = new StringTokenizer(br.readLine());
			T[i] = Integer.parseInt(st.nextToken());
			P[i] = Integer.parseInt(st.nextToken());
		}

		int[] dp = new int[N + 2]; // i일까지의 최대 이익

		int max = -1; // 최대이익
		// N+1 번째날까지 봐줘야한다
		for (int i = 1; i < N + 2; i++) {
			for (int j = 1; j < i; j++) {
				// j번째 날 상담 안 함
				dp[i] = Math.max(dp[i], dp[j]);

				// j번째 날 상담하고 j+T[j]번째 날 돈 받음
				if (j + T[j] == i) {
					dp[i] = Math.max(dp[i], dp[j] + P[j]);
				}
			}
			max = Math.max(dp[i], max);
		}
		System.out.println(max);
	}
}
