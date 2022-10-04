package boj.silver.bruteforce;

import java.io.IOException;
import java.util.Scanner;

public class _1182_부분수열의합 {

	static int n, s, cnt;
	static int[] arr;

	// 합이 s가 되는 부분수열의 개수를 구한다
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt(); // 주어진 정수의 개수
		s = sc.nextInt(); // 합

		arr = new int[n]; // 주어진 정수들이 담긴 배열
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}

		cnt = 0; // 부분수열의 개수

		subseq(0, 0); // 인덱스는 0, 현재의 합은 0부터 시작

		cnt = (s == 0) ? cnt - 1 : cnt; // 합이 0이면 공집합인 1개를 빼준다
		System.out.println(cnt);
	}

	private static void subseq(int idx, int sum) {
		if (idx == n) { // 인덱스를 주어진 정수의 개수인 n번째까지 모두 돌았다면 종료
			if (sum == s) { // 합이 s가 되면
				cnt++; // 개수를 +1
			}
			return;
		}

		subseq(idx + 1, sum + arr[idx]); // idx번째 수인 현재값 선택
		subseq(idx + 1, sum); // idx번째 수를 선택하지 않음
	}

}
