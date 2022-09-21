package boj.bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _1212_8진수2진수_초과 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String str = br.readLine(); // 8진수

		long tenNum = 0; // 10진수로 변환한 값

		// 8진수를 10진수로 변환
		for (int i = str.length() - 1; i >= 0; i--) {
			tenNum += (str.charAt(i) - '0') * (int) Math.pow(8, str.length() - 1 - i);
		}

		// 10진수를 2진수로
		while (tenNum > 0) {
			sb.append(tenNum % 2);
			tenNum /= 2;
		}
		System.out.print(sb.reverse());
	}
}
