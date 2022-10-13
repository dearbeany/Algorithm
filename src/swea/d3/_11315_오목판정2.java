package swea.d3;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _11315_오목판정2 {
	static int n;
	static int[][] map;
	// 좌하, 하, 우하, 우 탐색
	// /대각선, 세로, \대각선, 가로 탐색
	static int[][] drc = { { 1, -1 }, { 1, 0 }, { 1, 1 }, { 0, 1 } };

	public static void main(String[] args) throws NumberFormatException, IOException {
		// 가로, 세로, 대각선 중 하나가 5개 이상 연속한 부분 있는지
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			n = Integer.parseInt(br.readLine());
			map = new int[n][n];

			for (int i = 0; i < n; i++) {
				String str = br.readLine();
				for (int j = 0; j < n; j++) {
					map[i][j] = str.charAt(j) == '.' ? 0 : 1;
				}
			}

			String res = "NO";
			// 가 세 대 중 하나라도 5개 이상이면 바로 리턴
			loop: for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (map[i][j] == 1) {
						if (check(i, j)) {
							res = "YES";
							break loop;
						}
					}
				}
			}
			System.out.printf("#%d %s\n", tc, res);
		}
	}

	private static boolean check(int r, int c) {
		for (int i = 0; i < 4; i++) {
			int cnt = 1;
			int nr = r + drc[i][0];
			int nc = c + drc[i][1];

			while (true) {
				if (!is_in(nr, nc) || map[nr][nc] == 0) {
					break;
				}
				cnt++;
				if (cnt >= 5) {
					return true;
				}
				nr = nr + drc[i][0];
				nc = nc + drc[i][1];

			}
		}
		return false;
	}

	private static boolean is_in(int r, int c) {
		return (r >= 0 && c >= 0 && r < n && c < n);
	}

	public static void print() {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
	}
}
