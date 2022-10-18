package boj.silver;

import java.util.Scanner;

public class _2828_사과담기 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(); // 나눠진 칸 수
		int m = sc.nextInt(); // 바구니 크기

		int apple = sc.nextInt(); // 떨어지는 사과 개수

		// 바구니 크기는 m
		int st = 1; // 바구니는 처음에 왼쪽에 붙어있으니까 시작 위치
		int ed = m; // 바구니 끝나는 위치
		int min = 0; // 최소 이동 거리

		for (int i = 0; i < apple; i++) {
			int pos = sc.nextInt(); // 사과의 위치

			if (st <= pos && pos <= ed) {
				continue;
			}

			if (pos < st) { // 사과가 바구니 시작위치의 왼쪽으로 떨어지면?
				min += st - pos;
				st = pos; // 바구니는 사과 있던 데로 이동
//				ed = pos + m;
				ed -= (st - pos);
			}

			else if (pos > ed) { // 사과가 바구니 끝나는 위치보다 오른쪽으로 떨어지면?
				min += pos - ed;
				ed = pos;
//				st = st - m;
				st += (pos - ed);
			}
		}
		System.out.println(min);
	}
}
