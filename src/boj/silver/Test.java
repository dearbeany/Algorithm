package boj.silver;

import java.util.Scanner;

public class Test {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		while (true) {
			int n = sc.nextInt();
			if (n == 0)
				break;
			System.out.println(isPrime(n));
		}
	}

	// 소수인지 판별하는 메소드
	private static boolean isPrime(int n) {
		if (n == 1) {
			return false; // 1은 소수가 아님
		}
		for (int i = 2; i <= Math.sqrt(n); i++) {
			if (n % i == 0) {
				return false; // n이 i의 배수면 소수가 아님
			}
		}
		return true;
	}

	// 팰린드롬인지 판별하는 메소드
	private static boolean isPalindrome(int n) {
		// 문자열로 바꿔준 후에
		// reverse한 값과 비교하여 판별한다
		String str = String.valueOf(n);
		String tmp = new StringBuilder(str).reverse().toString();

		return (str.equals(tmp)) ? true : false;
	}
}
