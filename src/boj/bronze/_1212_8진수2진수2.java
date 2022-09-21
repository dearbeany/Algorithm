package boj.bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * 8진수의 각 자릿수를 2진수로 변환한다 
 */
public class _1212_8진수2진수2 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		String str = br.readLine();

		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);

			switch (c) {
			case '0':
				sb.append("000");
				break;
			case '1':
				sb.append("001");
				break;
			case '2':
				sb.append("010");
				break;
			case '3':
				sb.append("011");
				break;
			case '4':
				sb.append("100");
				break;
			case '5':
				sb.append("101");
				break;
			case '6':
				sb.append("110");
				break;
			case '7':
				sb.append("111");
				break;
			}
		}
		// 앞 두 자리가 0일 경우에 지운다
		if (sb.charAt(0) == '0') {
			sb.deleteCharAt(0);
		}
		if (sb.charAt(0) == '0') {
			sb.deleteCharAt(0);
		}
		System.out.println(sb);
	}
}
