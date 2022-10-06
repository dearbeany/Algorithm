package boj.silver.dp;

import java.util.Scanner;

public class _1003_피보나치함수2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 0; tc < T; tc++) {
			int n = sc.nextInt();
			int[] zfibo = new int[41]; // 0호출 연산횟수가 저장
			int[] ofibo = new int[41]; // 1호출 연산횟수가 저장

			zfibo[0] = ofibo[1] = 1;
			zfibo[1] = ofibo[0] = 0;

			for (int i = 2; i <= n; i++) {
				zfibo[i] = zfibo[i - 1] + zfibo[i - 2];
				ofibo[i] = ofibo[i - 1] + ofibo[i - 2];
			}
			System.out.println(zfibo[n] + " " + ofibo[n]);
		}
	}
}
