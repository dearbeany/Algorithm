package boj.bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * 소문자 대문자 숫자 공백 개수 
 */
public class _10820_문자열분석 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 소문자는 97부터 122까지
		// 대문자는 65부터 90까지
		// 공백은 32
		String str = null;

		while ((str = br.readLine()) != null) {
			int small = 0, big = 0, number = 0, empty = 0;

			for (int j = 0; j < str.length(); j++) {
				int num = str.charAt(j);

				if (num >= 48 && num <= 57) { // 0부터 9까지
					number++;
				} else if (num == 32) {
					empty++;
				} else if (num >= 65 && num <= 90) {
					big++;
				} else if (num >= 97 && num <= 122) {
					small++;
				}
			}
			System.out.println(small + " " + big + " " + number + " " + empty);

		}
	}
}