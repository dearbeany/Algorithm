package swea.d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _1860_진기의최고급붕어빵2 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine()); // 테스트 케이스

		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken()); // 붕어빵 쿨타임
			int K = Integer.parseInt(st.nextToken()); // 붕어빵 개수

			int[] time = new int[11112]; // 사람수만큼 사람들의 도착시간을 담은 배열
			st = new StringTokenizer(br.readLine());

			for (int i = 0; i < N; i++) {
				int n = Integer.parseInt(st.nextToken()); // 도착시간
				time[n]++;
			}

			int bread = 0;
			String ans = "Possible";

			for (int i = 0; i < time.length; i++) {
				if (i != 0 && i % M == 0) {
					bread += K;
				}
				bread -= time[i];

				if (bread < 0) {
					ans = "Impossible";
					break;
				}
			}

			System.out.printf("#%d %s\n", tc, ans);
		}

	}
}
