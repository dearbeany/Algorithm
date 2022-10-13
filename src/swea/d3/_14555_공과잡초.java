package swea.d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * 초원에 놓였을 수 있는 공의 개수의 최솟값?
 * 공은 무조건 () 열린 -> 닫힌 모양이어야 한다 
 */
public class _14555_공과잡초 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			// ( 만났는데 다음 |면 공
			// | 만났는데 다음 )면 공

			String str = br.readLine();
			int cnt = 0;
			for (int i = 0; i < str.length() - 1; i++) {
				if (str.charAt(i) == '(' && str.charAt(i + 1) == '|') {
					cnt++;
				}
				if (str.charAt(i) == '|' && str.charAt(i + 1) == ')') {
					cnt++;
				}
			}
			str = str.replace("()", "*");
			for (int i = 0; i < str.length(); i++) {
				if (str.charAt(i) == '*') {
					cnt++;
				}
			}
			System.out.printf("#%d %d\n", tc, cnt);
		}
	}
}
