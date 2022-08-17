package swea.d2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _1288_새로운불면증치료법 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			int num = Integer.parseInt(br.readLine()); // 주어진 숫자

			boolean[] digit = new boolean[10]; // 0~9까지 자릿수 배열
			int cnt = 0; // 양을 카운트 한 최소 횟수
			int i = 1;
			int N = num;

			while (true) {
				digit = countDigit(num, digit);

				if (isAllTrue(digit)) // digit이 모두 true인 경우에 break해서 빠져 나간다
					break;

				num = ++i * N;
			}
			System.out.printf("#%d %d\n", tc, num);
		}

	}

	public static boolean[] countDigit(int num, boolean[] digit) {
		while (num > 0) {
			// 자릿수 카운트
			// 10으로 나눌 때마다 일의자리, 십의 자리, 천의 자리...
			digit[num % 10] = true; // 각 자릿수가 있으면 true
			num /= 10;
		}
		return digit;
	}

	// digit 배열의 전체 원소들이 모두 true면 true를 반환
	public static boolean isAllTrue(boolean[] digit) {
		for (int i = 0; i < digit.length; i++) {
			if (digit[i] != true) {
				return false;
			}
		}
		return true;
	}
}
