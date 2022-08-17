package swea.d2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _1945_간단한소인수분해 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			int n = Integer.parseInt(br.readLine());

			int a = 0, b = 0, c = 0, d = 0, e = 0;

			// n 을 2로 나눌 때마다 a+1
			// 더이상 2로 나눌 수 없으면 3으로 나눈다

			while (n != 1) {
				if (n % 2 == 0) {
					n = n / 2;
					a++;
				}
				if (n % 3 == 0) {
					n = n / 3;
					b++;
				}
				if (n % 5 == 0) {
					n = n / 5;
					c++;
				}
				if (n % 7 == 0) {
					n = n / 7;
					d++;
				}
				if (n % 11 == 0) {
					n = n / 11;
					e++;
				}
			}
			System.out.printf("#%d %d %d %d %d %d\n", tc, a, b, c, d, e);

		}
	}
}
