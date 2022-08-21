package swea.d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _7236_저수지물의총깊이 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int T = Integer.parseInt(st.nextToken());

		for (int tc = 1; tc <= T; tc++) { // 4
			int N = Integer.parseInt(br.readLine()); // 저수지 구획의 크기 N 6

			int[][] arr = new int[N + 1][N + 1]; // 저수지

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				// W = 1 G = 0으로 치환
				for (int j = 0; j < N; j++) {
					String token = st.nextToken();
					arr[i][j] = (token.equals("W")) ? 1 : 0;
				}
			} // 저수지 이차원 배열 세팅

			// 팔방탐색
			// 상부터 시계방향
			int[] dx = { -1, -1, 0, 1, 1, 1, 0, -1 };
			int[] dy = { 0, 1, 1, 1, 0, -1, -1, -1 };

			// 팔방 탐색하면서 W의 개수를 카운트
			// 단 W개수 0이면 저수지 깊이는 1임
			int max = 0;

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					int depth = 0; // 저수지의 깊이
					if (arr[i][j] == 1) { // 현재 내가 W일 때 팔방탐색을 시작한다
						for (int k = 0; k < 8; k++) {

							int nx = i + dx[k]; // 다음 x의 위치
							int ny = j + dy[k]; // 다음 y의 위치

							if (nx < 0 || nx >= N || ny < 0 || ny >= N) {
								continue;
							}
							if (arr[nx][ny] == 1) {
								depth++;
							}
						} // end of for 팔방탐색
					} // end of if
					if (depth >= max) {
						max = depth; // 저수지의 최대 깊이
					}

					if (max == 0) { // W개수 0이면 저수지 깊이는 1임
						max = 1;
					}
				}
			}
			System.out.printf("#%d %d\n", tc, max);

		} // end of for tc

	}
}
