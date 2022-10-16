package swea.d4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * 미로의 출발점부터 도착점까지 갈 수 있는지? 
 */
public class _1226_미로1 {
	static int[][] map;
	static int[][] drc = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
	static boolean[][] visited;
	static int res;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = 10;

		for (int tc = 1; tc <= T; tc++) {
			Integer.parseInt(br.readLine());
			map = new int[16][16];
			visited = new boolean[16][16];

			for (int i = 0; i < 16; i++) {
				String str = br.readLine();
				for (int j = 0; j < 16; j++) {
					map[i][j] = str.charAt(j) - '0';
				}
			}
			// (1,1) 시작점 (13,13) 도착점
			// 1=벽, 0=길, 2=출발점, 3=도착점
			res = 0;
			dfs(1, 1);
			System.out.printf("#%d %d\n", tc, res);
		}

	}

	private static void dfs(int r, int c) {
		visited[r][c] = true;

		for (int d = 0; d < 4; d++) {
			int nr = r + drc[d][0];
			int nc = c + drc[d][1];

			// 도착점 만나면 멈추고
			if (map[nr][nc] == 3) {
				res = 1;
				return;
			}

			// 맵 범위 안에 있고, 0길이고, 방문 안했다면
			// dfs 돌자
			if (is_in(nr, nc) && map[nr][nc] == 0 && !visited[nr][nc]) {
				dfs(nr, nc);
			}
		}
	}

	private static boolean is_in(int r, int c) {
		return r >= 0 && c >= 0 && r < 16 && c < 16;
	}

}
