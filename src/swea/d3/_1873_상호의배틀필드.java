package swea.d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _1873_상호의배틀필드 {
	static int H; // 맵 높이
	static int W; // 맵 너비
	static char map[][];
	static int N; // 사용자 입력 문자의 길이
	static String command; // 사용자 명령

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
			command = br.readLine(); // 사용자 입력

			int x = 0, y = 0, d = 0;
			// 전차 위치 찾기
			Loop1: for (int i = 0; i < H; i++) {
				for (int j = 0; j < W; j++) {
					switch (map[i][j]) { // 현재 전차 위치

					case '^': // 전차가 위를 바라볼 때
						x = i;
						y = j;
						d = 0;
						break Loop1;

					case 'v': // 전차가 하 방향
						x = i;
						y = j;
						d = 1;
						break Loop1;

					case '<': // 전차가 좌 방향
						x = i;
						y = j;
						d = 2;
						break Loop1;

					case '>': // 전차가 우 방향
						x = i;
						y = j;
						d = 3;
						break Loop1;

					} // switch
				} // j 루프
			} // i번째 루프

			for (int i = 0; i < command.length(); i++) {
				char cmd = command.charAt(i);

				int nx = 0, ny = 0;

				switch (cmd) {

				case 'S':
					nx = x + dx[d];
					ny = y + dy[d];

					while (true) {
						if (nx < 0 || nx >= H || ny < 0 || ny >= W) {
							break;
						}
						if (map[nx][ny] == '#') {
							break;

						} else if (map[nx][ny] == '*') {
							map[nx][ny] = '.';
							break;

						} else {
							nx = nx + dx[d];
							ny = ny + dy[d];
						}
					}
					break;

				case 'U':
					d = 0;
					map[x][y] = '^';
					nx = x + dx[d];
					ny = y + dy[d];

					if (nx < 0 || nx >= H) {
						break;
					}
					if (map[nx][ny] == '.') { // 다음 칸이 평지면
						map[nx][ny] = map[x][y]; // 전차를 다음칸으로 이동
						map[x][y] = '.'; // 전차 있던 칸은 평지로 변경
						x = nx;
						y = ny;
					}

					break;

				case 'D':
					d = 1;
					map[x][y] = 'v';
					nx = x + dx[d];
					ny = y + dy[d];

					if (nx < 0 || nx >= H) {
						break;
					}
					if (map[nx][ny] == '.') { // 다음 칸이 평지면
						map[nx][ny] = map[x][y]; // 전차를 다음칸으로 이동
						map[x][y] = '.'; // 전차 있던 칸은 평지로 변경
						x = nx;
						y = ny;
					}
					break;

				case 'L':
					d = 2;
					map[x][y] = '<';
					nx = x + dx[d];
					ny = y + dy[d];

					if (ny < 0 || ny >= W) {
						break;
					}
					if (map[nx][ny] == '.') { // 다음 칸이 평지면
						map[nx][ny] = map[x][y]; // 전차를 다음칸으로 이동
						map[x][y] = '.'; // 전차 있던 칸은 평지로 변경
						x = nx;
						y = ny;
					}
					break;

				case 'R':
					d = 3;
					map[x][y] = '>';
					nx = x + dx[d];
					ny = y + dy[d];

					if (ny < 0 || ny >= W) {
						break;
					}
					if (map[nx][ny] == '.') { // 다음 칸이 평지면
						map[nx][ny] = map[x][y]; // 전차를 다음칸으로 이동
						map[x][y] = '.'; // 전차 있던 칸은 평지로 변경
						x = nx;
						y = ny;
					}
					break;
				}

			}
			System.out.print("#" + tc + " ");
			for (char[] ar : map) {
				for (char a : ar) {
					System.out.print(a);
				}
				System.out.println();
			}
		} // 테케

	}

}
