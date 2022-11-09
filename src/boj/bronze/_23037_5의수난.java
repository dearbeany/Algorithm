package boj.bronze;

import java.util.Scanner;

public class _23037_5의수난 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		char[] carr = sc.nextLine().toCharArray();
		int[] arr = new int[carr.length];

		for (int i = 0; i < carr.length; i++) {
			arr[i] = (int) Math.pow(carr[i] - '0', 5);
		}

		int sum = 0;
		for (int i : arr) {
			sum += i;
		}
		System.out.println(sum);
	}
}
