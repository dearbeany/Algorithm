package boj.bronze;

/*
 * 핵심 아이디어 
 * 1. 계차수열의 개념을 사용하여 푼다
 * 2. a(n) - a(n-1) = b(n)으로 또다른 수열로서 규칙성이 존재할 때,b(n)을 계차수열이라고 한다 
 * 3. an의 일반항구하기 -> a(n) = a(1) + b(k)의 1부터 n-1항까지의 합 
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _2292_벌집 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine()); // N번째 방
		int cnt = 0; // 몇 개의 방을 지나는지

		int range = 0; // 범위의 시작

		while (true) {
			range = 1 + (cnt * (6 + 6 * cnt) / 2); // a(n)의 일반항, 범위
			if (range >= N)
				break;
			cnt++;
		}
		System.out.println(cnt + 1);

	}
}
