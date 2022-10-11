package im;

import java.util.Scanner;

// 2. 델타 사용 -> 우하좌상
// - 맵 밖을 벗어나거나 map에 숫자가 채워져있으면 방향전환 하자
// - 마지막 숫자를 찍는 순간 멈추도록 한다

public class _1954_달팽이숫자 {
	static int[][] drc = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };
	static int[] dir = { 0, 1, 2, 3 };
	static int n;

	public static void main(String[] args) {
		// 정수 n크기의 달팽이 출력하기
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {
			n = sc.nextInt();
			// 달팽이 숫자 출력하자

			int[][] map = new int[n][n];

			int num = 1;
			int r = 0, c = 0, i = 0;

			while (num != n * n + 1) {
				// 다음으로 갈 위치
				int nr = r + drc[dir[i]][0];
				int nc = c + drc[dir[i]][1];

				// 다음위치가 범위 벗어나거나 이미 채워져있으면 방향 변경
				if (!is_in(nr, nc) || map[nr][nc] != 0) {
					i = (i + 1) % 4;
					nr = r + drc[dir[i]][0];
					nc = c + drc[dir[i]][1];
				}

				// 현재 위치에 값 채우고, 다음 위치로 이동하자
				map[r][c] = num++;
				r = nr;
				c = nc;
			}
			System.out.printf("#%d\n", tc);
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

	public static boolean is_in(int r, int c) {
		return (r >= 0 && c >= 0 && r < n && c < n);
	}
}
