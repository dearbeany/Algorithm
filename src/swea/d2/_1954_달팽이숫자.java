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
public class _1954_달팽이숫자 {

	// 우 하 좌 상
	static int[][] drc = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };
	static int[] dir = { 0, 1, 2, 3 };
	static int N;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine()); // 달팽이 크기

			int[][] map = new int[N][N];

			int num = 1; // 1부터 시작
			int r = 0, c = 0, i = 0; // i는 방향, 0인 우부터 시작

			while (num != N * N + 1) { // N*N을 마지막으로 찍고 나옴
				int nr = r + drc[dir[i]][0]; // 다음에 갈 위치
				int nc = c + drc[dir[i]][1];

				if (!is_in(nr, nc) || map[nr][nc] != 0) { // 범위 벗어나거나 이미 채워져있으면
					i = (i == 0) ? 1 : (i == 1) ? 2 : (i == 2) ? 3 : 0;
					// 우(0) -> 하(1) -> 좌(2) -> 상(3)으로 방향 바꿔준다
//					i = (i + 1) % 4; // 나머지 연산으로도 할 수도 ... 
					nr = r + drc[dir[i]][0];
					nc = c + drc[dir[i]][1];
				}
				map[r][c] = num++; // 숫자 채워주고
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
		return (r >= 0 && c >= 0 && r < N && c < N);
	}

}
