package boj.silver.greedy;

import java.util.Scanner;

public class _1783_병든나이트 {
	static int n, m;
	static int[][] drc = { { -2, 1 }, { -1, 2 }, { 1, 2 }, { 2, 1 } };

	public static void main(String[] args) {
		// 이동횟수 > 4 면? 병든 나이트 4번 다 이동해야
		// 이동횟수 <= 4 면? 방문한 칸 5개 미만
		// 병나가 방문할 수 있는 칸의 최대 개수

		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();

		int[][] map = new int[n][m];

		int cnt = 1; // 방문칸 개수
		int maxCnt = -1; // 방문할 수 있는 칸의 개수 중 최대값

		// n == 1 면 cnt ==1
		// n == 2 면 (-1,2) (1,2)로 왔다갔다 이동 m=1,3,5,7까지 갔을 때 최대 3이동
		// n == 3 면 (-2,1) (2,1)로 왔다갔다 이동 1,2,3,4,5,...
		// n == 4 면......

		if (n == 1) {
			cnt = 1;
		} else if (n == 2) {
			if (m <= 7) {
				cnt = (m + 1) / 2;
			}
		} else if (n == 3) {

		}

		System.out.println(cnt);

	}

}
