package boj.silver.bruteforce;

import java.util.Scanner;

public class _10974_모든순열 {
	static int n;
	static int[] nums, res;
	static boolean[] visited;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();

		nums = new int[n];
		for (int i = 0; i < n; i++) {
			nums[i] = i + 1;
		}
		res = new int[n];
		visited = new boolean[n];

		perm(0);
	}

	private static void perm(int idx) {
		if (idx == n) {
			for (int i : res) {
				System.out.print(i + " ");
			}
			System.out.println();
			return;
		}

		for (int i = 0; i < n; i++) {
			if (!visited[i]) {
				res[idx] = nums[i];
				visited[i] = true;
				perm(idx + 1);
				visited[i] = false;
			}
		}
	}
}
