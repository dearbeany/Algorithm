package sw.d2;

import java.util.Scanner;

public class _1984_중간평균값구하기_카운팅정렬 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {
			int N = 10;
			int[] data = new int[N];

			// 원본 배열
			for (int i = 0; i < N; i++) {
				data[i] = sc.nextInt();
			}

			// 원본 배열 내 최대값 찾기
			int max = 0;
			for (int i = 0; i < N; i++) {
				max = Math.max(data[i], max);
			}

			// 카운트 배열 생성
			int[] counts = new int[max + 1];
			for (int i : data) {
				counts[i]++;
			}

			// 누적합 배열 만들기
			for (int i = 1; i < counts.length; i++) {
				counts[i] += counts[i - 1];
			}

			// 정렬 배열 생성 후 값 넣기
			int[] sorted = new int[N];
			for (int i = N - 1; i >= 0; i--) {
				int idx = --counts[data[i]];
				sorted[idx] = data[i];
			}

			int sum = 0;
			for (int i = 1; i < N - 1; i++) {
				sum += sorted[i];
			}
			double res = sum / 8.0;

			System.out.printf("#%d %d\n", tc, (int) Math.round(res));

		}
	}
}
