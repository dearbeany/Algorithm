package swea.d3;

import java.util.Scanner;

public class _10032_과자분배 {
	public static void main(String[] args) {
		// n개 과자 k명에게 분배
		// 최대한 공평하게 과자수 차이 최소화 하자
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {
			int n = sc.nextInt(); // n개 과자
			int k = sc.nextInt(); // k명 사람

			// k개로 나눠떨어지면 모두에게 공평하게 배분했으니 차이 0
			// 안 나눠떨어지면 차이 1
			int res = n % k == 0 ? 0 : 1;
			System.out.printf("#%d %d\n", tc, res);
		}
	}
}
