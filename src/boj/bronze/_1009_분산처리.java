package boj.bronze;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class _1009_분산처리 {
	static int a;
	static List<Integer> list;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int tc = 0; tc < T; tc++) {
			a = sc.nextInt();
			int b = sc.nextInt();

			// a의 마지막 자릿수 더하기
			isDigit();
			System.out.println(list);
			// b % 자릿수 개수 = 마지막 처리되는번호 + 1 번째 인덱스
		}
	}

	private static void isDigit() {
		list = new ArrayList<>();
		while (true) {
			// 처음 끝자리 수와 제곱수 할 때마다 끝자리 수 비교 같으면 멈춰
			String tmp1 = String.valueOf(a);
			int digit1 = tmp1.charAt(tmp1.length() - 1);
			list.add(digit1);

			int pow = a * a;
			String tmp2 = String.valueOf(pow);
			int digit2 = tmp2.charAt(tmp2.length() - 1);
			list.add(digit2);
			if (digit1 == digit2) {
				break;
			}
		}
	}
}
