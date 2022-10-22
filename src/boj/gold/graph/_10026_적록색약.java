package boj.gold.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * 적록색약 아닌 사람, 적록색약인 사람이 본 구역의 수를 출력 
 * 적록색약인 사람은 RG를 합쳐서 본다 
 */
public class _10026_적록색약 {
	static int n, area, rArea;
	static int[][] map, rMap;
	static boolean[][] visited, rVisited;
	static int[][] drc = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());

		map = new int[n][n]; // 적록색약 아닌 사람
		rMap = new int[n][n]; // 적록색약인 사람 R과 G를 같은 값으로 세팅

		visited = new boolean[n][n];
		rVisited = new boolean[n][n];

		// R=0, G=1, B=2
		for (int i = 0; i < n; i++) {
			String str = br.readLine();
			for (int j = 0; j < n; j++) {
				switch (str.charAt(j)) {
				case 'R':
					map[i][j] = 0;
					rMap[i][j] = 0;
					break;
				case 'G':
					map[i][j] = 1;
					rMap[i][j] = 0;
					break;
				case 'B':
					map[i][j] = 2;
					rMap[i][j] = 2;
					break;
				}
			}
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (!visited[i][j]) {
					area++;
					dfs(i, j, map[i][j]);
				}
				if (!rVisited[i][j]) {
					rArea++;
					rDfs(i, j, rMap[i][j]);
				}
			}
		}
		System.out.println(area + " " + rArea);
//		print();
	}

	// 적록색약인 사람
	private static void rDfs(int r, int c, int num) {
		rVisited[r][c] = true;

		for (int i = 0; i < 4; i++) {
			int nr = r + drc[i][0];
			int nc = c + drc[i][1];

			// 범위 안에 있고, num과 같으면 같은 구역
			if (is_in(nr, nc) && rMap[nr][nc] == num && !rVisited[nr][nc]) {
				rDfs(nr, nc, num);
			}
		}
	}

	// 적록색약 아닌 사람
	private static void dfs(int r, int c, int num) {
		visited[r][c] = true;

		for (int i = 0; i < 4; i++) {
			int nr = r + drc[i][0];
			int nc = c + drc[i][1];

			// 범위 안에 있고, num과 같으면 같은 구역
			if (is_in(nr, nc) && map[nr][nc] == num && !visited[nr][nc]) {
				dfs(nr, nc, num);
			}
		}
	}

	private static boolean is_in(int r, int c) {
		return r >= 0 && c >= 0 && r < n && c < n;
	}

	private static void print() {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
//				int a = visited[i][j] ? 1 : 0;
//				System.out.print(a);
				System.out.print(rMap[i][j]);
			}
			System.out.println();
		}
	}
}
