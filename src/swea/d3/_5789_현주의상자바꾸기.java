package swea.d3;

import java.util.Scanner;

public class _5789_현주의상자바꾸기 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt(); // 상자의 개수
			int Q = sc.nextInt(); // 몇 회 실시하는지

			int[] box = new int[N + 1];
			for (int i = 1; i <= Q; i++) {
				int L = sc.nextInt(); // L번 상자
				int R = sc.nextInt(); // R번 상자

				for (int j = L; j <= R; j++) {
					box[j] = i;
				}
			}

			System.out.printf("#%d ", tc);
			for (int i = 1; i < N + 1; i++) {
				System.out.print(box[i] + " ");
			}
			System.out.println();
		}
	}
}
