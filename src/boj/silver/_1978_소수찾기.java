package boj.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 소수 : 약수가 1과 자기 자신 2개 뿐인 수 
 * 1은 소수가 아님!! 
 */
public class _1978_소수찾기 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());

		st = new StringTokenizer(br.readLine());

		int[] arr = new int[N];

		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		int cnt = 0; // 소수의 개수

		for (int i : arr) {
			if (isPrime(i))
				cnt++;
		}

		System.out.println(cnt);
	}

	// 모든 약수들은 대칭형태를 이루기 때문에
	// 굳이 끝까지 검증하지 않아도, 제곱근까지 약수 있는지 확인한다
	public static boolean isPrime(int n) {
		for (int i = 2; i <= (int) Math.sqrt(n); i++) {
			if (n % i == 0) { // 한 번이라도 약수 발견되면?
				return false; // 소수 아니다
			}
		}
		return true;
	}

}
