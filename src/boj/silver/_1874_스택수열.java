package boj.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class _1874_스택수열 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int n = Integer.parseInt(br.readLine());

		Stack<Integer> stack = new Stack<>();

		Queue<Integer> target = new LinkedList<>(); // [4, 3, 6, 8, 7, 5, 2, 1]

		for (int i = 0; i < n; i++) {
			target.add(Integer.parseInt(br.readLine()));
		}

		// 스택에 먼저 숫자를 다 넣어놓는다 1 2 3 4 5 6 7 8
		// 스택의 맨 위 원소와 큐의 맨 위 원소가 같다면
		// 스택에서 p

		for (int i = 0; i < n; i++) {
			stack.push(i + 1);
			sb.append("+").append("\n");

			while (!target.isEmpty() && !stack.isEmpty()) {
//				stack.pop();
//			if(stack.peek().equals(target.peek()) {

//			}

			}
		}

		System.out.println(stack);
//		}
	}
}
