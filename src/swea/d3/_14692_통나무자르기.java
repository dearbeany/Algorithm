package swea.d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _14692_통나무자르기 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine()); // 테케

		for (int tc = 1; tc <= T; tc++) {
			int n = Integer.parseInt(br.readLine()); // 통나무의 길이

			String win = (n % 2 == 0) ? "Alice" : "Bob";

			System.out.printf("#%d %s\n", tc, win);
		}
	}

}
