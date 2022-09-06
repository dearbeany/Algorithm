package boj.silver;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class _10888_덱 {

	static Deque<Integer> deque = new LinkedList<>();

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine()); // 명령의 수

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());

			String cmd = st.nextToken();
			switch (cmd) {
			case "push_front":
				deque.addFirst(Integer.parseInt(st.nextToken())); // 정수를 덱의 앞에 넣음
				break;

			case "push_back":
				deque.addLast(Integer.parseInt(st.nextToken())); // 정수를 덱의 뒤에 넣음
				break;

			case "pop_front":
				int poppedFront = 0;

				if (deque.isEmpty()) {
					poppedFront = -1;
				} else {
					poppedFront = deque.pollFirst();
				}

				bw.write(poppedFront + "\n"); // 덱의 가장 앞을 삭제 후 반환. 없으면 -1
				break;

			case "pop_back":
				int poppedBack = 0;

				if (deque.isEmpty()) {
					poppedBack = -1;
				} else {
					poppedBack = deque.pollLast();
				}

				bw.write(poppedBack + "\n"); // 덱의 가장 뒤를 삭제 후 반환. 없으면 -1
				break;

			case "size":
				bw.write(deque.size() + "\n");
				break;

			case "empty":
				int res = deque.isEmpty() ? 1 : 0;
				bw.write(res + "\n");
				break;

			case "front":
				int front = 0;

				if (deque.isEmpty()) {
					front = -1;
				} else {
					front = deque.peekFirst();
				}

				bw.write(front + "\n"); // 덱의 가장 앞을 반환. 없으면 -1
				break;

			case "back":
				int back = 0;

				if (deque.isEmpty()) {
					back = -1;
				} else {
					back = deque.peekLast();
				}

				bw.write(back + "\n"); // 덱의 가장 뒤를 반환. 없으면 -1
				break;
			}

		} // end of for

		bw.flush();
		bw.close();

	}
}
