package boj.silver.dp;

import java.util.Scanner;

/*
 * 1. 정수 a에 1을 더한다 
 * 2. 정수 a에 2를 곱한다 
 * 
 * a를 k로 만들기 위한 필요 최소 연산 횟수 
 * 
 */
public class _25418_정수a를k로만들기 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int k = sc.nextInt();

		int[] memo = new int[k - a + 1];

		memo[a] = 0;

		// a가 k가 되면 멈춘다

	}
}
