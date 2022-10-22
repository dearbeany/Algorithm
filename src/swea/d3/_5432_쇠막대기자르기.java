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

			int curBar = 0; // 현재 쇠막대기 개수
			int piece = 0; // 잘려진 조각 개수

			for (int i = 0; i < str.length(); i++) {

				if (str.charAt(i) == '(') { // ( 로 시작하면 즉, 쇠막대기 시작
					if (str.charAt(i + 1) != ')') { // 레이저가 아니면
						curBar++; // 쇠막대기 하나 추가
					}

				} else { // )로 시작하면 즉, 쇠막대기 끝나면
					if (str.charAt(i - 1) == '(') { // 레이저
						piece += curBar;
					} else {
						curBar--; // 쇠막대기 하나 줄고
						piece++; // 오른쪽 잘려진 조각 한 개 추가
					}
				}

			}
			System.out.printf("#%d %d\n", tc, piece);
		}

	}
}
