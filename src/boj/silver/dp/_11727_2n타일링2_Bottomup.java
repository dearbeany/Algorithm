package boj.silver.dp;

import java.util.Scanner;

/*
 * 2xn 직사각형을 1x2, 2x1, 2x2 타일로 채우는 방법?
 * 단, 방법의 수를 10007로 나눈 나머지를 출력 
 * 
 * 1. dp를 사용하여 풀이하자 -> 규칙을 찾는다 
 * 2. 점화식 f(n) = f(n-1) + 2*f(n-2)
 */
public class _11727_2n타일링2_Bottomup {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		int[] memo = new int[1001];
		memo[1] = 1;
		memo[2] = 3;

		for (int i = 3; i <= n; i++) {
			memo[i] = (memo[i - 1] + 2 * memo[i - 2]) % 10007;
		}

		System.out.println(memo[n]);
	}

}
