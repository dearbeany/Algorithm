package boj.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * 나이트투어 경로 주어질 때 A~F, 1~6을 모두 방문했는지 여부? 
 */
public class _1331_나이트투어 {
	static int[][] map;
	static int[][] drc = { { -2, 1 }, { -1, 2 }, { 1, 2 }, { 2, 1 }, { 2, -1 }, { 1, -2 }, { -1, -2 }, { -2, -1 } };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		map = new int[6][6]; // 행은 알파벳 A~F, 열은 숫자 1~6
		// A = 0, B = 1, C = 2 ...
		for (int i = 1; i <= 36; i++) {
			String str = br.readLine();
			int alpha = str.charAt(0) - 65;
			int num = str.charAt(1) - 49;
			map[alpha][num] = i;
		}

		// 모든 칸을 방문하지 않았다면 불가
		String res = "Valid";
		loop: for (int i = 0; i < 6; i++) {
			for (int j = 0; j < 6; j++) {
				if (map[i][j] == 0) {
					res = "Invalid";
					break loop;
				}
			}
		}
		// 나이트가 다음칸을 이동할 수 없으면 불가
		loop: for (int i = 0; i < 6; i++) {
			for (int j = 0; j < 6; j++) {
				if (!isMovable(i, j)) {
					res = "Invalid";
					break loop;
				}
			}
		}

//		print();
		System.out.println(res);
	}

	private static void print() {
		for (int i = 0; i < 6; i++) {
			for (int j = 0; j < 6; j++) {
				System.out.format("%02d ", map[i][j]);
			}
			System.out.println();
		}
	}

	// 현재 있는 곳으로부터 팔방탐색하면서 다음칸으로 이동할 수 있는지
	private static boolean isMovable(int r, int c) {
		for (int i = 0; i < 8; i++) {
			int nr = r + drc[i][0];
			int nc = c + drc[i][1];

			// 범위 초과 시 패스
			if (!is_in(nr, nc)) {
				continue;
			}
			if (map[r][c] == 36) { // 마지막 숫자가
				if (map[nr][nc] == 1) { // 처음으로 돌아올 수 있으면 ok
					return true;
				}
			} else {
				if (map[nr][nc] == map[r][c] + 1) {
					return true;
				}
			}
		}
		return false;
	}

	private static boolean is_in(int r, int c) {
		return r >= 0 && c >= 0 && r < 6 && c < 6;
	}

}
