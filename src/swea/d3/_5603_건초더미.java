package swea.d3;

import java.util.Scanner;

public class _5603_건초더미 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {
			int n = sc.nextInt(); // 건초더미 개수

			int[] hays = new int[n]; // 건초더미들
			int height = 0; // 모두 같은 높이

			for (int i = 0; i < n; i++) {
				hays[i] = sc.nextInt();
				height += hays[i];
			}
			height /= n;
			int cnt = 0; // 모두 같은 높이로 만들기 위한 최소 이동 횟수
			for (int i = 0; i < n; i++) {
				if (hays[i] > height) {
					cnt += hays[i] - height;
				}
			}
			System.out.printf("#%d %d\n", tc, cnt);

		}
	}
}
