package boj;

/*
 * 1. 이차원 배열을 탐색하면서 0에서 1로 1에서 0으로 바뀌는 순간이 둘레다
 * 2. 배열탐색시 가로 세로 길이 모두 고려한다 
 * 
 */
import java.util.Scanner;

public class _2567_색종이2_삼항연산자 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();

		int[][] arr = new int[101][101]; // 인덱스 넘어가는 경우를 고려하여 1크게 생성
		int x = 0, y = 0;

		for (int tc = 0; tc < N; tc++) {
			x = sc.nextInt();
			y = sc.nextInt();

			// 입력받은 색종이 칠하기
			for (int i = x; i < x + 10; i++) {
				for (int j = y; j < y + 10; j++) {
					arr[i][j] = 1;
				}
			}
		}

		// 배열을 탐색하면서
		// 0에서 1로, 1에서 0으로 바뀌면 둘레
		int len = 0;

		for (int i = 0; i < 100; i++) {
			for (int j = 0; j < 100; j++) {

				// 가로탐색
				// 현재위치 0 -> 다음위치 1
				if (arr[i][j] == 0 && arr[i][j + 1] == 1) {
					len++;
				}
				// 현재위치 1 -> 다음위치 0
				if (arr[i][j] == 1 && arr[i][j + 1] == 0) {
					len++;
				}
				// 세로탐색
				// 현재위치 0 -> 다음위치 1
				if (arr[j][i] == 0 && arr[j + 1][i] == 1) {
					len++;
				}
				// 현재위치 1 -> 다음위치 0
				if (arr[j][i] == 1 && arr[j + 1][i] == 0) {
					len++;
				}

				// 현재위치랑 다음위치랑 다르면 len++
//				len = (arr[i][j] != arr[i][j + 1]) ? len + 1 : len;
//				len = (arr[j][i] != arr[j+1][i]) ? len + 1 : len;
			}

		}
		System.out.println(len);

	}
}
