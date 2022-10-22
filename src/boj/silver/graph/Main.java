package boj.silver.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/*
 * 늑대와 양
 */
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int r, c;
	static char[][] map;
	static boolean flag = true;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };
	static Queue<int[]> q = new LinkedList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());

		map = new char[r][c];

		for (int i = 0; i < r; i++) {
			String s = br.readLine();
			for (int j = 0; j < c; j++) {
				map[i][j] = s.charAt(j);
				if (map[i][j] == 'W')
					q.add(new int[] { i, j });
			}
		}
		bfs();
		if (flag) {
			System.out.println("1");
			for (int i = 0; i < map.length; i++) {
				for (int j = 0; j < map[0].length; j++) {
					System.out.print(map[i][j]);
				}
				System.out.println();
			}
		} else
			System.out.println("0");
	}

	public static void bfs() {
		while (!q.isEmpty()) {
			int[] t = q.poll();
			for (int i = 0; i < 4; i++) {
				int nx = t[0] + dx[i];
				int ny = t[1] + dy[i];

				if (nx >= 0 && ny >= 0 && nx < r && ny < c) {
					if (map[nx][ny] == '.')
						map[nx][ny] = 'D';
					else if (map[nx][ny] == 'S') {
						flag = false;
						return;
					}
				}
			}
		}
	}

}
