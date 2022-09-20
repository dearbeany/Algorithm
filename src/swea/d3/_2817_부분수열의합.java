package swea.d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _2817_부분수열의합 {
	static int N, K;
	static int[] arr; // 수열
	static boolean[] checked; // 원소가 선택 됐는지
	static int cnt; // 부분수열로 만들 수 있는 경우의 수

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken()); // 수열의 원소의 개수
			K = Integer.parseInt(st.nextToken()); // 합

			arr = new int[N];
			checked = new boolean[N];

			st = new StringTokenizer(br.readLine());

			for (int i = 0; i < N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}

			cnt = 0;
			powerSet(0);

			System.out.printf("#%d %d\n", tc, cnt);

		}
	}

	private static void powerSet(int idx) {
		// 부분집합이 다 골라지면
		if (idx == N) {
			int sum = 0;
			for (int i = 0; i < N; i++) {
				if (checked[i]) {
					sum += arr[i];
				}
			}
			if (K == sum) {
				cnt++;
			}
			return;
		}
		checked[idx] = true; // idx번째 원소 고름
		powerSet(idx + 1);
		checked[idx] = false; // idx번째 원소 안 고름
		powerSet(idx + 1);
	}
}
