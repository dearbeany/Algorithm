package swea.d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _13772_폭탄마 {

	static int[][] drc1 = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } }; // +방향
	static int[][] drc2 = { { -1, 1 }, { 1, 1 }, { 1, -1 }, { -1, -1 } }; // X방향
	static int N;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine()); // 테케

		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken()); // 배열 크기
			int P = Integer.parseInt(st.nextToken()); // 폭탄 파워

			int[][] map = new int[N][N];

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			int max = 0, sum = 0;

			// + 방향
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					sum += map[i][j];
					for (int k = 0; k < 4; k++) {
						for (int p = 1; p <= P; p++) {
							int nr = i + p * drc1[k][0];
							int nc = j + p * drc1[k][1];

							if (is_in(nr, nc)) {
								sum += map[nr][nc];
							}

						}
					}
					max = Math.max(max, sum);
					sum = 0;
				}
			}

			// X방향
			int max2 = 0, sum2 = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					sum2 += map[i][j];
					for (int p = 1; p <= P; p++) {
						for (int k = 0; k < 4; k++) {
							int nr = i + p * drc2[k][0];
							int nc = j + p * drc2[k][1];

							if (is_in(nr, nc)) {
								sum2 += map[nr][nc];
							}
						}
					}
					max2 = Math.max(max2, sum2);
					sum2 = 0;
				}
			}

			int res = max > max2 ? max : max2;
			System.out.printf("#%d %d \n", tc, res);
		}
	}

	public static boolean is_in(int r, int c) {
		return (r >= 0 && c >= 0 && r < N && c < N);
	}

	public static void print(int[][] arr) {
		for (int[] aa : arr) {
			for (int a : aa) {
				System.out.print(a + " ");
			}
			System.out.println();
		}
	}

}
