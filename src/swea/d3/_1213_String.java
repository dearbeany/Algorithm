package swea.d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _1213_String {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		for (int tc = 1; tc <= 10; tc++) {
			Integer.parseInt(br.readLine());
			sb.append("#").append(tc).append(" ");

			String keyword = br.readLine(); // 찾을 키워드
			String str = br.readLine(); // 입력 문자열들

			str = str.replace(keyword, "*"); // 입력받은 키워드를 *로 변경해주고

			int cnt = 0;
			for (int i = 0; i < str.length(); i++) { // 입력문자열들을 하나씩 돌면서
				if (str.charAt(i) == '*') {
					cnt++; // *의 개수를 센다
				}
			}
			sb.append(cnt).append("\n");
		}
		System.out.println(sb);

	}
}
