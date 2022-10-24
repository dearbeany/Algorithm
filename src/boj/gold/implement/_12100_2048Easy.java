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
	static int n;
	static int[][] map;

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
		moveUp();
		print();

	}

	private static void moveUp() {
		// 전체 위로 이동했을 때 같은값 충돌하면 합쳐짐
		// 위쪽에 있는 블록이 먼저 합쳐진다
		for (int i = 0; i < n; i++) {
			int idx = 0; // 값을 넣을 위치
			int block = 0; // 블록에 담긴 숫자
			for (int j = 0; j < n; j++) {
				if (map[j][i] != 0) {
					if (block == map[j][i]) {
						map[idx - 1][i] = block * 2;
						block = 0;
						map[j][i] = 0;
					} else {

					}
				}
			}
		}

	}

	private static void print() {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
	}

}
