package swea.d4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

/*
 * 중위순회 :Left - Root - Right
 * S O F T W A R E
 */
public class _1231_중위순회_반복과스택 {
	static class Node {
		String data;
		Node leftChild;
		Node rightChild;

		Node(String data) {
			this.data = data;
			this.leftChild = null;
			this.rightChild = null;
		}

		Node(String data, Node leftChild, Node rightChild) {
			this.data = data;
			this.leftChild = leftChild;
			this.rightChild = rightChild;
		}
	}

	static class BinaryTree {
		Node head;
		int size;

		public BinaryTree() {
			this.head = null;
			this.size = 0;
		}

		public void push(String data) {
			Node addNode = new Node(data);

			if (size == 0) {
				this.head = addNode;

			} else {

				Queue<Node> q = new LinkedList<>();
				q.add(head);

				while (!q.isEmpty()) { // 큐가 빌 때까지
					Node temp = q.poll(); // 큐에서 꺼냄

					if (temp.leftChild == null) { // 꺼낸노드의 left노드가 null이면
						temp.leftChild = addNode; // left에 삽입
						break;
					} else {
						q.add(temp.leftChild);
					}

					if (temp.rightChild == null) { // 꺼낸노드의 right노드가 null이면
						temp.rightChild = addNode; // rightChild에 삽입
						break;
					} else {
						q.add(temp.rightChild);
					}
				}
			}
			size++;
		}

	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = 10; // 테스트케이스

		for (int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine()); // 노드의 수
			StringBuilder sb = new StringBuilder();

			BinaryTree tree = new BinaryTree();
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				st.nextToken(); // 정점 인덱스
				tree.push(st.nextToken());
			}

			Stack<Node> stack = new Stack<>();
			Node nextNode = tree.head;

			while ((nextNode != null) || (!stack.isEmpty())) {

				// 스택에 left 노드가 없을 때까지 left노드를 스택에 push
				while (nextNode != null) { // L
					stack.push(nextNode);
					nextNode = nextNode.leftChild;
				}

				// 더이상 left 없으면 스택에서 pop하면서 root 노드를 가져옴
				// root노드의 right를 가져옴
				nextNode = stack.pop();
				sb.append(nextNode.data); // V
				nextNode = nextNode.rightChild; // R
			}

			System.out.printf("#%d %s\n", tc, sb);

		}
	}
}
