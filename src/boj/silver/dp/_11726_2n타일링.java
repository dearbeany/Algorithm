package boj.silver.dp;

import java.util.Arrays;
import java.util.Scanner;

/*
 * 2xn크기의 직사각형을 1x2, 2x1 타일링로 채우는 방법의 수 
 * 
 * 1. dp를 사용하여 풀이 -> 규칙 : 피보나치 
 * 2. 단, 10007로 나눈 나머지를 출력해야한다 memo배열을 구할 때 나누어 저장한다 
 * 3. Top-down 하향식을 사용함 
 */
public class _11726_2n타일링 {
	static int N;
	static long[] memo = new long[1001];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();

		Arrays.fill(memo, -1);
		memo[1] = 1;
		memo[2] = 2;

		long res = dp(N);
		System.out.println(res);

	}

	private static long dp(int n) {
		if (memo[n] == -1) {
			memo[n] = (dp(n - 2) + dp(n - 1)) % 10007;
		}
		return memo[n];
	}
}
