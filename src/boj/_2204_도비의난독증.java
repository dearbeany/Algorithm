package boj;

import java.util.Arrays;
import java.util.Scanner;

public class _2204_도비의난독증 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n;

		do {
			n = sc.nextInt();
			sc.nextLine();

			String[] str = new String[n];

			for (int i = 0; i < n; i++) {
				str[i] = sc.nextLine();
			}

			String[] arr1 = new String[n]; // 원본 리스트
			String[] arr2 = new String[n]; // 정렬용 리스트

			for (int i = 0; i < n; i++) {
				arr1[i] = str[i];
				arr2[i] = str[i].toLowerCase();
			}

			Arrays.sort(arr2);

			for (int i = 0; i < n; i++) {
				if (arr1[i].toLowerCase().equals(arr2[0])) {
					System.out.println(arr1[i]);
				}
			}

		} while (n != 0); // 0을 입력하면 종료
	}
}
