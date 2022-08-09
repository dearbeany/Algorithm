package sw.d1;

import java.util.Scanner;

public class _2043_서랍의비밀번호 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int p = sc.nextInt();
		int k = sc.nextInt();
		int cnt = 0;

		while (p > k) {
			cnt++;
			k++;
		}
		System.out.println(cnt + 1);
	}
}
