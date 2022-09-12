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

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int A = Integer.parseInt(st.nextToken()); // 1시간 일하고 증가한 피로도
		int B = Integer.parseInt(st.nextToken()); // 1시간 일하고 처리하는 일의 양
		int C = Integer.parseInt(st.nextToken()); // 1시간 쉬고 감소한 피로도
		int M = Integer.parseInt(st.nextToken()); // 최대 수용가능한 피로도

		int workAmount = 0; // 처리한 일의 양
		int hour = 24; // 하루 시간
		int fatigue = 0; // 피로도

		while (hour != 0) {
			if (fatigue + A <= M) { // 1시간 일한 피로도가 한계 이하일 경우에만
				fatigue += A; // 피로도 증가
				workAmount += B; // 처리한 일의 양 증가
			} else {
				if (fatigue - C < 0) { // 피로도 < 0이면
					fatigue = 0; // 0으로 세팅
				} else {
					fatigue -= C; // 아닌 경우 쉬니깐 피로도 빼줌
				}
			}
			hour--;
		}
		System.out.println(workAmount);
	}
}
