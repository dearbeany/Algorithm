package boj.silver;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class _2004_조합0의개수 {

	static BigInteger n, m;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = new BigInteger(st.nextToken());
		m = new BigInteger(st.nextToken());

		BigInteger tmp = comb(n, m);
		String res = tmp.toString();

		// 조합한 값을 끝에서부터 살펴보면서 0이면 카운트
		int cnt = 0;
		for (int i = res.length() - 1; i >= 0; i--) {
			if (res.charAt(i) != '0') { // 0 안 나오면 탈출
				break;
			}
			// 0 나오면 카운트
			cnt++;
		}
		bw.write(cnt + "");
		bw.flush();
		bw.close();
	}

	// nCm = n!/(n-m)!m!
	private static BigInteger comb(BigInteger n, BigInteger m) {
		return fact(n).divide(fact(n.subtract(m)).multiply(fact(m)));
	}

	private static BigInteger fact(BigInteger n) {
		BigInteger one = new BigInteger("1");
		if (n.intValue() <= 1) {
			return one;
		}
		return fact(n.subtract(one)).multiply(n);
	}
}
