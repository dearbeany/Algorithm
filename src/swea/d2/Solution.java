package swea.d2;

import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {
			int n = sc.nextInt(); // 신입사원의 수
			int kMin = sc.nextInt(); // 분반 별 최소인원 보다 커야 하고
			int kMax = sc.nextInt(); // 분반 별 최대인원 보다 작아야

			int res = Integer.MAX_VALUE; // 인원 차이의 최소값

			int[] scores = new int[n]; // 점수는 1점부터 ~ 100점까지

			for (int i = 0; i < n; i++) {
				scores[i] = sc.nextInt();
			}

			for (int t1 = 1; t1 < 100; t1++) {
				for (int t2 = t1 + 1; t2 <= 100; t2++) {

					int A = 0, B = 0, C = 0;

					for (int i = 0; i < n; i++) {
						if (scores[i] >= t2) {
							A++;
						} else if (scores[i] >= t1) {
							B++;
						} else {
							C++;
						}
					}

					if (A < kMin || B < kMin || C < kMin || A > kMax || B > kMax || C > kMax) {
						continue;
					}

					int max = Math.max(Math.max(A, B), C);
					int min = Math.min(Math.min(A, B), C);
					res = Math.min(max - min, res);

				}
			}
			res = res == Integer.MAX_VALUE ? -1 : res;

			System.out.printf("#%d %d\n", tc, res);
		}
	}
}
