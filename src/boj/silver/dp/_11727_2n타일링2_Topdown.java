package boj.silver.dp;

import java.util.Arrays;
import java.util.Scanner;

/*
 * 2xn 직사각형을 1x2, 2x1, 2x2 타일로 채우는 방법?
 * 단, 방법의 수를 10007로 나눈 나머지를 출력 
 * 
 * 1. dp를 사용하여 풀이하자 -> 규칙을 찾는다 
 * 2. 점화식 f(n) = f(n-1) + 2*f(n-2)
 */
public class _11727_2n타일링2_Topdown {

	static int[] memo = new int[1001];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();

		Arrays.fill(memo, -1);
		memo[1] = 1;
		memo[2] = 3;

		int res = dp(N);
		System.out.println(res);
	}

	private static int dp(int n) {
		if (memo[n] == -1) {
			memo[n] = (dp(n - 1) + 2 * dp(n - 2)) % 10007;
		}
		return memo[n];
	}

}
