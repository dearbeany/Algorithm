package swea.d4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class _1231_중위순회_스택 {
	static class Node {
		String data;
		Node leftChild;
		Node rightChild;
		boolean isSecond;

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

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		BinaryTree tree = new BinaryTree();

		int N = Integer.parseInt(br.readLine());

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			st.nextToken(); // 정점 인덱스
			tree.push(st.nextToken());
		}
		Stack<Node> stack = new Stack<>();
		stack.push(tree.head);

		while (!stack.empty()) {
			Node n = stack.pop();
			if (n.isSecond)
				System.out.println(n.data);
			else {
				if (n.rightChild != null)
					stack.push(n.rightChild); // right 넣고
				stack.push(n); // root 넣고
				if (n.leftChild != null)
					stack.push(n.leftChild); // left 넣음
			}
			n.isSecond = true;
		}
	}
}
