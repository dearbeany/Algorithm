package boj.silver.graph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class _1697_숨바꼭질 {
	static int N, K;
	static final int MAX = 100001;
	static int[] time;
	static Queue<Integer> q;
	static int[] dx = { -1, 1 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt(); // 내 위치
		K = sc.nextInt(); // 동생 위치

		// 내가 동생 찾는 가장 빠른 시간 ?
		// -1, +1, 순간이동 시 2*X만큼 이동
		time = new int[MAX]; // n 위치까지의 걸린 시간

		if (N >= K) { // 내가 동생보다 크면 무조건 -1만 하다가 만나야 한다
			System.out.println(N - K);
		} else {
			bfs(N);
		}
	}

	private static void bfs(int n) {
		q = new LinkedList<>();
		q.add(n);
		time[n] = 1; // 시작 위치에서의 시간

		while (!q.isEmpty()) {
			int curr = q.poll();

			for (int i = 0; i < 3; i++) {
				int nx = (i == 2) ? 2 * curr : curr + dx[i];

				if (nx == K) {
					System.out.println(time[curr]);
					return;
				}

				if (nx >= 0 && nx < MAX && time[nx] == 0) {
					q.add(nx);
					time[nx] = time[curr] + 1;
				}
			}
		}
	}
}
