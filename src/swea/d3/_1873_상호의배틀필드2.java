package swea.d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _1873_상호의배틀필드2 {
	static int H; // 맵 높이
	static int W; // 맵 너비
	static char map[][];
	static int N; // 사용자 입력 문자의 길이
	static String cmd; // 사용자 명령

	// 전차의 이동 (단, 평지라면)
	// 상 하 좌 우
	// U D L R
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine()); // 테케

		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			H = Integer.parseInt(st.nextToken()); // 맵의 높이
			W = Integer.parseInt(st.nextToken()); // 맵의 너비

			// 게임 맵 세팅
			map = new char[H][W];
			for (int i = 0; i < H; i++) {
				String str = br.readLine();
				for (int j = 0; j < W; j++) {
					map[i][j] = str.charAt(j);
				}
			}

			N = Integer.parseInt(br.readLine()); // 사용자 입력의 개수
			cmd = br.readLine(); // 사용자 입력

			// 전차 위치 찾기
			for (int i = 0; i < H; i++) {
				for (int j = 0; j < W; j++) {
					for (int k = 0; k < N; k++) { // 사용자 입력에 따른 이동
						char move = cmd.charAt(k);
						int dir = 0;
						switch (map[i][j]) { // 현재 전차 위치

						case '^': // 전차가 위를 바라볼 때
							dir = 0;
							if (move == 'S') {
								shoot(i, j, dir);

							} else {
								turnDirection(i, j, move);
							}

						case 'v': // 전차가 하 방향
							dir = 1;
							if (move == 'S') {
								shoot(i, j, dir);

							} else {
								turnDirection(i, j, move);
							}

						case '<': // 전차가 좌 방향
							dir = 2;
							if (move == 'S') {
								shoot(i, j, dir);

							} else {
								turnDirection(i, j, move);
							}

							break;

						case '>': // 전차가 우 방향
							dir = 3;
							if (move == 'S') {
								shoot(i, j, dir);
							} else {
								turnDirection(i, j, move);
							}
							break;

						}
					}
				}
			}

			for (char[] ar : map) {
				for (char a : ar) {
					System.out.print(a + " ");
				}
				System.out.println();
			}
		}

	}

	// 전차가 바라보는 방향으로 포탄 발사
	// 벽돌 * -> 평지 .
	// 강철 # -> 아무변화X
	private static void shoot(int i, int j, int dir) {
		int r = 1;
		while (true) {
			int nx = i + r * dx[dir];
			int ny = j + r * dy[dir];
			if (nx < 0 || nx >= H || ny < 0 || ny >= W) {
				break;
			}
			if (map[nx][ny] == '#') {
				break;
			}
			if (map[nx][ny] == '*') {
				map[nx][ny] = '.';
			}
			r++;
		}

	}

	private static void turnDirection(int i, int j, char move) {
		int dir = 0, nx = 0, ny = 0;

		switch (move) {
		case 'U':
			map[i][j] = '^';
			dir = 0;
			nx = i + dx[dir];
			ny = j + dy[dir];

			if (nx < 0 || nx >= H || ny < 0 || ny >= W) {
				break;
			}
			if (map[nx][ny] == '.') { // 바로 위칸 평지면
				map[nx][ny] = map[i][j]; // 위칸으로 전차 이동
				map[i][j] = '.';
			}

			break;
		case 'D':
			map[i][j] = 'v';

			dir = 1;
			nx = i + dx[dir];
			ny = j + dy[dir];

			if (nx < 0 || nx >= H || ny < 0 || ny >= W) {
				break;
			}
			if (map[nx][ny] == '.') { // 바로 위칸 평지면
				map[nx][ny] = map[i][j]; // 위칸으로 전차 이동
				map[i][j] = '.';
			}

			break;
		case 'L':
			map[i][j] = '<';

			dir = 2;
			nx = i + dx[dir];
			ny = j + dy[dir];

			if (nx < 0 || nx >= H || ny < 0 || ny >= W) {
				break;
			}
			if (map[nx][ny] == '.') { // 바로 위칸 평지면
				map[nx][ny] = map[i][j]; // 위칸으로 전차 이동
				map[i][j] = '.';
			}

			break;
		case 'R':
			map[i][j] = '>';

			dir = 3;
			nx = i + dx[dir];
			ny = j + dy[dir];

			if (nx < 0 || nx >= H || ny < 0 || ny >= W) {
				break;
			}
			if (map[nx][ny] == '.') { // 바로 위칸 평지면
				map[nx][ny] = map[i][j]; // 위칸으로 전차 이동
				map[i][j] = '.';
			}

			break;
		}

	}

}
