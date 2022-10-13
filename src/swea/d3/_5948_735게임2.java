package swea.d3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/*
 * 서로 다른 7개 정수 중 3개 고른 합 중 5번째로 큰 수?
 * 3개라고 선택할 숫자 개수가 정해있으니 반복문 쓰자 
 */
public class _5948_735게임2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {
			int[] num = new int[7];
			for (int i = 0; i < 7; i++) {
				num[i] = sc.nextInt();
			}
			Arrays.sort(num);

			List<Integer> sumList = new ArrayList<>();
			for (int i = 0; i < 7; i++) {
				for (int j = i + 1; j < 7; j++) {
					for (int k = j + 1; k < 7; k++) {
						int sum = num[k] + num[j] + num[i];
						if (!sumList.contains(sum)) {
							sumList.add(sum);
						}
					}
				}
			}
			Collections.sort(sumList, Collections.reverseOrder());
			System.out.printf("#%d %d\n", tc, sumList.get(4));
		}
	}
}
