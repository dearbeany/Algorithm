package swea.d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _5215_햄버거다이어트_비트마스킹 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken()); // 재료의 수
			int L = Integer.parseInt(st.nextToken()); // 제한 칼로리

			// 점수 칼로리
			int[] scores = new int[N];
			int[] kcals = new int[N];

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				scores[i] = Integer.parseInt(st.nextToken());
				kcals[i] = Integer.parseInt(st.nextToken());
			}

			int res = 0; // 가장 scoreSum 높은 조합의 햄버거 점수
			int scoreSum, kcalSum; // 점수조합, 칼로리 조합

			// i는 부분집합. 0부터 2n-1까지 검사
			for (int i = 0; i < (1 << N); i++) {
				// 부분집합 바뀌면 매번 새로 검사해야 함
				scoreSum = 0;
				kcalSum = 0;

				for (int j = 0; j < N; j++) {
					// j번째 원소 있으면
					if ((i & (1 << j)) > 0) {
						scoreSum += scores[j];
						kcalSum += kcals[j];
					}

					if (kcalSum > L) { // 칼로리 조합이 제한 칼로리보다 크면
						break;
					}

					if (scoreSum > res) { // 점수조합의 최대를 구한다
						res = scoreSum;
					}
				}
			} // end of for
			System.out.printf("#%d %d\n", tc, res);
		} // end of tc
	}

}
