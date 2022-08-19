package swea.d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _5432_쇠막대기자르기 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			String str = br.readLine();
			str = str.replace("()", "*"); // 레이저로 치환

			int curBar = 0; // 현재 쇠막대기 개수
			int piece = 0; // 잘려진 조각 개수

			for (int i = 0; i < str.length(); i++) {
				char c = str.charAt(i);

				if (c == '*') { // 레이저면
					piece += curBar;
				} else if (c == '(') { // 쇠막대기 시작하면
					curBar++;
				} else { // 쇠막대기 끝나면
					curBar--;
					piece++;
				}

			}
			System.out.printf("#%d %d\n", tc, piece);
		}

	}
}
