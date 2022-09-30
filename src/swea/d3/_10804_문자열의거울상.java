package swea.d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _10804_문자열의거울상 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			StringBuilder sb = new StringBuilder();
			String str = br.readLine();

			String mirror = "";
			for (int i = 0; i < str.length(); i++) {
				char c = str.charAt(i);
				switch (c) {
				case 'b':
					c = 'd';
					break;
				case 'd':
					c = 'b';
					break;
				case 'p':
					c = 'q';
					break;
				case 'q':
					c = 'p';
					break;
				}
				mirror += c;
			}
			System.out.print("#" + tc + " ");
			sb.append(mirror).reverse();
			System.out.println(sb);
		}
	}
}
