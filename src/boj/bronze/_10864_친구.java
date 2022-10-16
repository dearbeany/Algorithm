package boj.bronze;

import java.util.Scanner;

/*
 * N명에 대해 각 사람의 친구 수 출력 
 */
public class _10864_친구 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();

		int[] friends = new int[n + 1];
		for (int i = 0; i < m; i++) {
			// a와 b가 서로 친구면 둘 다 친구 한 명씩 증가
			friends[sc.nextInt()]++; // 사람 a
			friends[sc.nextInt()]++; // 사람 b
		}

		for (int i = 1; i < n + 1; i++) {
			System.out.println(friends[i]);
		}
	}
}
