package boj.silver;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class _11286_절댓값힙 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
			// 절댓값 기준 오름차순
			@Override
			public int compare(Integer o1, Integer o2) {
				int a = Math.abs(o1);
				int b = Math.abs(o2);
				if (a > b) {
					return 1;
				} else if (a < b) {
					return -1;
				} else { // 절댓값 같을 때
					return o1 - o2;
				}
			}
		});

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
