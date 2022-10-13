package swea.d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * 룩은 8x8체스판 위에 같은 행, 열에 있으면 안 됨 
 */
public class _15612_체스판위룩 {
	static int[][] map;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			map = new int[8][8];

			for (int i = 0; i < 8; i++) {
				String str = br.readLine();
				for (int j = 0; j < 8; j++) {
					map[i][j] = str.charAt(j) == '.' ? 0 : 1;
				}
			}
			String res = isRowOk() && isColOk() ? "yes" : "no";
			System.out.printf("#%d %s\n", tc, res);
		}
	}

	public static boolean isRowOk() {
		for (int i = 0; i < 8; i++) {
			int cnt = 0;
			for (int j = 0; j < 8; j++) {
				if (map[i][j] == 1) {
					cnt++;
				}
			}
			if (cnt != 1) {
				return false;
			}
		}
		return true;
	}

	public static boolean isColOk() {
		for (int i = 0; i < 8; i++) {
			int cnt = 0;
			for (int j = 0; j < 8; j++) {
				if (map[j][i] == 1) {
					cnt++;
				}
			}
			if (cnt != 1) {
				return false;
			}
		}
		return true;
	}

	public static void print() {
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
	}
}
