package sw.d4;

import java.util.Scanner;

public class _1210_Ladder1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = 10;
		int N = 100;

		for (int tc = 1; tc <= T; tc++) {
			int testNum = sc.nextInt();

			int[][] arr = new int[N][N + 2];

			// 이차원 사다리 배열 만들기
			for (int i = 0; i < N; i++) {
				for (int j = 1; j < N + 1; j++) {
					arr[i][j] = sc.nextInt();
				}
			}

			int r = N - 1;
			int c = 0; // 시작지점부터 위로 올라감 (r, c) (99, c)
			for (int j = 1; j < N + 1; j++) {
				if (arr[r][j] == 2) {
					c = j;
				}
			}

			// arr(r,c)에서 시작
			// 상, 좌, 우
//			int[] dr = { -1, 0, 0 }; 
//			int[] dc = { 0, -1, 1 };

			while (r != 0) { // start에서 부터 올라간다 상, 좌, 우 으로만 이동
				// r은 99에서 시작해서 계속해서 상으로 올라감

				// 좌, 우로 갔을 때 값이 0이면 상으로 올라간다
				if (arr[r][c - 1] == 0 && arr[r][c + 1] == 0) {
					r--;
				}
				// 좌로 갔을 때 1이면
				// 좌가 1인 동안 계속해서 좌로 이동
				else if (arr[r][c - 1] == 1) {
					while (arr[r][c - 1] == 1) {
						c--;
					}
					r--;
				}

				// 우로 갔을 때 1이면
				// 우가 1인 동안 계속해서 우로 이동
				else if (arr[r][c + 1] == 1) {
					while (arr[r][c + 1] == 1) {
						c++;
					}
					r--;
				}
			} // end of while
			System.out.printf("#%d %d\n", testNum, c - 1);
		} // end of for tc
	}
}
