package boj.silver;

import java.util.PriorityQueue;
import java.util.Scanner;

public class _1927_최소힙 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();

		// 최소힙
		PriorityQueue<Integer> pq = new PriorityQueue<>();

		for (int i = 0; i < n; i++) {
			int input = sc.nextInt();
			if (input == 0) {
				if (!pq.isEmpty()) {
					System.out.println(pq.poll());
				} else {
					System.out.println("0");
				}
			} else {
				pq.add(input);
			}
		}
	}
}
