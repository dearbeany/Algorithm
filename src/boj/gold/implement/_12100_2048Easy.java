package boj.gold.implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 2048게임에서 최대 5번 이동시켜 얻을 수 있는 가장 큰 블록?
 * 전체 블록은 상하좌우 중 하나로 움직임 
 * 같은 값 블록 충돌하면 하나로 합쳐짐   
 */
public class _12100_2048Easy {
	static int n, res;
	static int[][] map, tmp, result;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		n = Integer.parseInt(br.readLine());

		map = new int[n][n];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		// 최대 5번 상, 하, 좌, 우 이동 가능
		tmp = new int[n][n];

		dfs(0, map);
		print(tmp);
		System.out.println(res);

	}

	private static void dfs(int idx, int[][] map) {
		if (idx == 5) {
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					res = Math.max(res, result[i][j]); // 가장 큰 값 찾기
				}
			}
			return;
		}

		for (int d = 0; d < 4; d++) {
			result = play(d, map);
			dfs(idx + 1, result);
		}
	}

	private static int[][] play(int dir, int[][] map) {
		tmp = new int[n][n];

		switch (dir) {
		case 0: // 상
			for (int i = 0; i < n; i++) {
				int baseBlock = 0; // 가장 최근 숫자, 값은 값 오기를 기다려
				int idx = 0; // tmp배열에 값을 넣을 위치
				// 열 우선 탐색을 할 거야 위 -> 아래로
				for (int j = 0; j < n; j++) {
					if (map[j][i] != 0) { // 뭔가 숫자가 있을 때
						if (baseBlock == map[j][i]) { // 같은 값 충돌 ??
							tmp[idx - 1][i] += baseBlock; // 합쳐줘
							baseBlock = 0; // 합쳤으니깐 다시 처음부터 세팅
						} else {
							baseBlock = map[j][i]; // 일단 이전값 저장
							tmp[idx][i] = baseBlock; // tmp에 그 값 저장해주고
							idx++; // 값 저장해줬으니까 위치+1
						}
					} else {
						// map의 숫자가 0이면 그냥 넘기면 되지
					}
				}
			}
			break;
		case 1: // 하
			for (int i = 0; i < n; i++) {
				int baseBlock = 0; // 가장 최근 숫자, 값은 값 오기를 기다려
				int idx = n - 1; // tmp배열에 값을 넣을 위치
				// 열 우선 탐색을 할 거야 아래 -> 위로
				for (int j = n - 1; j >= 0; j--) {
					if (map[j][i] != 0) { // 뭔가 숫자가 있을 때
						if (baseBlock == map[j][i]) { // 같은 값 충돌 ??
							tmp[idx + 1][i] += baseBlock; // 이전 값이랑 합쳐줘
							baseBlock = 0; // 합쳤으니깐 다시 처음부터 세팅
						} else {
							baseBlock = map[j][i]; // 일단 이전값 저장
							tmp[idx][i] = baseBlock; // tmp에 그 값 저장해주고
							idx--; // 값 저장해줬으니까 위치+1
						}
					} else {
						// map의 숫자가 0이면 그냥 넘기면 되지
					}
				}
			}
			break;
		case 2: // 왼쪽으로 밀기
			for (int i = 0; i < n; i++) {
				int baseBlock = 0; // 가장 최근 숫자, 값은 값 오기를 기다려
				int idx = 0; // tmp배열에 값을 넣을 위치
				// 열 우선 탐색을 할 거야 좌 -> 우로
				for (int j = 0; j < n; j++) {
					if (map[i][j] != 0) { // 뭔가 숫자가 있을 때
						if (baseBlock == map[i][j]) { // 같은 값 충돌 ??
							tmp[i][idx - 1] += baseBlock; // 이전 값이랑 합쳐줘
							baseBlock = 0; // 합쳤으니깐 다시 처음부터 세팅
						} else {
							baseBlock = map[i][j]; // 일단 이전값 저장
							tmp[i][idx] = baseBlock; // tmp에 그 값 저장해주고
							idx++; // 값 저장해줬으니까 위치+1
						}
					} else {
						// map의 숫자가 0이면 그냥 넘기면 되지
					}
				}
			}
			break;
		case 3: // 오른쪽으로 밀기
			for (int i = 0; i < n; i++) {
				int baseBlock = 0; // 가장 최근 숫자, 값은 값 오기를 기다려
				int idx = n - 1; // tmp배열에 값을 넣을 위치
				// 행 우선 탐색을 할 거야 우-> 좌로
				for (int j = n - 1; j >= 0; j--) {
					if (map[i][j] != 0) { // 뭔가 숫자가 있을 때
						if (baseBlock == map[i][j]) { // 같은 값 충돌 ??
							tmp[i][idx + 1] += baseBlock; // 이전 값이랑 합쳐줘
							baseBlock = 0; // 합쳤으니깐 다시 처음부터 세팅
						} else {
							baseBlock = map[i][j]; // 일단 이전값 저장
							tmp[i][idx] = baseBlock; // tmp에 그 값 저장해주고
							idx--; // 값 저장해줬으니까 위치-1
						}
					} else {
						// map의 숫자가 0이면 그냥 넘기면 되지
					}
				}
			}
			break;
		}
		return tmp;
	}

	private static void print(int[][] arr) {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	}

}
