package swea.d1;

import java.util.Scanner;

public class _2029_몫과나머지 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			System.out.printf("#%d %d %d \n", tc, a / b, a % b);
		}
	}
}
