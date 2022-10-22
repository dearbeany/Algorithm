package boj.bronze;

import java.util.Scanner;

/*
 * 수열 A 
 * 수열 B : 수열 A의 해당 항까지의 평균값 
 */
public class _10539_수빈이와수열 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int len = sc.nextInt();
		int[] a = new int[len];
		int[] b = new int[len];

		for (int i = 0; i < len; i++) {
			b[i] = sc.nextInt();
		}
		for (int i = 0; i < len; i++) {
			a[i] = (i + 1) * b[i];
			for (int j = 0; j < i; j++) {
				a[i] -= a[j];
			}
		}
		for (int i : a) {
			System.out.print(i + " ");
		}
	}
}
