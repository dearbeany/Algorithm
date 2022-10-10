package swea.d3;

import java.util.Arrays;
import java.util.Scanner;

public class _111736_평범한숫자 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {
			// 평범한 숫자란 가운데 껴서 셋 중 최솟값도 최댓값도 아닌 것
			int n = sc.nextInt(); // 순열의 개수

			int[] nums = new int[n];
			int[] tmp = new int[3]; // 최소, 최대 알기 위해
			int min, max, cnt = 0;

			for (int i = 0; i < n; i++) {
				nums[i] = sc.nextInt();
			}

			for (int i = 1; i < n - 1; i++) {
				int idx = 0;
				for (int j = i - 1; j <= i + 1; j++) {
					tmp[idx++] = nums[j];
				}

				int p = tmp[1]; // 중간에 있는 값
				Arrays.sort(tmp); // 오름차순 정렬해서
				min = tmp[0];
				max = tmp[2];
				if (p > min && p < max) { // 중간값이 최소보다 크고 최대보다 크면
					cnt++; // 평범한 숫자
				}
			}

			System.out.printf("#%d %d\n", tc, cnt);
		}
	}
}
