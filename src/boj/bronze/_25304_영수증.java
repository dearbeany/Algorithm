package boj.bronze;

import java.util.Scanner;

public class _25304_영수증 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int total = sc.nextInt();
		int n = sc.nextInt();
		int tmp = 0;
		for (int i = 0; i < n; i++) {
			tmp += sc.nextInt() * sc.nextInt();
		}

		String res = total == tmp ? "Yes" : "No";
		System.out.println(res);
	}
}
