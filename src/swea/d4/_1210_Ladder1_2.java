package swea.d4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _1210_Ladder1_2 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		for (int tc = 1; tc <= 10; tc++) {
			int testNum = Integer.parseInt(br.readLine());

			// 입력파일 이차원 배열에 저장하기
			int[][] arr = new int[100][100];
			for (int i = 0; i < 100; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < 100; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			// 도착시점(2)을 찾아서 start할 곳 찾기
			int row = 99;
			int col = 0;
			for (int j = 0; j < 100; j++) {
				if (arr[row][j] == 2) {
					col = j;
				}
			}

			// 상 좌 우
//			int[] dr = { -1, 0, 0 };
//			int[] dc = { 0, -1, 1 };

			// 이차원 배열의 가장 밑(99,0)에서 출발하여 위로 이동
			while (row > 0) {

				if (((col - 1) >= 0) && arr[row][col - 1] == 1) { // 좌가 1이면 좌로 이동
					col--;
				} else if (((col + 1) < 100) && arr[row][col + 1] == 1) { // 우가 1이면 우로 이동
					col++;
				} else { // 좌도 우도 1이 아니면 상으로 이동
					row--;
				}
			}
			System.out.printf("#%d %d\n", testNum, col);

		}

	}
}
