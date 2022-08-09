package sw.d1;
/*
 * 카운팅정렬을 이용하여
 * 중간값을 찾는다
 */

import java.util.Scanner;

public class _2063_중간값찾기_카운팅정렬 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt(); // 사용자 입력

		int[] arr = new int[101]; // 0점부터 100점까지의 점수를 저장하는 배열

		// 사용자의 입력을 점수배열에 저장
		// 배열에 저장되는 값은 각 점수(인덱스)의 개수
		for (int i = 0; i < N; i++) {
			int score = sc.nextInt();
			arr[score]++;
		}

		// 누적합 배열 생성
		// 두 번째 배열부터 앞의 값들을 차례대로 누적
		for (int i = 1; i < 101; i++) {
			arr[i] += arr[i - 1];
		}

		// 중간값이려면 누적합 배열에 들어있는 개수가
		// 내 앞으로 전체 개수의 1/2개가 존재해야 함
		// 따라서, 중간값의 순서는 N/2 +1 번째임
		int mid = N / 2 + 1;

		for (int i = 0; i < 101; i++) {
			if (arr[i] == mid) {
				System.out.println(i); // 중간값에 해당하는 점수 출력
			}
		}
	}
}
