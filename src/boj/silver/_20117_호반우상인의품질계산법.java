package boj.silver;

import java.util.Arrays;
import java.util.Scanner;

/* 
 * 그리디) 모든 호반우 묶음 판매 시 최대 이익? 
 * 1. 2개씩 묶어팔아야(가장 작은 퀄, 가장 큰 퀄리티) 중간값이 가장 큰 퀄리티이기에 최대 이익 
 * 2. 짝수/홀수 다르게 계산하는데,
 * 3. 전체 개수 홀수면 2개씩 묶어판 후에 가장 남은 중간값을 더해준다  
 */

public class _20117_호반우상인의품질계산법 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt(); // 묶음 개수

		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}

		Arrays.sort(arr);

		int sum = 0;
		if (n % 2 == 0) {
			for (int i = n - 1; i >= n / 2; i--) {
				sum += arr[i] * 2;
			}
		} else {
			for (int i = n - 1; i > n / 2; i--) {
				sum += arr[i] * 2;
			}
			sum += arr[n / 2];
		}
		System.out.println(sum);
	}
}
