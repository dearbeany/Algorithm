package swea.d3;

/*
 * 스택을 직접 배열을 이용하여 구현해보기 
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class ArrayStack {
	public int top; // 맨 끝원소 가리킴
	public int[] elements;

	public ArrayStack() {
		this.top = -1;
	}

	public ArrayStack(int givenSize) {
		this.top = -1;
		this.elements = new int[givenSize];
	}

//	public int size() {
//		return top + 1;
//	}

	public boolean isFull() {
		return top == elements.length - 1;
	}

	public boolean isEmpty() {
		return (top == -1);
	}

	// 삽입
	public void push(int element) {
		// 차있는지 확인
		if (isFull()) {
			return;
		}
		this.elements[++top] = element;
	}

	public int pop() {
		// 비어있는지 확인
		if (isEmpty()) {
			return 0;
		}
		this.elements[this.top] = 0; // 삭제, 즉 배열에서 0으로 만듦
		int poppedElement = this.elements[this.top--];
		return poppedElement;
	}

}

public class _8931_제로_ArrayStack {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine()); // 테스트 케이스의 개수

		for (int tc = 1; tc <= T; tc++) { // 2개
			int K = Integer.parseInt(br.readLine()); // 테스트 케이스 당 주어지는 정수의 개수
			int sum = 0;

			ArrayStack arrayStack = new ArrayStack(K); // 배열로 구현한 스택

			for (int k = 0; k < K; k++) { // 6개
				int input = Integer.parseInt(br.readLine());

				if (input == 0) {
					// Stack에서 pop 한다
					arrayStack.pop();
				} else {
					// Stack에 push한다
					arrayStack.push(input);
				}
			}
			// stack에 남아있는 원소들을 더한다
			for (int i : arrayStack.elements) {
				sum += i;
			}

			System.out.printf("#%d %d\n", tc, sum);

		}
	}

}
