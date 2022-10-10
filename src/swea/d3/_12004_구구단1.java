package swea.d3;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
 * 정수 N이 1이상 9이하의 a,b곱으로 표현될 수 있는지?
 * 
 * (1) 입력받은 정수 num의 약수 먼저 다 구한 다음에 
 * (2) num / 약수1 = 약수2 일 때
 * (3) 약수1, 약수2 가 1~9 범위 안에 있으면 가능!!   
 */
public class _12004_구구단1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {
			int num = sc.nextInt();

			String res = isPossible(num) ? "Yes" : "No";

			System.out.printf("#%d %s\n", tc, res);
		}
	}

	private static boolean isPossible(int num) {
		List<Integer> divisor = new ArrayList<>(); // 약수를 담은 리스트

		// num의 약수를 구하자
		for (int i = 1; i <= num; i++) {
			if (num % i == 0) {
				divisor.add(i);
			}
		}

		// num / 약수1 = 약수2일 때
		// 약수1, 2 범위에 있으면 가능
		for (int i = 0; i < divisor.size(); i++) {
			int div1 = divisor.get(i); // 약수1
			int div2 = num / div1; // 약수2
			if (is_in(div1) && is_in(div2)) {
				return true;
			}
		}
		return false;
	}

	// 범위 안에 있는지?
	private static boolean is_in(int n) {
		return (n >= 1 && n <= 9);
	}
}
