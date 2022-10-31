package boj.gold.implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class _3190_뱀 {
	static class Pos {
		int x, y;

		Pos(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	static int N, K, L;
	static int[][] map;
	static List<Pos> dir, snake;
	static int playTime; // 플레이 시간

	static int idx = 0; // 맨 처음 오른쪽, 우 하 좌 상, D오면 idx++, L오면 idx--
	static int[][] drc = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine()); // 맵 크기
		K = Integer.parseInt(br.readLine()); // 사과 개수

		// 맵 세팅
		map = new int[N + 1][N + 1];
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			map[x][y] = 1; // x행 y열 사과 있음
		}

		// 방향 정보
		L = Integer.parseInt(br.readLine()); // 방향 변환 횟수
		dir = new ArrayList<>(); // 방향 리스트

		for (int i = 0; i < L; i++) {
			st = new StringTokenizer(br.readLine());
			int t = Integer.parseInt(st.nextToken()); // 게임 시작하고 몇 초 지난 후
			int d = st.nextToken().equals("D") ? 0 : 1;
			dir.add(new Pos(t, d));
		}

		snake = new ArrayList<>(); // 뱀 위치
		snake.add(new Pos(1, 1)); // 1,1 시작

		playTime = 0;
		int x = 1, y = 1; // 처음 시작점
		int nx, ny;

		while (true) {
			playTime++; // 게임 시작했으니 초 증가

			// 머리
			nx = x + drc[idx][0];
			ny = y + drc[idx][1];

			// 범위 벗어나거나 몸 닿으면 끝
			if (isGameOver(nx, ny)) {
				break;
			}

			// snake 꼬리 ---- 뱀
			if (map[nx][ny] == 1) { // 사과 있으면
				map[nx][ny] = 0; // 사과 먹고
				snake.add(new Pos(nx, ny)); // 머리 늘려
			} else {
				// 사과 없으면
				snake.add(new Pos(nx, ny)); // 머리 늘리고
				snake.remove(0); // 꼬리 비우기
			}

			// 위치 갱신해주고
			x = nx;
			y = ny;

			// 시간 끝나면 방향 전환
			for (int i = 0; i < dir.size(); i++) {
				if (dir.get(i).x == playTime) { // x초 후 오른쪽으로 90도 전환
					if (dir.get(i).y == 0) { // 오른쪽이면
						idx++;
						idx = idx == 4 ? 0 : idx; // 우 하 좌 상
					} else { // 왼쪽이면
						idx--;
						idx = idx == -1 ? 3 : idx; // 상 좌 하 우
					}
				}
			}
		}
		System.out.println(playTime);
	}

	private static boolean isGameOver(int nx, int ny) {
		// 범위 벗어나거나
		if (nx < 1 || ny < 1 || nx >= N + 1 || ny >= N + 1) {
			return true;
		}

		// 자기 몸통 닿거나
		for (int i = 0; i < snake.size(); i++) {
			if (nx == snake.get(i).x && ny == snake.get(i).y) {
				return true;
			}
		}
		return false;
	}

	private static void print() {
		// TODO Auto-generated method stub
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}

	}

}
