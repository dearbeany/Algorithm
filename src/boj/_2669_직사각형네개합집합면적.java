package boj;

import java.io.IOException;
import java.util.Scanner;

public class _2669_직사각형네개합집합면적 {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);

		int[][] arr = new int[100][100];

		int w = 0, h = 0;

		for (int tc = 0; tc < 4; tc++) { // 사각형의 개수 4개
			int[] rec = new int[4];
			for (int i = 0; i < 4; i++) { // 한 사각형의 위치 4개
				rec[i] = sc.nextInt();
			}
			// 입력 2 3 5 7 일 때
			w = rec[2] - rec[0]; // 너비 5-2 = 3
			h = rec[3] - rec[1]; // 높이 7-3 = 4

			// 사각형 왼쪽 아래 꼭짓점 x좌표 + w너비 == 직사각형의 가로
			// 사각형 왼쪽 아래 꼭짓점 y좌표 + h높이 == 직사각형의 세로
			for (int x = rec[0]; x < rec[0] + w; x++) {
				for (int y = rec[1]; y < rec[1] + h; y++) {
					arr[x][y] = 1;
				}
			}

		}

		int cnt = 0; // 1로 채워진 면적을 카운트
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				if (arr[i][j] == 1) {
					cnt++;
				}
			}
		}
		System.out.println(cnt);
	}
}
