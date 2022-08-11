package sw.d2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _1986_지그재그숫자 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			int num = Integer.parseInt(br.readLine());

			int sum = 0;
			for (int i = 1; i <= num; i++) {
				if (i % 2 == 1) {
					sum += i;
				} else {
					sum -= i;
				}
			}
			System.out.printf("#%d %d\n", tc, sum);
		}
	}
}
