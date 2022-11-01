package boj.gold.implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 지도 위에서 주사위를 굴린다 
 * 처음 주사위는 모든 면이 0 
 * 지도 각 칸은 정수가 적혀있고, 주사위 굴릴 때 
 * 이동한 칸 == 0 ? 주사위 바닥수가 칸에 복사 
 * 이동한 칸 != 0 ? 칸에 있는 수가 주사위 바닥에 복사, 칸은 0 
 * 주사위 이동 마다 윗면의 숫자를 출력 
 */
public class _14499_주사위굴리기 {
	static int n, m, x, y, k;
	static int[][] map;
	static int[] cmd, dice;
	// 동 서 북 남
	static int[][] drc = { { 0, 0 }, { 0, 1 }, { 0, -1 }, { -1, 0 }, { 1, 0 } };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken()); // 세로
		m = Integer.parseInt(st.nextToken()); // 가로

		map = new int[n][m];

		x = Integer.parseInt(st.nextToken()); // x좌표
		y = Integer.parseInt(st.nextToken()); // y좌표
		k = Integer.parseInt(st.nextToken()); // 명령 개수
		cmd = new int[k];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < k; i++) {
			cmd[i] = Integer.parseInt(st.nextToken());
		}

		dice = new int[7]; // 0번은 비워놓자. 처음은 모두 값이 0으로 시작

		int cx = x;
		int cy = y;

		// 처음 시작 (x, y)
		// 동 = 1 서 = 2 북= 3 남= 4
		for (int i = 0; i < k; i++) {
			int nx = cx + drc[cmd[i]][0];
			int ny = cy + drc[cmd[i]][1];

			if (!is_in(nx, ny)) {
				continue;
			}

			roll(cmd[i], nx, ny);
			cx = nx;
			cy = ny;
		}
	}

//	주사위처음		동			서			남			북 
//	 2			2			2			6			1
//	413		   641		   136		   423		   453
//	 5			5			5			1			6
//	 6			3			4			5			2
	private static void roll(int dir, int nx, int ny) {
		int tmp = dice[1]; // 맨 위값 저장
		switch (dir) {
		case 1: // 동
			dice[1] = dice[3];
			dice[3] = dice[6];
			dice[6] = dice[4];
			dice[4] = tmp;
			break;

		case 2: // 서
			dice[1] = dice[4];
			dice[4] = dice[6];
			dice[6] = dice[3];
			dice[3] = tmp;
			break;

		case 3: // 북
			dice[1] = dice[2];
			dice[2] = dice[6];
			dice[6] = dice[5];
			dice[5] = tmp;
			break;

		case 4: // 남
			dice[1] = dice[5];
			dice[5] = dice[6];
			dice[6] = dice[2];
			dice[2] = tmp;
			break;
		}
		if (map[nx][ny] == 0) {
			// 0이면 주사위 바닥 수가 맵으로 복사
			map[nx][ny] = dice[6];
		} else {
			// 0 아니면 맵에 있는 수가 주사위 바닥으로 복사, 맵은 0
			dice[6] = map[nx][ny];
			map[nx][ny] = 0;
		}
		System.out.println(dice[1]);
	}

	private static boolean is_in(int x, int y) {
		return x >= 0 && y >= 0 && x < n && y < m;
	}
}
