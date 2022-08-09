package sw.d1;

import java.util.Scanner;

public class _2068_최대수구하기 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {
			int max = 0;
			for (int i = 0; i < 10; i++) {
				int n = sc.nextInt();

				if (n > max) {
					max = n;
				}
			}
			System.out.println("#" + tc + " " + max);
		}
	}

}
