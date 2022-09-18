package swea.d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _6730_장애물경주난이도 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int T = Integer.parseInt(st.nextToken()); // 테케

		for (int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine()); // 블록의 개수

			int[] block = new int[N];
			st = new StringTokenizer(br.readLine());

			int maxHigh = 0; // 올라갈 때 가장 심한 높이 변화
			int maxLow = 0; // 내려갈 때 가장 심한 높이 변화

			// 블록값 세팅
			for (int i = 0; i < N; i++) {
				block[i] = Integer.parseInt(st.nextToken());
			}

			for (int i = 0; i < N - 1; i++) {
				int gap = block[i] - block[i + 1];

				// 올라갈 때
				if (gap < 0) {
					gap = Math.abs(gap);
					if (maxHigh < gap) {
						maxHigh = gap;
					}
				}

				// 내려갈 때
				else {
					if (maxLow < gap) {
						maxLow = gap;
					}
				}
			}
			System.out.printf("#%d %d %d\n", tc, maxHigh, maxLow);
		} // end of tc
	}

}
