package boj;

/*
 * 1. 이차원배열을 사방탐색 하면서 둘레를 찾는다.
 * 2. 현재 내가 1이면서 사방이 모두 0이면 둘레
 * 3. 꼭짓점인 경우와 가장자리 카운트에 주의해줘야 함 
 * 4. (3)을 처리하기 싫다면 아예 처음부터 배열을 크게 생성하는 것도 방법임 
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _2567_색종이2_사방탐색 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());
		int[][] arr = new int[100][100];

		for (int tc = 0; tc < T; tc++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());

			for (int i = x; i < x + 10; i++) {
				for (int j = y; j < y + 10; j++) {
					arr[i][j] = 1;
				}
			}
		}

		int len = 0; // 둘레

		// 상 하 좌 우
		int[] dr = { -1, 1, 0, 0 };
		int[] dc = { 0, 0, -1, 1 };

		for (int i = 0; i < 100; i++) {
			for (int j = 0; j < 100; j++) {
				if (arr[i][j] == 1) { // 현위치가 1일 때만
					for (int k = 0; k < 4; k++) {
						int nr = i + dr[k];
						int nc = j + dc[k];

						// 인덱스 범위 넘어가면
						// 가장자리인 경우 +1
						// 꼭짓점인 경우 +2 OR조건 두 번 걸림
						if (nr < 0 || nr >= 100 || nc < 0 || nc >= 100) {
							len++;
							continue;
						}
						// 현 위치가 1이면서 상 하 좌 우가 모두 0이면 둘레길이+1
						if (arr[nr][nc] == 0) {
							len++;
						}
					}
				}
			}
		}
		System.out.println(len);

	}
}
