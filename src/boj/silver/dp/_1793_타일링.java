package boj.silver.dp;

import java.math.BigInteger;
import java.util.Scanner;

/*
 * 2xn직사각형을 2x1과 2x2 타일로 채우는 방법의 수?
 * 
 * 1. dp를 사용하여 풀이 -> 규칙을 발견했다 
 * 2. 점화식 f(n) = f(n-1) + 2*f(n-2)
 * 3. 단, 큰 수임을 주의하여 BigIntger를 사용한다 
 * 
 */
public class _1793_타일링 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		BigInteger[] memo = new BigInteger[251];
		memo[0] = BigInteger.ONE; // 0일 때 경우의 수 1로 해줘야 한다
		memo[1] = BigInteger.ONE;
		memo[2] = BigInteger.valueOf(3);

		for (int i = 3; i < memo.length; i++) {
//			memo[i] = memo[i - 1] + 2 * memo[i - 2];
			memo[i] = memo[i - 1].add(memo[i - 2].multiply(BigInteger.valueOf(2)));
		}

		while (sc.hasNext()) {
			int n = sc.nextInt();
			System.out.println(memo[n]);
		}
	}
}
