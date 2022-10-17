package boj.bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 문자열 S를 입력받은 후에, 각 문자를 R번 반복해 새 문자열 P를 만든 후 출력
 * 3 ABC -> AAABBBCCC
 * 5 /HTP -> /////HHHHHTTTTTPPPPP
 */
public class _2675_문자열반복 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());
		for (int tc = 0; tc < T; tc++) {
			st = new StringTokenizer(br.readLine());

			int r = Integer.parseInt(st.nextToken()); // 반복횟수
			String str = st.nextToken();

			char[] res = new char[r * str.length()];

			int idx = 0;
			for (int i = 0; i < str.length(); i++) {
				for (int j = 0; j < r; j++) {
					res[idx++] = str.charAt(i);
				}
			}
			for (char c : res) {
				System.out.print(c);
			}
			System.out.println();
		}
	}
}
