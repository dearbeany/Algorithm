package swea.d2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _1979_어디에단어 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken()); // 가로,세로 길이
			int K = Integer.parseInt(st.nextToken()); // 단어의 길이

			int[][] puzzle = new int[N][N];

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					puzzle[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			int res = 0; // K길이의 단어가 들어갈 자리의 수

			// 가로 탐색 (행 우선탐색)
			for (int i = 0; i < N; i++) {
				int cnt = 0; // 1의 개수
				for (int j = 0; j < N; j++) {
					if (puzzle[i][j] == 1) { // 1이면 개수 추가
						cnt++;
					} else { // 0일 경우
						if (cnt == K) { // 그 전까지 1의 개수가 K라면 추가
							res++;
						}
						cnt = 0; // 1의 개수 0으로 초기화
					}
				}
				// 바운더리 케이스 추가
				if (cnt == K) {
					res++;
				}
			}

			// 세로 탐색 (열 우선탐색)
			for (int j = 0; j < N; j++) {
				int cnt = 0; // 1의 개수
				for (int i = 0; i < N; i++) {
					if (puzzle[i][j] == 1) {
						cnt++;
					} else {
						if (cnt == K) { // 단어의 길이만큼 공간 찾으면
							res++;
						}
						cnt = 0; // 1의 개수 0으로 초기화
					}
				}
				if (cnt == K) {
					res++;
				}
			}
			System.out.printf("#%d %d\n", tc, res);

		}
	}
}
