package boj.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _2839_설탕배달 {
	public static int cnt = 0;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		System.out.println(func(n));

	}

	public static int func(int n) {
		if (n < 3 || n == 4 | n == 7) { // 설탕 0,1,2,4,7일 때 봉지 사용 X
			return -1;
		} else if (n == 3 || n == 5) { // 봉지개수 +1
			return 1;
		} else {
			if (n % 5 == 0) { // 5로 나누어 떨어지는 경우
				return func(n - 5) + 1;
			} else { // 5로 나누어떨어지지 않는 이외의 모든 경우
				return func(n - 3) + 1;
			}
		}

	}

}
