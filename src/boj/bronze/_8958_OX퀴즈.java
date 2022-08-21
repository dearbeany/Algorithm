package boj.bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class _8958_OX퀴즈 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		for (int tc = 0; tc < T; tc++) {
			String str = br.readLine();

			int[] scores = new int[str.length()]; // 문제 별 점수를 담는 배열

			int cnt = 0; // O의 개수

			for (int i = 0; i < str.length(); i++) {
				if (str.charAt(i) == 'O') {
					cnt++;
					scores[i] += cnt;
				} else {
					cnt = 0;
				}
			}
			System.out.println(Arrays.toString(scores));
			int sum = 0;
			for (int i : scores) {
				sum += i;
			}
			System.out.println(sum);

		}

	}
}
