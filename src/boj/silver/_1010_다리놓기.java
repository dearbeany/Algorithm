package boj.silver;

/* 
 * 핵심아이디어 
 * 1. 0 < N <= M < 30으로
 *    int, long으로 풀 경우 범위초과되므로 BigInteger클래스를 사용한다.
 * 2. BigInteger클래스의 경우, "문자열"을 인자 값으로 넣어주기에 사칙연산이 안 됨. 따라서 클래스 내부의 메소드를 사용한다.
 * 3. 동쪽다리 M개에서 서쪽다리 N개를 고르기만 하면 되므로 (따로 순서를 지정해줄 필요X), 조합을 사용한다. 
 * 
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class _1010_다리놓기 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());

		for (int tc = 0; tc < T; tc++) {
			st = new StringTokenizer(br.readLine());
			BigInteger N = new BigInteger(st.nextToken()); // 서쪽 다리
			BigInteger M = new BigInteger(st.nextToken()); // 동쪽 다리
			// M개 중 N개를 고른다 -> 조합
			// mCn = m!/(m-n)!n!

			BigInteger res = fact(M).divide((fact(M.subtract(N)).multiply(fact(N))));
			System.out.println(res);

		}

	}

	private static BigInteger fact(BigInteger num) {
		BigInteger one = new BigInteger("1");

		if (num.intValue() <= 1)
			return one;
		return fact(num.subtract(one)).multiply(num);
	}
}
