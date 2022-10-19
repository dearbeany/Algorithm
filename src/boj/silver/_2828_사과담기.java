package boj.silver;

import java.util.Scanner;

/*
 * 사과의 떨어지는 위치가 차례대로 주어질 때, 
 * 모든 사과를 담기 위해 크기가 m인 바구니를 이동해야하는 거리의 최솟값?
 * 
 * (1) 바구니 크기가 다르므로 바구니의 시작, 끝위치를 움직일 때마다 변경 
 * (2) 사과의 위치를 3가지로 나누어 생각한다 
 * 
 * 	- [사과] 바구니시작 
 * 	- 바구니 시작 [사과] 바구니 끝  ---> 바구니 안에 사과를 담았다 !!
 * 	- 바구니 끝 [사과] 
 * 
 */
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

			if (pos < st) { // 사과가 바구니 시작위치의 왼쪽으로 떨어지면?
				min += st - pos;
				// 바구니는 사과 있던 데로 이동
				st = pos;
				ed = st + m - 1;
			} else if (st <= pos && pos <= ed) { // 사과가 바구니 안에 있다면??
				continue;
			} else { // 사과가 바구니 끝나는 위치보다 오른쪽으로 떨어지면?
				min += pos - ed;
				// 바구니는 사과 있는 데로 이동
				ed = pos;
				st = ed - (m - 1);
			}
		}
		System.out.println(min);
	}
}
