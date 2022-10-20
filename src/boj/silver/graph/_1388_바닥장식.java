package boj.silver.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 필요한 나무판자의 개수를 카운트 
 * 행탐색/열탐색 각각 따로해서 판자가 이어질 때까지 1개 
 * '-'는 행탐색해서 옆으로만 가기
 * '|'는 열탐색해서 밑으로만 가기 
 */
public class _1388_바닥장식 {
	static int n, m, res; // 행개수, 열개수, 나무판자개수
	static char[][] map;
	static boolean[][] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		map = new char[n][m];
		visited = new boolean[n][m];

		for (int i = 0; i < n; i++) {
			String str = br.readLine();
			for (int j = 0; j < m; j++) {
				map[i][j] = str.charAt(j);
			}
		}
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (map[i][j] == '-' && !visited[i][j]) {
					res++;
					rowDfs(i, j);
				} else if (map[i][j] == '|' && !visited[i][j]) {
					res++;
					colDfs(i, j);
				}
			}
		}
		System.out.println(res);

	}

	// '|'의 개수 세기 열우선 탐색
	private static void colDfs(int r, int c) {
		visited[r][c] = true;

		if (r + 1 >= n) {
			return;
		}
		if (!visited[r + 1][c] && map[r + 1][c] == '|') {
			colDfs(r + 1, c);
		}
	}

	// '-'의 개수 세기 행우선탐색
	private static void rowDfs(int r, int c) {
		visited[r][c] = true;

		if (c + 1 >= m) {
			return;
		}
		if (!visited[r][c + 1] && map[r][c + 1] == '-') {
			rowDfs(r, c + 1);
		}
	}

//	static void print() {
//		for (int i = 0; i < n; i++) {
//			for (int j = 0; j < m; j++) {
//				int a = visited[i][j] ? 1 : 0;
//				System.out.print(a + " ");
//			}
//			System.out.println();
//		}
//	}
}
