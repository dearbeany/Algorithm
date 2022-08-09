package sw.d1;

import java.util.Scanner;

public class _1545_거꾸로출력 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();

		while (n >= 0) {
			System.out.print(n + " ");
			n--;
		}
	}
}
