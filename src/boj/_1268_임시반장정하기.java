package boj;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class _1268_임시반장정하기 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt(); // 학생의 수 N
		int grade = 1;
		int num = 0;

		int[][] arr = new int[N][5]; // 학생의수 N*학년(1~5)

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < 5; j++) {
				arr[i][j] = sc.nextInt();
			}
		}

		for (int i = 0; i < N; i++) { // 학생
			Set<Integer> set = new HashSet<>();
			for (int j = 0; j < 5; j++) { // 학년
				for (int k = 0; k < N; k++) { // 비교를 위한 학생 (row)
					if (i == k) { // 비교대상이 같으므로 패스
						continue;
					}
					if (arr[i][j] == arr[k][j]) {
						set.add(k);
//						System.out.printf("i: %d, j: %d, k: %d %d\n", i, j, k, arr[i][j]);
					}
				}
			} // end of for 학년

			if (num < set.size()) {
				num = set.size();
				grade = i + 1;
			}

		} // end of for 학생

		System.out.println(grade);
	}
}
