package swea.d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _5549_홀수일까짝수일까 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			StringBuilder sb = new StringBuilder();
			sb.append("#").append(tc).append(" ");

			String str = br.readLine();
			int n = str.charAt(str.length() - 1) - '0'; // 끝자리만 판단하자

			if (n % 2 == 0) {
				sb.append("Even");
			} else {
				sb.append("Odd");
			}
			System.out.println(sb);
		}
	}
}
