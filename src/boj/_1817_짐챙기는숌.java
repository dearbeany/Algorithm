package boj;

import java.util.Scanner;

public class _1817_짐챙기는숌 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt(); // 책의 개수
		int M = sc.nextInt(); // 박스에 넣을 수 있는 최대 무게

		int[] books = new int[N]; // 책들의 무게

		for (int i = 0; i < N; i++) {
			books[i] = sc.nextInt();
		}

		// 넣을 책이 없는 경우
		// 필요한 박스의 개수 0개
		if (N == 0) {
			System.out.println(0);
			return;
		}

		int cnt = 1; // 필요한 박스의 개수
		int sum = 0; // 책들의 누적합

		for (int i = 0; i < N; i++) {
			// M이하까지 책 무게들을 더해준다
			sum += books[i];

			// 책무게의 합이 M을 초과하면
			if (sum > M) {
				cnt++; // 박스 1개 사용
				sum = books[i]; // 새로운 박스를 사용하기 위해서 누적합을 초과됐던 i번째 책의 무게로 초기화
			}
		}

		System.out.println(cnt);

	}
}