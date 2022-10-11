package swea.d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _2805_농작물수확하기 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			int n = Integer.parseInt(br.readLine());

			int[][] map = new int[n][n];

			for (int i = 0; i < n; i++) {
				String str = br.readLine();
				for (int j = 0; j < n; j++) {
					map[i][j] = str.charAt(j) - '0';
				}
			}

			int sum = 0;
			int st = n / 2, ed = n / 2;

			for (int i = 0; i < n; i++) { // 한 행 씩
				for (int j = st; j <= ed; j++) { // 열의 범위를 조정해서
					sum += map[i][j]; // 더해주자
				}

				if (i < n / 2) { // 윗 배열
					st--; // 시작 줄여주고
					ed++; // 끝 늘려서 열의 범위 키우자
				} else { // 아래 배열
					st++; // 시작 늘리고
					ed--; // 끝 줄여서 열의 범위 줄이자
				}
			}
			System.out.printf("#%d %d\n", tc, sum);
		}
	}
}
