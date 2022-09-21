package boj.silver;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/*
 * 1. 무작정 조합으로 푸니 메모리, 시간초과가 나온다
 * 2. 끝자리 0의 개수만 구하면 되므로 다 계산할 필요X
 * 3. 결국 2의 배수의 개수, 5의 배수의 개수만 찾으면 된다
 * 4. 2의 배수 1개 * 5의 배수 1개 => 10으로 끝에 0이 한 개 발생
 * 
 */
public class _2004_조합0의개수 {

	static long n, m;
	static long fiveCnt, twoCnt;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		// nCm = n!/(n-m)!m!

		n = Long.parseLong(st.nextToken());
		m = Long.parseLong(st.nextToken());

		fiveCnt = 0;
		twoCnt = 0;

		// 5와 2 모두 n!에서 개수 구해주고
		// 나눠지는 (n-m)!과 m!에서 나오는 개수를 빼준다
		fiveCnt = isFiveCnt(n) - isFiveCnt(n - m) - isFiveCnt(m);
		twoCnt = isTwoCnt(n) - isTwoCnt(n - m) - isTwoCnt(m);

		// 둘 중 개수의 최소값 출력
		long res = (twoCnt >= fiveCnt) ? fiveCnt : twoCnt;
		bw.write(res + "");
		bw.flush();
		bw.close();
	}

	// 5의 개수 세기
	public static long isFiveCnt(long n) {
		long cnt = 0;

		while (n >= 5) {
			cnt += (n / 5);
			n /= 5;
		}
		return cnt;
	}

	// 2의 개수 세기
	public static long isTwoCnt(long n) {
		long cnt = 0;

		while (n >= 2) {
			cnt += (n / 2);
			n /= 2;

		}
		return cnt;
	}
}
