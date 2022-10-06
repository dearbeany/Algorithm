package boj.gold.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _17070_파이프옮기기1 {
	// 파이프 한쪽 긑을 (N,N)으로 이동시키는 방법의 수
	static int N; // 집 크기
	static int[][] arr; // 새 집 격자판
	static int cnt; // 방법 개수

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine()); // 집의 크기

		arr = new int[N + 1][N + 1];

		// 0행과 0열은 사용하지X 1행, 1열부터 시작하기 때문에
		for (int i = 1; i < N + 1; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j < N + 1; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		dfs(1, 2, 0); // (1,2)에서 출발을 기준으로 (x2, y2)만을 고려하도록 한다
		System.out.println(cnt);
	}

	// 파이프가 가로일 때 변화량 (x1, y1) (x2, y2)
	// 가로 : (0,1) (0,1)
	// 대각선 : (0,1) (1,1)

	// 파이프 세로일 때 변화량
	// 세로 : (1,0) (1,0)
	// 대각선 : (1,0) (1,1)

	// 파이프 대각선일 때 변화량
	// 가로 : (1,1) (0,1)
	// 세로 : (1,1) (1,0)
	// 대각선 : (1,1) (1,1)

	private static void dfs(int r, int c, int dir) {
		if (r == N && c == N) { // 행과 열이 (N,N)에 도착하면
			cnt++;
			return;
		}
		switch (dir) {
		case 0: // 가로면
			if (c + 1 <= N && arr[r][c + 1] == 0) { // 가로로 갈 수 있으면
				dfs(r, c + 1, 0);
			}
			if (r + 1 <= N && c + 1 <= N && arr[r + 1][c + 1] == 0 && arr[r + 1][c] == 0 && arr[r][c + 1] == 0) { // 대각선으로
				dfs(r + 1, c + 1, 2); // 대각선 이동
			}
			break;
		case 1: // 세로면
			if (r + 1 <= N && arr[r + 1][c] == 0) { // 세로로 갈 수 있으면
				dfs(r + 1, c, 1);
			}
			if (r + 1 <= N && c + 1 <= N && arr[r + 1][c + 1] == 0 && arr[r + 1][c] == 0 && arr[r][c + 1] == 0) { // 대각선으로
				dfs(r + 1, c + 1, 2); // 대각선 이동
			}

			break;
		case 2: // 대각선이면
			if (c + 1 <= N && arr[r][c + 1] == 0) { // 가로로 갈 수 있으면
				dfs(r, c + 1, 0);
			}
			if (r + 1 <= N && arr[r + 1][c] == 0) { // 세로로 갈 수 있으면
				dfs(r + 1, c, 1);
			}
			if (r + 1 <= N && c + 1 <= N && arr[r + 1][c + 1] == 0 && arr[r + 1][c] == 0 && arr[r][c + 1] == 0) { // 대각선으로
				dfs(r + 1, c + 1, 2); // 대각선 이동
			}
			break;
		}
	}

}
