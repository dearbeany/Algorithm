package boj.bronze;

import java.util.Scanner;

public class _25756_방어율무시계산 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(); // 물약 개수
		double v = 0; // 현재 방어율무시

		int[] potion = new int[n];

		for (int i = 0; i < n; i++) {
			potion[i] = sc.nextInt();
		}
//		System.out.println(Arrays.toString(potion));

		for (int i = 0; i < n; i++) {
			v = 1 - (1 - v) * (1 - potion[i] * 0.01);
			System.out.println(v * 100);

//			System.out.println(Math.round(v * 1000000) / 10000.0);
		}
	}
}
