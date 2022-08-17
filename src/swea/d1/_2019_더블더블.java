package swea.d1;

import java.util.Scanner;

public class _2019_더블더블 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();

		for (int i = 0, res = 1; i <= n; i++) {
			System.out.print(res + " ");
			res *= 2;
		}
	}
}
