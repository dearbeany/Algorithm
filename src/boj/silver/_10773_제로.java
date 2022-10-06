package boj.silver;

import java.util.Scanner;
import java.util.Stack;

public class _10773_제로 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int k = sc.nextInt();

		Stack<Integer> stack = new Stack<>();
		for (int i = 0; i < k; i++) {
			int input = sc.nextInt();
			if (input != 0) {
				stack.add(input);
			} else {
				stack.pop();
			}
		}

		int sum = 0;
		while (!stack.isEmpty()) {
			sum += stack.pop();
		}
		System.out.println(sum);
	}
}
