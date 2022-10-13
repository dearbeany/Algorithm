package swea.d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * nxm 격자판 '#' : 검정 , '.' : 흰 , '?' : 검흰   
 * ?칸 색칠 정해지지 않았을 때, 인접한 두 칸이 항상 다른 색 가능한지? 
 */
public class _14413_격자판칠하기 {
	static int n, m;
	static int[][] map;
	static int[][] drc = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());

			map = new int[n][m];
			// 검 1 흰 -1 미정 0
			for (int i = 0; i < n; i++) {
				String str = br.readLine();
				for (int j = 0; j < m; j++) {
					char c = str.charAt(j);
					map[i][j] = c == '#' ? 1 : c == '.' ? -1 : 0;
				}
			}
			boolean flag1 = false, flag2 = false;
			String res = "possible";
			loop: for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					if (map[i][j] == 1) { // 검이면
						flag1 = paintToWhite(i, j);
						if (!flag1) {
							res = "impossible";
							break loop;
						}
					}
					if (map[i][j] == -1) { // 흰이면
						flag2 = paintToBlack(i, j);
						if (!flag2) {
							res = "impossible";
							break loop;
						}

					}
				}
			}

			System.out.printf("#%d %s\n", tc, res);
		}
	}

	private static boolean paintToBlack(int r, int c) {
		for (int d = 0; d < 4; d++) {
			int nr = r + drc[d][0];
			int nc = c + drc[d][1];

			if (!is_in(nr, nc) || map[nr][nc] == 1) {
				continue;
			}
			// 이미 인접한 곳이 흰색 이면 false
			if (map[nr][nc] == -1) {
				return false;
			}
			map[nr][nc] = 1;
		}
		return true;

	}

	// 검정일 때 색칠
	private static boolean paintToWhite(int r, int c) {

		for (int d = 0; d < 4; d++) {
			int nr = r + drc[d][0];
			int nc = c + drc[d][1];

			if (!is_in(nr, nc) || map[nr][nc] == -1) {
				continue;
			}
			// 이미 인접한 곳이 검정이면 false
			if (map[nr][nc] == 1) {
				return false;
			}
			map[nr][nc] = -1;
		}
		return true;
	}

	private static boolean is_in(int r, int c) {
		return (r >= 0 && c >= 0 && r < n && c < m);
	}

	public static void print() {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
	}
}
