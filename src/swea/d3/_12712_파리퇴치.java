package swea.d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _12712_파리퇴치 {

	static int sum1, sum2;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine()); // 테케

		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken()); // 배열의 크기
			int M = Integer.parseInt(st.nextToken()); // 스프레이 분사 범위

			int[][] arr = new int[N][N];
			// + : 상부터 시계방향 (인덱스기준 0~3)
			// x : 시계방향 (4~7)
			int[] dx = { -1, 0, 1, 0, -1, 1, 1, -1 };
			int[] dy = { 0, 1, 0, -1, 1, 1, -1, -1 };

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			sum1 = 0;

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					// + 방향
					int tmp = arr[i][j];
					for (int m = 1; m < M; m++) {
						for (int k = 0; k < 4; k++) {
							int nx = i + m * dx[k];
							int ny = j + m * dy[k];

							if (nx < 0 || nx >= N || ny < 0 || ny >= N) {
								continue;
							}
							tmp += arr[nx][ny];
						}
					}
					sum1 = Math.max(sum1, tmp);
				} // end of if
			}

			sum2 = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					// + 방향
					int tmp = arr[i][j];
					for (int m = 1; m < M; m++) {
						for (int k = 4; k < 8; k++) {
							int nx = i + m * dx[k];
							int ny = j + m * dy[k];

							if (nx < 0 || nx >= N || ny < 0 || ny >= N) {
								continue;
							}
							tmp += arr[nx][ny];
						}
					}
					sum2 = Math.max(sum2, tmp);
				} // end of if
			}

			System.out.printf("#%d %d\n", tc, Math.max(sum1, sum2));
		} // end of tc

	}
}
