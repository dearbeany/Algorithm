package boj.bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _22864_피로도 {
	public static void main(String[] args) throws IOException {
		// 1시간 일하면 피로도 +A 일 +3
		// 1시간 쉬면 피로도 -C (단, 피로도 < 0 인 경우 0으로 세팅)
		// 피로도 <= M 하루 24시간
		// 최대 얼마나 일을 할 수 있는가

		// A B C M
		// 5 3 2 0
		// 1시간 일하면 피로도 +5 일 +3
		// 1시간 쉬면 피로도 -2

		// 1시간 일하면 적어도 3시간 쉬어야 함.
		// A + C = 24
		// 5A - 2C <= M
		// 일은 3A

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int A = Integer.parseInt(st.nextToken()); // 1시간 일하고 증가한 피로도
		int B = Integer.parseInt(st.nextToken()); // 1시간 일하고 처리하는 일의 양
		int C = Integer.parseInt(st.nextToken()); // 1시간 쉬고 감소한 피로도
		int M = Integer.parseInt(st.nextToken()); // 최대 수용가능한 피로도

		int workAmount = 0; // 처리한 일의 양
		int hour = 24; // 하루 시간
	}
}
