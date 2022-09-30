package boj.gold;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

import boj.gold._17135_캐슬디펜스.Node;

// 섬의개수, 단지번호 붙이기

public class _17472_다리만들기2 {
	static int n, m, island, land, vertexIdx;
	static int[][] map, copymap;
	static boolean[][] visited;
	static int[][] drc = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
	static List<Node>[] list;

	static String input = "7 8\r\n" + "0 0 0 0 0 0 1 1\r\n" + "1 1 0 0 0 0 1 1\r\n" + "1 1 0 0 0 0 0 0\r\n"
			+ "1 1 0 0 0 1 1 0\r\n" + "0 0 0 0 0 1 1 0\r\n" + "0 0 0 0 0 0 0 0\r\n" + "1 1 1 1 1 1 1 1";

	public static void main(String[] args) {
		Scanner sc = new Scanner(input);
		n = sc.nextInt(); // 세로크기
		m = sc.nextInt(); // 가로크기

		// 1이고 인접해있으면 union해서 하나의 섬(집합)으로 만든다

		map = new int[n][m];
		copymap = new int[n][m];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		visited = new boolean[n][m];

//		list = new ArrayList[island];

		System.out.println(island);
		print();

	}

	private static void bfs() {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (map[i][j] == 1) {
					island++;
					land++;

					Queue<Node> q = new LinkedList<>();
					q.add(new Node(i, j));
					map[i][j] = 0;
					copymap[i][j] = land;
//					visited[i][j] = true;
//					map[i][j] = land;

					while (!q.isEmpty()) {
						Node curr = q.poll();
						for (int d = 0; d < 4; d++) {
							int nr = curr.r + drc[d][0];
							int nc = curr.c + drc[d][1];

							if (!is_in(nr, nc) || map[nr][nc] == 0) {
								continue;
							}
							q.add(new Node(nr, nc));
							map[nr][nc] = 0;
							land++;
//							visited[nr][nc] = true;
//							copymap[i][j] = land;
						}
					}
				} // end of if
				land = 0;
			}
		}
	}

	private static boolean is_in(int r, int c) {
		return r >= 0 && c >= 0 && r < n && c < n;
	}

	private static void print() {
		for (int[] m : copymap) {
			for (int mm : m) {
				System.out.print(mm + " ");
			}
			System.out.println();
		}
	}

	private static void bprint() {
		for (boolean[] m : visited) {
			for (boolean mm : m) {
				int res = (mm == true) ? 1 : 0;
				System.out.print(res + " ");
			}
			System.out.println();
		}
	}

}
