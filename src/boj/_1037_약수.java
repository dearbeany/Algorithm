package boj;

import java.util.Arrays;
import java.util.Scanner;

public class _1037_약수 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt(); // 진짜 약수의 개수
		int result = 0;

		int[] arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}
		Arrays.sort(arr); // 오름차순 정렬

		// 1과 자기자신 제외한 배열에서 맨앞*맨끝의 약수 곱한다
		result = arr[0] * arr[N - 1];
		System.out.println(result);
	}
}
