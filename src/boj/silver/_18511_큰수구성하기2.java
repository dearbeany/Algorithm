package boj.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _18511_큰수구성하기2 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int kcounts = Integer.parseInt(st.nextToken()); // 집합K 원소의 개수

		int[] ksets = new int[kcounts];

		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < kcounts; i++) {
			ksets[i] = Integer.parseInt(st.nextToken());
		}

		StringBuilder sb = new StringBuilder();

		// 원소가 < 맨 앞 자릿수보다 작으면 그 뒤로는 max가 붙는다. 자릿수 같으며 min-max-max
		// 원소가 > 맨 앞 자릿수보다 크면 자릿수-1. max-max
		// 원소 == 맨 앞 자릿수 같으면 그 뒤의 자릿수 ...다음 자릿수와 비교

		String str;
		int len;
		int bigDigit;
		int max = 0, min = 0;

		switch (kcounts) {

		case 1: // 원소의 개수가 1개일 때
			str = String.valueOf(N); // N을 문자로 바꿈
			len = str.length(); // N의 자릿수
			bigDigit = str.charAt(0) - '0'; // N의 맨 앞자리 숫자

			if (bigDigit > ksets[0]) {
				for (int i = 0; i < len; i++) {
					sb.append(ksets[0]);
				}
			} else {
				for (int i = 0; i < len - 1; i++) {
					sb.append(ksets[0]);
				}
			}
			break;

		case 2: // 원소의 개수 2개일 때
			str = String.valueOf(N); // N을 문자로 바꿈
			len = str.length(); // N의 자릿수
			bigDigit = str.charAt(0) - '0'; // N의 맨 앞자리 숫자
			max = Math.max(ksets[0], ksets[1]);
			min = Math.min(ksets[0], ksets[1]);

			if (bigDigit < min) {
				for (int i = 0; i < len - 1; i++) {
					sb.append(max);
				}
			} else if (bigDigit <= max) {
				sb.append(min);
				for (int i = 0; i < len - 1; i++) {
					sb.append(max);
				}
			} else {
				for (int i = 0; i < len; i++) {
					sb.append(max);
				}
			}
			break;
		}

		System.out.println(sb.toString());

	}

	private static void func(int digit, int num) {

	}
}
