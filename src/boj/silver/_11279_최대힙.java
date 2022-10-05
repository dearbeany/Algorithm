package boj.silver;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class _11279_최대힙 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();

		// 최대힙
		PriorityQueue<Integer> q = new PriorityQueue<>(Collections.reverseOrder());
		for (int i = 0; i < N; i++) {
			int input = sc.nextInt();

			if (input == 0) {
				if (!q.isEmpty()) {
					System.out.println(q.poll());
				} else {
					System.out.println("0");
				}
			} else {
				q.add(input);
			}
		}
	}
}
