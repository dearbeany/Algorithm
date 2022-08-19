package swea.d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _1225_암호생성기_LinkedQueue {
	// 내부클래스로 작성할 것
	static class Node {
		int data;
		Node link;

		Node(int data) {
			this.data = data;
		}

		Node(int data, Node link) {
			this.data = data;
			this.link = null;
		}
	}

	static class LinkedQueue {
		Node front;
		Node rear;
		int size;

		// isEmpty
		public boolean isEmpty() {
			return (front == null);
		}

		// enQueue
		// 맨 뒤에 삽입
		public boolean enQueue(int data) {
			Node newNode = new Node(data);

			if (size == 0) {
//				front = newNode;
//				rear = newNode;
				front = rear = newNode;
				size++;
				return true;
			}
			/*
			 * Node currentNode = front; while (currentNode.link != null) { currentNode =
			 * currentNode.link; }
			 * 
			 * currentNode.link = newNode; // currentNode는 현재 마지막노드임. newNode를 마지막에 삽입 rear
			 * = newNode;
			 */

			// LinkedQueue는 rear를 갖고 있기 때문에
			// 굳이 순차탐색을 하며 마지막노드를 찾아주지 않아도 됨
			rear.link = newNode;
			rear = newNode;

			size++;

			return true;
		}

		// deQueue
		// 맨 앞 삭제후 삭제한 원소 반환
		public int deQueue() {
			if (isEmpty()) { // 비어있다면
				return -1;
			} else { // 비어있지 않다면
				int deleteElement = front.data;
				front = front.link;

				size--;
				return deleteElement;
			}
		}

		// printQueue
		public void printQueue() {
			Node currentNode = front;
			if (!isEmpty()) {
				while (currentNode != null) {
					System.out.print(currentNode.data + " "); // 현재 노드를 먼저 출력해주고
					currentNode = currentNode.link; // 다음 노드로 이동
				}
				System.out.println();
			}

		}
	}

// 10 6 12 8 9 4 1 3	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		for (int tc = 1; tc <= 10; tc++) {
			Integer.parseInt(br.readLine()); // 테스트 케이스

			st = new StringTokenizer(br.readLine());
			LinkedQueue queue = new LinkedQueue();

			for (int i = 0; i < 8; i++) {
				queue.enQueue(Integer.parseInt(st.nextToken()));
			}

			boolean flag = false;
			while (true) {
				if (flag) { // while문 탈출, 프로그램 종료
					break;
				}
				for (int i = 1; i <= 5; i++) {
					int data = queue.deQueue(); // 첫번째 숫자 삭제

					if (data - i > 0) {
						queue.enQueue(data - i); // 첫번째 숫자 i만큼 감소 후 맨 뒤 삽입

					} else { // 0보다 작거나 같으면
						data = 0;
						queue.enQueue(data);
						flag = true; // 맨뒤 0이 삽입되며 while문 종료
						break; // for문 탈출
					}
				}
			}
			System.out.printf("#%d ", tc);
			queue.printQueue();

		}
	}
}
