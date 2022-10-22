package boj.bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _11365_밀비급일 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		while (true) {
			StringBuilder sb = new StringBuilder();
			String input = br.readLine();
			if (input.equals("END")) {
				break;
			}
			sb.append(input).reverse();
			System.out.println(sb);
		}
	}
}
