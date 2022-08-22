package swea.d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _1860_진기의최고급붕어빵 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine()); // 테스트 케이스

		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken()); // 붕어빵 만드는 데 소요 시간
			int K = Integer.parseInt(st.nextToken()); // 붕어빵 개수

			int[] arr = new int[N]; // 사람들의 도착시간을 담은 배열
			st = new StringTokenizer(br.readLine());

			for (int i = 0; i < N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			// M = 2, K = 2
			// 3 4 도착
			// 1 2 도착

			// M = 2, K =1
			// 4 2
			// 3 2
			// 붕어빵 만들기도전에 사람이 한명이라도 먼저 도착하면 불가
			// 도착시간이 더 늦어야 함
			Arrays.sort(arr); // 도착시간 정렬

			String res = null;
			boolean flag = false;

			for (int i = 0; i < N; i++) {
				// 도착시간이 < 만드는시간 보다 더 빠르면
				if (arr[i] < M) {
					res = "Impossible";
					break;
				} else {
					while (arr[i] > 0) {
						arr[i] -= M;
						K++;
					}
					K--;
					if (K >= 0) {
						res = "Possible";
					} else {
						res = "Impossible";
					}
					System.out.println(K);
				}

			}
			System.out.printf("#%d %s\n", tc, res);
		}

	}
}
