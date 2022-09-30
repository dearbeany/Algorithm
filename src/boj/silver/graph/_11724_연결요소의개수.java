package boj.silver.graph;

import java.util.Scanner;

public class _11724_연결요소의개수 {
	static int n, m; // 정점 개수, 간선개수
	static int[] parent;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();

		parent = new int[n + 1];
		for (int i = 1; i < n + 1; i++) {
			parent[i] = i;
		}

		for (int i = 0; i < m; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			union(a, b);
		}

		int cnt = 0; // 연결 요소의 개수
		for (int i = 1; i < n + 1; i++) {
			if (i == parent[i]) { // 부모배열이 나인 것만 그 집합의 루트
				cnt++; // 루트의 개수가 즉 연결요수의 개수다
			}
		}
		System.out.println(cnt);
	}

	private static void union(int a, int b) {
		int aRoot = findSet(a);
		int bRoot = findSet(b);

		if (aRoot != bRoot) {
			parent[bRoot] = aRoot;
		}
	}

	private static int findSet(int a) {
		if (a == parent[a]) {
			return a;
		} else {
			return findSet(parent[a]);
		}
	}

}
