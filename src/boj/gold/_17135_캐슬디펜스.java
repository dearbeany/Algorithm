package boj.gold;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class _17135_캐슬디펜스 {
	static class Node {
		int r, c;

		Node(int r, int c) {
			this.r = r;
			this.c = c;
		}

		@Override
		public String toString() {
			return "Node [r=" + r + ", c=" + c + "]";
		}
	}

	static int n, m, D, kill;// 격자판크기, 공격제한 , 적제거 수
	static int[][] map; // 격자판
	static boolean[][] visited;
	static Queue<Node> q;
	static int[][] drc = { { -1, 0 }, { -1, 1 }, { 0, 1 }, { 1, 1 }, { 1, 0 }, { 1, -1 }, { 0, -1 }, { -1, -1 } };

	public static void main(String[] args) {
		// NxM 격자판, D공격제한
		// 0 = 빈칸, 1 = 적
		// 궁수 3명 동시 공격
		// D이하에서 가장 가까운 적. 적 여럿이면 가장 왼쪽 공격 -> 공격받으면 0으로 바꿔줌
		// 공격 끝나면 적은 아래이동. 격자판 벗어나면 게임 끝
		// 궁수 공격으로 제거할 수 있는 적의 최대 수?
//		Scanner sc = new Scanner(System.in);
		Scanner sc = new Scanner(input2);
		n = sc.nextInt();
		m = sc.nextInt();
		D = sc.nextInt();

		map = new int[n][m];
		visited = new boolean[n][m];
		q = new LinkedList<>();
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				map[i][j] = sc.nextInt();
				if (map[i][j] == 1) { // 적들은 다 큐에 넣는다
					q.add(new Node(i, j));
				}
			}
		}
		// 1을 최대한 많이 제거해야하니까
		// 큐에 있는 걸 3개 꺼내서 d이하로 인접한 1들을 제거한다.

		bfs();
		System.out.println(kill);

	}

	private static void bfs() {
		while (!q.isEmpty()) {
			Node curr = q.poll();
			map[curr.r][curr.c] = 0; // 1인데에서 꺼냈으니
			kill++; // 적 제거했으니까
			visited[curr.r][curr.c] = true;
			print();
			System.out.println("------------");

			if (isFinished()) { // 적이 아무도 없으면 종료
				return;
			}

			for (int d = 0; d < 8; d++) {
				int nr = curr.r + drc[d][0];
				int nc = curr.c + drc[d][1];
				int dist = Math.abs(nr - curr.r) + Math.abs(nc - curr.c);

				if (dist > D) { // 두점 사이 거리가 공격제한 넘어가면 패스
					continue;
				}

				if (!is_in(nr, nc) || map[nr][nc] == 0 || visited[nr][nc]) {
					continue;
				}
				q.add(new Node(nr, nc));
				// 행을 하나씩 밀려야 함
				rowDown();

			}
		}

	}

	private static void rowDown() {

	}

	private static void print() {
		for (int[] m : map) {
			System.out.println(Arrays.toString(m));
		}
	}

	private static boolean is_in(int r, int c) {
		return (r >= 0 && c >= 0 && r < n && c < n);
	}

	private static boolean isFinished() {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (map[i][j] == 1) {
					return false;
				}
			}
		}
		return true;
	}

	static String input = "5 5 5\r\n" + "1 1 1 1 1\r\n" + "1 1 1 1 1\r\n" + "1 1 1 1 1\r\n" + "1 1 1 1 1\r\n"
			+ "1 1 1 1 1";
	static String input2 = "5 5 1\r\n" + "0 0 0 0 0\r\n" + "0 0 0 0 0\r\n" + "0 0 0 0 0\r\n" + "1 1 1 1 1\r\n"
			+ "0 0 0 0 0";
//	static String input2 = "6 5 1\r\n" + "1 0 1 0 1\r\n" + "0 1 0 1 0\r\n" + "1 1 0 0 0\r\n" + "0 0 0 1 1\r\n"
//			+ "1 1 0 1 1\r\n" + "0 0 1 0 0";
}
