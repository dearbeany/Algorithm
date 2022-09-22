package swea.d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _5607_조합 {

	static int p = 1234567891;
	static int P = 1234567891;
	static long[] fact;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());

			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());

			fact = new long[N + 1];
			for (int i = 2; i <= N; i++) {
				fact[i] = fact[i - 1] * i % p;
			}
			long ans = fact[N] * pow(fact[N - M] * fact[M] % P, P - 2) % P;
			System.out.printf("#%d %d\n", tc, comb(N, M));
		}

	}

	// n, m <= 100만
	// nCm의 값을 10억으로 나눈 나머지?

	// nCm = n!/(n-m)!m!
	// n! = A, (n-m)!m! = B라고 할 때,
	// nCm mod P == (A*B^(p-2)) mod P

	// B의 값에 (p-2) 만큼 거듭제곱 해주어야 한다...
	// 근데 p값이 엄청 나게 크다 .. B의 거듭제곱을 구할 때 분할 정복을 하자
	private static long comb(int n, int m) {

		long a = fact[n];
		long b = pow(fact[n - m] * fact[m] % p, p - 2) % p;

		return a * b;
	}

//	private static int fact(int n) {
//		if (n <= 1) {
//			return 1;
//		}
//		return fact(n - 1) % p * n;
//	}

	public static long pow(long n, long m) {
		if (m == 1) {
			return n;
		}
		long res = pow(n, m / 2);
		return (m % 2 == 0) ? (res * res) % p : res * res % p * n % p;
	}
}
