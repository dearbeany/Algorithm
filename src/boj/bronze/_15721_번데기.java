package boj.bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _15721_번데기 {

	static int A, T, sign;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		A = Integer.parseInt(br.readLine()); // 게임 참여인원수
		T = Integer.parseInt(br.readLine()); // 구하고자 하는 T번째
		sign = Integer.parseInt(br.readLine()); // 뻔이면 0 데기면 1

		// A명이 게임할 때 sign을 T번째에 외치는 사람이
		// 원탁에서 몇번째인지?

		int n = 1; // n번째 회차
		int bbun = 0; // 뻔 개수 0
		int degi = 0; // 데기 개수 1

		loop: while (true) {
			for (int i = 0; i < 4; i++) {
				if (i % 2 == 0) {
					bbun++;
				} else {
					degi++;
				}
				if (sign == 0) { // 뻔이면
					if (bbun == T) {
						break loop;
					}
				} else { // 데기면
					if (degi == T) {
						break loop;
					}
				}
			}

			for (int i = 0; i < n + 1; i++) {
				bbun++;
				if (sign == 0 && bbun == T) {
					break loop;
				}
			}

			for (int i = 0; i < n + 1; i++) {
				degi++;
				if (sign == 1 && degi == T) {
					break loop;
				}
			}
			n++;
		}

		int numOfPeople = bbun + degi;
		int res = numOfPeople % A;

		if (res == 0) {
			System.out.println(A - 1);
		} else {
			System.out.println(res - 1);
		}
	}

}
