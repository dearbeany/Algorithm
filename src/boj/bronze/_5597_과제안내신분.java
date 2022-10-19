package boj.bronze;

import java.util.Scanner;

public class _5597_과제안내신분 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int[] checked = new int[31];

		for (int i = 0; i < 28; i++) {
			checked[sc.nextInt()]++;
		}

		for (int i = 1; i < 31; i++) {
			if (checked[i] == 0) {
				System.out.println(i);
			}
		}
	}
}
