package boj.silver;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class _1747_소수엔팰린드롬 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine()); // 어떤 수

		// N 이상 && 소수 && 팰린드롬 && 가장 작은 수
		int res = 0;

		while (true) {
			if (isPrime(N) && isPalindrome(N)) {
				res = N;
				break;
			}
			N++; // 가장 작은 수를 골라야 하므로 1씩 증가시켜 보면서 확인
		}

		bw.write(res + "");
		bw.flush();
		bw.close();
	}

	// 소수인지 판별하는 메소드
	private static boolean isPrime(int n) {
		if (n == 1) {
			return false; // 1은 소수가 아님
		}
		for (int i = 2; i <= Math.sqrt(n); i++) {
			if (n % i == 0) {
				return false; // n이 i의 배수면 소수가 아님
			}
		}
		return true;
	}

	// 팰린드롬인지 판별하는 메소드
	private static boolean isPalindrome(int n) {
		// 문자열로 바꿔준 후에
		// reverse한 값과 비교하여 판별한다
		String str = String.valueOf(n);
		String tmp = new StringBuilder(str).reverse().toString();

		return (str.equals(tmp)) ? true : false;
	}
}
