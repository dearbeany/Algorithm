package swea.d2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * 1. 규칙 찾기
 * 2. 델타 사용 -> 우하좌상
 * - 맵 밖을 벗어나거나 map에 숫자가 채워져있으면 방향전환 하자
 * - 마지막 숫자를 찍는 순간 멈추도록 한다 
 */
public class _1954_달팽이숫자2 {

	// 우 하 좌 상
	static int[][] drc = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };
	static int[][] map;
	static int N;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine()); // 달팽이 크기

			map = new int[N][N];
			fill(0, 0, 0);
			print(map);
		}

	}

	public static void print(int[][] arr) {
		for (int[] aa : arr) {
			for (int a : aa) {
				System.out.print(a + " ");
			}
			System.out.println();
		}
	}

	public static void fill(int r, int c, int dir) {
		int i = 1;
		int nr, nc;
		while (i != N * N) {
			switch (dir) {
			case 0: // 우
				nr = r + drc[0][0];
				nc = c + drc[0][1];

				if (is_in(r, c)) {
					map[nr][nc] = i;
				} else {
					dir = 1;
				}
				i++;
			case 1: // 하
				nr = r + drc[1][0];
				nc = c + drc[1][1];

				if (is_in(r, c)) {
					map[nr][nc] = i;
				} else {
					dir = 2;
				}
				i++;
			case 2: //
				nr = r + drc[2][0];
				nc = c + drc[2][1];

				if (is_in(r, c)) {
					map[nr][nc] = i;
				} else {
					dir = 3;
				}
				i++;
			case 3: //
				nr = r + drc[3][0];
				nc = c + drc[3][1];

				if (is_in(r, c)) {
					map[nr][nc] = i;
				} else {
					dir = 0;
				}
				i++;
			}
		}
	}

	public static boolean is_in(int r, int c) {
		return (r >= 0 && c >= 0 && r < N && c < N);
	}

}
