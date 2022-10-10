package swea.d3;

import java.util.Scanner;

public class _4299_사랑은타이밍 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		// 11일 11시 11분 부터 ~ D일 H시 M분까지
		// 얼마나 기다렸는지 분 단위 출력
		for (int tc = 1; tc <= T; tc++) {
			int d = sc.nextInt() - 11; // 일
			int h = sc.nextInt() - 11; // 시
			int m = sc.nextInt() - 11; // 분

			int ans = 24 * 60 * d + 60 * h + m;
			ans = ans >= 0 ? ans : -1;
//			int res = 0;
//			if (d < 0) { // 11일 전에 차이면
//				res = -1;
//			} else if (d == 0) { // 11일 당일이면
//				if (h < 0) { // 11시 전에 차이면
//					res = -1;
//				} else if (h == 0) {
//					if (m < 0) { // 11분 전에 차이면
//						res = -1;
//					} else if (m == 0) {
//						res = 0;
//					} else { // 11분 후에 차이면
//						res = m;
//					}
//				} else { // 11시 후에 차이면
//					res = 60 * h + m;
//				}
//			} else { // 11일 후에 차이면
//				res = 24 * 60 * d + 60 * h + m;
//			}

			System.out.printf("#%d %d\n", tc, ans);
		}
	}
}
