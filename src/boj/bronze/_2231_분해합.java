package boj.bronze;

import java.util.Scanner;

public class _2231_분해합 {
	public static void main(String[] args) {
		// N의 분해합 = N + N의 각 자리수의 합
		// M의 분해합이 N이면, M은 N의 생성자
		// N의 가장 작은 생성자?

		// 245 -> 245 + 2 + 4 + 5 = 256(분해합)
		// 245(M)는 256(N)의 생성자
		// 2 + 4 + 5 == 256-245
		// sum == N - M

		// 198 -> 198 + 1 + 9 + 8 = 216 (분해합)
		// N이 주어질 때 N의 가장 작은 생성자?

		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt(); // 216

		// M을 10으로 나눌 때 % 나머지 -> 일의 자리
		// M을 1부터 증가시켜가면서
		// M의 자릿수의 합 == N-M 같으면 break

	}
}
