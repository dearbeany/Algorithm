package boj.bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _25501_재귀의귀재 {

	static int cnt; // recursion 함수 호출횟수

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		for (int i = 0; i < T; i++) { // 테케
			String str = br.readLine();
			System.out.println(isPalindrome(str) + " " + cnt);
		}
	}

	public static int recursion(String s, int l, int r) {
		cnt++;
		if (l >= r)
			return 1;
		else if (s.charAt(l) != s.charAt(r))
			return 0;
		else
			return recursion(s, l + 1, r - 1);
	}

	public static int isPalindrome(String s) {
		cnt = 0;
		return recursion(s, 0, s.length() - 1);
	}

}
