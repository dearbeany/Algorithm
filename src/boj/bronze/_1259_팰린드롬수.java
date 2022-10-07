package boj.bronze;

import java.util.Scanner;

public class _1259_팰린드롬수 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		while (true) {
			int n = sc.nextInt();
			if (n == 0) {
				break;
			}
			String res = isFalindrome(n) ? "yes" : "no";
			System.out.println(res);
		}
	}

	private static boolean isFalindrome(int n) {
		char[] carr = String.valueOf(n).toCharArray();
		int[] arr = new int[String.valueOf(n).length()];

		for (int i = 0; i < arr.length; i++) {
			arr[i] = carr[i] - '0';
		}

		int len = arr.length;
		for (int i = 0; i < len; i++) {
			if (arr[i] != arr[len - 1 - i]) {
				return false;
			}
		}
		return true;
	}
}
