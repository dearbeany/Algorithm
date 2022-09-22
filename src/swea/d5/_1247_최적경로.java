package swea.d5;

import java.util.Scanner;

/*
 * 1. 고객들을 순열로 뽑아서 모두 방문해본다 
 * 2. 회사 -> 고객들 -> 집 까지의 최단이동거리를 구한다 
 * 3. 가지치기를 통해 최적화 가능
 * 	  (현재까지 구한 거리 > minDis) 더 크다면 상태공간트리에서 더이상 내려가지 않는다 -> 백트래킹
 * 
 */
public class _1247_최적경로 {
	static class Node {
		int x;
		int y;

		Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	static int N, minDis; // 고객의 수, 최단 이동거리
	static Node com, home;
	static boolean[] visited; // 방문했는지
	static Node[] clist; // 고객 리스트

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {
			N = sc.nextInt(); // 고객의 수

			com = new Node(sc.nextInt(), sc.nextInt());
			home = new Node(sc.nextInt(), sc.nextInt());

			clist = new Node[N];
			visited = new boolean[N];

			minDis = Integer.MAX_VALUE;

			for (int i = 0; i < N; i++) {
				clist[i] = new Node(sc.nextInt(), sc.nextInt());
			}

			// 이동거리는 회사 -> 고객 1~n -> 집이므로
			// 회사에서부터 시작
			perm(0, com, 0);
			System.out.printf("#%d %d\n", tc, minDis);
		}
	}

	// 고객들을 순열로 나열하고
	// 회사 - 고객1~n- 집 - 고객 이동거리를 계산한다
	static void perm(int idx, Node curr, int dis) {
		if (dis >= minDis) { // 백트래킹
			return;
		}
		// 다 고르면
		if (idx == N) {
			dis += getDist(curr, home); // 마지막 고객부터 집까지 거리 더한다
			minDis = Math.min(minDis, dis);
			return;
		}

		for (int i = 0; i < N; i++) {
			if (!visited[i]) { // 방문 안했으면
				visited[i] = true; // 쓰고
				perm(idx + 1, clist[i], dis + getDist(curr, clist[i])); // 내려가서 이동거리 구하기
				visited[i] = false; // 안 썼다
			}
		}
	}

	static int getDist(Node a, Node b) {
		return Math.abs(a.x - b.x) + Math.abs(a.y - b.y);
	}
}
