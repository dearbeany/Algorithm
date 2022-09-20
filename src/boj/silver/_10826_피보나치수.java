package boj.silver;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigInteger;

/*
 * n이 최대 10,000이며 피보나치수를 구해야 하기 때문에 
 * int, long일 경우 오버플로우가 발생한다. 따라서 BigInteger를 사용해야 한다 
 */
public class _10826_피보나치수 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());

		if (n <= 1) {
			bw.write(n + "\n");
		} else {
			BigInteger[] dp = new BigInteger[n + 1];

			dp[0] = BigInteger.ZERO;
			dp[1] = BigInteger.ONE;

			for (int i = 2; i <= n; i++) {
				dp[i] = dp[i - 2].add(dp[i - 1]);
			}
			bw.write(dp[n] + "\n");
		}
		bw.flush();
		bw.close();
	}

	// 시간 초과
//	private static int fibo(int n) {
//		if (n <= 1) {
//			return n;
//		}
//		return fibo(n - 1) + fibo(n - 2);
//	}

}
