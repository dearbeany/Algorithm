package swea.d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _5215_햄버거다이어트_부분조합 {

	static int N, L;
	static int[] scores;
	static int[] kcals;
	static boolean[] check; // i번째 재료를 골랐는지 체크할 배열
	static int res; // 최고 맛 조합의 햄버거 점수

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken()); // 재료의 수
			L = Integer.parseInt(st.nextToken()); // 제한 칼로리

			// 점수, 칼로리에 대한 배열
			scores = new int[N];
			kcals = new int[N];
			check = new boolean[N];
			res = 0;

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				scores[i] = Integer.parseInt(st.nextToken());
				kcals[i] = Integer.parseInt(st.nextToken());
			}
			powerSet(0);
			System.out.printf("#%d %d\n", tc, res);
		} // end of tc
	}

	static void powerSet(int idx) {
		int scoreSum = 0, kcalSum = 0;

		if (idx == N) { // 다 고르면
			for (int i = 0; i < N; i++) {
				if (check[i]) { // 고른 재료들에 한하여
					scoreSum += scores[i];
					kcalSum += kcals[i];
				}
			}
			// kcalSum이 L을 넘지 않는다면
			// 현재 맛의 점수와 res 중 큰 값을 기억한다

			if (kcalSum <= L) {
				res = Math.max(res, scoreSum);
			}
			return;
		}

		check[idx] = true;
		powerSet(idx + 1);
		check[idx] = false;
		powerSet(idx + 1);
	}

}
