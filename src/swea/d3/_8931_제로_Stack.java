package swea.d3;

/*
 * 스택을 임포트 하여 풀이 
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class _8931_제로_Stack {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine()); // 테스트 케이스의 개수

		for (int tc = 1; tc <= T; tc++) { // 2개
			int K = Integer.parseInt(br.readLine()); // 테스트 케이스 당 주어지는 정수의 개수
			int sum = 0;

			Stack<Integer> stack = new Stack<>();

			for (int k = 0; k < K; k++) {
				int input = Integer.parseInt(br.readLine());

				if (input == 0) {
					// Stack에서 pop 한다
					stack.pop();
				} else {
					// Stack에 push한다
					stack.push(input);
				}
			}
			// stack에 남아있는 원소들을 더한다
			for (int i : stack) {
				sum += i;
			}

			System.out.printf("#%d %d\n", tc, sum);

		}
	}

}
