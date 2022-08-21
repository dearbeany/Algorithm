package boj.bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _2851_슈퍼마리오 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int[] scores = new int[10];

		int sum = 0, res = 0;

		for (int i = 0; i < 10; i++) {
			scores[i] = Integer.parseInt(br.readLine());

			if (sum < 100) {
				sum += scores[i];

				if (Math.abs(res - 100) > Math.abs(sum - 100)) { // 100과의 차이가 더 작은 걸 선택
					res = sum;
				} else if (Math.abs(res - 100) == Math.abs(sum - 100)) { // 100에서 차이가 같은 수 두 개면 더 큰 수를 선택
					res = res > sum ? res : sum;
				}
			}
		}
		System.out.println(res);

		// 점수의 합이 최대한 100에 가까워야 함
		// 단 중간에 멈출 수 없음
		// 100과 차이가 더 작은 것이 답임

	}
}
