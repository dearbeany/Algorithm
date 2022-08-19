package swea.d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _1289_원재의메모리복구 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			String str = br.readLine();

			int cnt = str.charAt(0) - '0'; // 1로 시작하는 경우도 처리해주어야 함 ex. 1111

			for (int i = 0; i < str.length() - 1; i++) {
				// 인접해서 다르면 카운트
				if (str.charAt(i) != str.charAt(i + 1)) {
					cnt++;
				}
			}
			System.out.printf("#%d %d\n", tc, cnt);

		}
	}
}
