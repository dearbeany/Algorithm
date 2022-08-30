package swea.d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _11315_오목판정 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine()); // 테케

		for (int tc = 1; tc <= T; tc++) { // 4
			int N = Integer.parseInt(br.readLine()); // 오목판 크기 5
			String res = "NO";

			int[][] arr = new int[N][N]; // 오목판

			// 동, 남동, 남, 남서
			// 우방향부터 45도씩 시계방향
			int[] dx = { 0, 1, 1, 1 };
			int[] dy = { 1, 1, 0, -1 };

			for (int i = 0; i < N; i++) {
				String str = br.readLine();
				for (int j = 0; j < N; j++) {
					arr[i][j] = (str.charAt(j) == 'o') ? 1 : 0;
				}
			}

			// 오목 탐색
			// 가로 직선 : 우(0,1) 이동
			// 한 행에 1이 연속으로 5개 나와야 함

			// 세로 직선 : 하(1,0) 이동
			// 한 열에 1이 연속으로 5개 나와야 함

			// 대각선 직선 : (1,1) (1,-1) 이동

			Loop: for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {

					if (arr[i][j] == 1) {
						for (int k = 0; k < 4; k++) {
							int nx = i;
							int ny = j;
							int cnt = 1;

							while (true) {
								nx = nx + dx[k];
								ny = ny + dy[k];

								if (nx < 0 || nx >= N || ny < 0 || ny >= N) {
									break;
								}
								if (arr[nx][ny] == 0) {
									break;
								}
								cnt++;

								if (cnt == 5) {
									res = "YES";
									break Loop;
								}

							}
						}

					}
				}
			} // end of Loop

			System.out.printf("#%d %s\n", tc, res);
		} // end of tc
	}
}
