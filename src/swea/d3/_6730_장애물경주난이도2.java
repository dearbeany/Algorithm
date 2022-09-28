package swea.d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _6730_장애물경주난이도2 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine()); // 테케

		for (int tc = 1; tc <= T; tc++) {
			int n = Integer.parseInt(br.readLine()); // 블록 개수

			int[] stairs = new int[n];

			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < n; i++) {
				stairs[i] = Integer.parseInt(st.nextToken());
			}
			int maxHigh = 0, maxLow = 0; // 올라갈 때 내려갈 때 최고 변화

			for (int i = 0; i < n - 1; i++) {
				if (stairs[i] < stairs[i + 1]) { // 올라간다
					maxHigh = Math.max(maxHigh, stairs[i + 1] - stairs[i]);
				} else if (stairs[i] > stairs[i + 1]) { // 내려간다
					maxLow = Math.max(maxLow, stairs[i] - stairs[i + 1]);
				}
			}

			System.out.printf("#%d %d %d\n", tc, maxHigh, maxLow);
		}
	}

}
