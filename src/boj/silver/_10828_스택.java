package boj.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class _10828_스택 {

	static Stack<Integer> stack = new Stack<>();

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine()); // 명령의 수

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());

			String cmd = st.nextToken();

			switch (cmd) {
			case "push":
				stack.push(Integer.parseInt(st.nextToken()));
				break;

			case "pop":
				if (stack.isEmpty()) {
					sb.append(-1 + "\n");
				} else {
					sb.append(stack.pop() + "\n");
				}
				break;

			case "size":
				sb.append(stack.size() + "\n");
				break;

			case "empty":
				if (stack.isEmpty()) {
					sb.append(1 + "\n");
				} else {
					sb.append(0 + "\n");
				}
				break;

			case "top":
				if (stack.isEmpty()) {
					sb.append(-1 + "\n");
				} else {
					sb.append(stack.peek() + "\n");
				}
				break;
			}
		}
		System.out.println(sb);
	}
}
