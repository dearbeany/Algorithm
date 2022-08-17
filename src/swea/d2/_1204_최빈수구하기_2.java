package swea.d2;

import java.util.Scanner;

public class _1204_최빈수구하기_2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int tc = 1; tc <= 10; tc++) {
			sc.nextInt();

			int[] arr = new int[101];

			for (int i = 0; i < 1000; i++) {
				int score = sc.nextInt();
				arr[score]++;
			}

			int maxVal = 0;
			int idx = 0;
			for (int i = 0; i < 101; i++) {
				if (arr[i] >= maxVal) {
					maxVal = arr[i];
					idx = i;
				}
			}
			System.out.printf("#%d %d\n", tc, idx);
		}
	}
}
