package swea.d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _5215_햄버거다이어트_백트래킹 {

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
			solve(0, 0, 0);
			System.out.printf("#%d %d\n", tc, res);
		} // end of tc
	}

	// 상태공간트리를 이용한다
	// idx번째 원소를 더할지 말지 기로. 현재까지 더한 tSum, 현재까지 더한 kSum
	static void solve(int idx, int tSum, int kSum) {
		// 이미 칼로리가 오버됐다면, 더이상의 재료를 고를 필요가 없다 (Prunning)
		// 즉 1000이 넘으면 상태공간트리에서 가지치기를 한다
		if (kSum > L) {
			return;
		}
		if (idx == N) { // 끝까지 다 검사 했다면
			if (kSum <= L) { // 제한칼로리 이하에서
				res = Math.max(res, tSum); // 최대 맛의 합을 구한다
			}
			return;
		}

		solve(idx + 1, tSum + scores[idx], kSum + kcals[idx]); // 다음 재료를 선택한다
		solve(idx + 1, tSum, kSum); // 다음 재료를 선택하지 않는다
	}

}
