package swea.d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _9317_석찬이받아쓰기 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine()); // 문자열 길이
			String correct = br.readLine();
			String input = br.readLine();

			int cnt = 0; // 맞게 적은 문자의 개수

			for (int i = 0; i < N; i++) {
				if (correct.charAt(i) == input.charAt(i)) {
					cnt++;
				}
			}
			System.out.printf("#%d %d\n", tc, cnt);
		}
	}

}
