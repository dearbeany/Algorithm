package boj.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _5046_전국대학생프로그래밍 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken()); // 참가자 수
		int B = Integer.parseInt(st.nextToken()); // 예산
		int H = Integer.parseInt(st.nextToken()); // 호텔의 수
		int W = Integer.parseInt(st.nextToken()); // 고를 수 있는 주의 개수

		boolean isPossible = false;
		int minCost = Integer.MAX_VALUE;

		for (int h = 0; h < H; h++) {
			int pcost = Integer.parseInt(br.readLine()); // 개인당 비용
			st = new StringTokenizer(br.readLine());

			for (int i = 0; i < W; i++) {
				int people = Integer.parseInt(st.nextToken());

				// 숙박 가능 인원 수 >= 참가자 수
				// 인당 숙박비용 * 참가자수 <= 예산
				if (people >= N && pcost * N <= B) {
					isPossible = true;
					minCost = Math.min(minCost, pcost * N);
				}
			}
		}

		if (isPossible) {
			System.out.println(minCost);
		} else {
			System.out.println("stay home");
		}
	}
}
