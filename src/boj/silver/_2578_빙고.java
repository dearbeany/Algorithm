package boj.silver;
import java.util.Scanner;

public class _2578_빙고 {
	static int[][] map;
	static int[] eraseNum;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		map = new int[5][5];
		// 빙고려면 가로,세로,대각선에 5개의 모든 수가 지워지는 경우
		// 이 선이 3개 이상이면 빙고

		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		eraseNum = new int[25]; // 사회자가 부르는 수
		for (int i = 0; i < 25; i++) {
			eraseNum[i] = sc.nextInt();
		}

		// 사회자가 숫자 부르면 그 자리는 -1로 만들고
		// 빙고됐는지 검사하자
		int res = 0;
		loop: for (int k = 0; k < 25; k++) {
			for (int i = 0; i < 5; i++) {
				for (int j = 0; j < 5; j++) {
					if (eraseNum[k] == map[i][j]) {
						map[i][j] = -1;
//						print();

						if (isBingo()) {
							res = k;
							break loop;
						}
					}
				}
			}
		}
		System.out.println(res + 1);
	}

	private static void print() {
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
	}

	private static boolean isBingo() {
		int cnt = 0;
		// 가로
		for (int i = 0; i < 5; i++) {
			int num = 0; // -1의 개수
			for (int j = 0; j < 5; j++) {
				if (map[i][j] != -1) {
					break;
				}
				num++;
			}
			if (num == 5)
				cnt++;
		}
		// 세로
		for (int i = 0; i < 5; i++) {
			int num = 0; // -1의 개수
			for (int j = 0; j < 5; j++) {
				if (map[j][i] != -1) {
					break;
				}
				num++;
			}
			if (num == 5)
				cnt++;
		}

		// 대각선
		// (0,0) (1,1) (2,2) (3,3) (4,4)
		// (0,4) (1,3) (2,2) (3,1) (4,0)
		int d1 = 0, d2 = 0; // 대각선 1,2
		for (int i = 0; i < 5; i++) {
			if (map[i][i] == -1) {
				d1++;
			}
			if (map[i][4 - i] == -1) {
				d2++;
			}
		}
		if (d1 == 5) {
			cnt++;
		}
		if (d2 == 5) {
			cnt++;
		}

		if (cnt >= 3) {
			return true;
		} else {
			return false;
		}

	}
}
