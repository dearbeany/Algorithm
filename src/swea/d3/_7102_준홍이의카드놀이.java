package swea.d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 1~N번, 1~M번 카드 중 하나씩 골랐을 때
 * N+M의 결과로 등장할 확률이 가장 많은 숫자?
 * 
 */
public class _7102_준홍이의카드놀이 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());

			int N = Integer.parseInt(st.nextToken()); // 1~N번 카드
			int M = Integer.parseInt(st.nextToken()); // 1~M번 카드

			// 1~N, 1~M까지의 숫자에서 하나씩 골라서 더한다
			// 최소는 2, 최대는 N+M
			int sum = 0;
			int[] counts = new int[N + M + 1];

			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= M; j++) {
					sum = i + j;
					counts[sum]++;
				}
			}

			int max = 0;
			StringBuilder sb = new StringBuilder();

			for (int i = 0; i < counts.length; i++) {
				if (counts[i] >= max) {
					max = counts[i];
				}
			}

			for (int i = 0; i < counts.length; i++) {
				if (counts[i] == max) {
					sb.append(i + " ");
				}
			}

			System.out.printf("#%d %s\n", tc, sb);
		}
	}
}
