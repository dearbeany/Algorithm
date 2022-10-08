package boj.bronze;

import java.util.Scanner;

public class _1292_쉽게푸는문제 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int[] arr = new int[1001];

		int idx = 1;
		for (int i = 1; i <= 1000; i++) {
			for (int j = 0; j < i; j++) {
				if (idx == 1001) {
					break;
				}
				arr[idx] = i;
				idx++;
			}
		}

		int a = sc.nextInt();
		int b = sc.nextInt();
		int sum = 0;
		for (int i = a; i <= b; i++) {
			sum += arr[i];
		}

		System.out.println(sum);
	}
}
