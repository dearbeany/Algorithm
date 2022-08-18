package boj.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class _2164_카드2 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine()); // N장의 카드
		// 가장 위 deQueue -> 그다음 위 enQueue
		// 6
		// 1 2 3 4 5 6 삽입
		// 1 삭제 -> 2삽입 3 4 5 6 2
		// 3 삭제 -> 4 삽입 5 6 2 4
		// 5 삭제 -> 6 삽입 2 4 6
		// 2 삭제 -> 4 삽입 6 4
		// 6 삭제 4

		Queue<Integer> queue = new LinkedList<>();

		for (int i = 0; i < n; i++) {
			queue.add(i + 1);
		}

		while (queue.size() != 1) {
			queue.remove(); // 첫 번째 값 삭제
			queue.add(queue.poll()); // 새로운 첫 번째 값을 제거하고 반환, 반환한 값을 다시 추가
//			queue.add(queue.peek()); // 새로운 첫 번째 값 맨 뒤 삽입
//			queue.remove(); // 새로운 첫 번째 값 삭제
		}
		System.out.println(queue.peek());

	}
}
