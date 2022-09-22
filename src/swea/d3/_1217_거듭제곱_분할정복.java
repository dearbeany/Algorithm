package swea.d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _1217_거듭제곱_분할정복 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		for (int tc = 1; tc <= 10; tc++) {
			br.readLine(); // tc

			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());

			int res = pow(N, M);
			System.out.printf("#%d %d\n", tc, res);
		}
	}

	public static int pow(int n, int m) {
		if (m == 1) {
			return n;
		}

		int res = 0;

		// 짝수면
		if (m % 2 == 0) {
			res = pow(n, m / 2);
			return res * res;
		}
		// 홀수면
		else {
			res = pow(n, (m - 1) / 2);
			return res * res * n;
		}
	}

}
