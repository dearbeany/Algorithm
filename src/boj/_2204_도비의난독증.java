package boj;

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

			// string to char array
			// arr[0] = [c,a,t]
			// arr[1] = [f,a,t]

			for (String s : str) {
				s = s.toLowerCase(); // 모두 소문자로 만들어줌
			}

			// 단어 중 최고의 길이(20)
			char[] sorted = new char[20];

			for (int i = 0; i < 20; i++) {
			}

		} while (n != 0); // 0을 입력하면 종료
	}
}
