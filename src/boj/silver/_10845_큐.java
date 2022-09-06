package boj.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _10845_큐 {

	static Queue<Integer> queue = new LinkedList<>();

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine()); // 명령의 수

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			String cmd = st.nextToken();

			switch (cmd) {

			case "push":
				queue.add(Integer.parseInt(st.nextToken()));
				break;

			case "pop":
				if (queue.isEmpty()) {
					sb.append(-1).append("\n");
				} else {
					sb.append(queue.poll()).append("\n");
				}
				break;

			case "size":
				sb.append(queue.size()).append("\n");
				break;

			case "empty":
				if (queue.isEmpty()) {
					sb.append(1).append("\n");
				} else {
					sb.append(0).append("\n");
				}
				break;

			case "front":
				if (queue.isEmpty()) {
					sb.append(-1).append("\n");
				} else {
					// 가장 앞에 있는 정수를 출력
					sb.append(queue.peek()).append("\n");

				}
				break;

			case "back":
				if (queue.isEmpty()) {
					sb.append(-1).append("\n");
				} else {
					// 가장 뒤에 있는 정수를 출력
					Object[] tmp = queue.toArray();
					sb.append((int) tmp[queue.size() - 1]).append("\n");
				}
				break;
			}
		}
		System.out.println(sb);
	}
}
