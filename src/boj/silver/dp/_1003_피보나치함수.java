package boj.silver.dp;

import java.util.Scanner;

public class _1003_피보나치함수 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int tc = 0; tc < T; tc++) {
			int[] zerofibo = new int[41]; // n번째에서 0의 연산횟수를 담는 배열
			int[] onefibo = new int[41]; // n번째 1의 연산횟수를 담는 배열

			zerofibo[0] = onefibo[1] = 1; // zerofibo는 0을 호출 시 1번 연산, onefibo는 1을 호출 시 1번 연산
			zerofibo[1] = onefibo[0] = 0;
			int n = sc.nextInt();

			for (int i = 2; i <= n; i++) {
				zerofibo[i] = zerofibo[i - 1] + zerofibo[i - 2];
				onefibo[i] = onefibo[i - 1] + onefibo[i - 2];

			}
			System.out.println(zerofibo[n] + " " + onefibo[n]);
		}
	}

}
