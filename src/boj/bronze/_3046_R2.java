package boj.bronze;

import java.util.Scanner;

public class _3046_R2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int r1 = sc.nextInt();
		int s = sc.nextInt();
		// r1 + r2 = 2*s
		// r2 = 2*s - r1
		System.out.println(2 * s - r1);
	}
}
