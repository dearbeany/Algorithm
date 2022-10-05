package boj.silver.dp;

import java.math.BigInteger;
import java.util.Scanner;

/*
 * 1. x가 3으로 나눠 떨어지면 3으로 나누기
 * 2. x가 2로 나눠 떨어지녀 2로 나누기
 * 3. 1 빼기 
 * 
 * n 주어질 때 연산 세 개를 적절히 사용해 1로 만드는 연산횟수의 최솟값 
 */
public class _1463_1로만들기 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		BigInteger[] memo = new BigInteger[n + 1];
		memo[1] = BigInteger.ZERO;

		for (int i = 2; i <= n; i++) {
			memo[i] = memo[i - 1].add(BigInteger.ONE);
			if (i % 3 == 0) {
//				memo[i] = Math.min(memo[i / 3] + 1, memo[i]);
				if (memo[i].compareTo(memo[i / 3].add(BigInteger.ONE)) >= 1) {
					memo[i] = memo[i / 3].add(BigInteger.ONE);
				}

			}
			if (i % 2 == 0) {
//				memo[i] = Math.min(memo[i / 2] + 1, memo[i]);
				if (memo[i].compareTo(memo[i / 2].add(BigInteger.ONE)) >= 1) {
					memo[i] = memo[i / 2].add(BigInteger.ONE);
				}
			}
		}
		System.out.println(memo[n]);
	}
}
