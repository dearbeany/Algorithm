package swea.d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _5607_조합2 {

	static int p = 7;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());

//			int N = Integer.parseInt(st.nextToken());
//			int M = Integer.parseInt(st.nextToken());
			long N = Long.parseLong(st.nextToken());
			long M = Long.parseLong(st.nextToken());

			comb(N, M);
//			System.out.printf("#%d %d\n", tc, comb(N, M));
		}

	}

	// n, m <= 100만
	// nCm의 값을 10억으로 나눈 나머지?

	// nCm = n!/(n-m)!m!
	// n! = A, (n-m)!m! = B라고 할 때,
	// nCm mod P == (A*B^(p-2)) mod P

	// a * a^(p-2) = 1 (== a^(p-1))

	// B의 값에 (p-2) 만큼 거듭제곱 해주어야 한다...
	// 근데 p값이 엄청 나게 크다 .. B의 거듭제곱을 구할 때 분할 정복을 하자
	private static void comb(long n, long m) {

//		long a = fact(n);
//		long b = pow(fact(n - m) * fact(m), p - 2);
		long a = 1, b = 1;
		for (int i = 1; i <= n; i++) {
			a *= i;
			a %= p;
			System.out.println("a:" + a);
		}

		for (int i = 1; i <= n - m; i++) {
			b *= i;
			if (i <= m) {
				b *= i;
			}
			b %= p;
		}
		System.out.println("b:" + b);

	}

	private static long fact(long n) {
		if (n <= 1) {
			return 1;
		}
		return fact(n - 1) * n;
	}

	// 거듭 제곱을 한 후 p로 나눈 나머지 값을 구한다
	// 나머지들은 결국 p보다 무조건 작음
	public static long pow(long n, long m) {
		if (m == 1) {
			return n % p;
		}
		long res = pow(n, m / 2) % p;

		return (m % 2 == 0) ? (res * res) % p : (res * res * n) % p;
	}
}
