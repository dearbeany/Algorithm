package swea.d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _3314_보충학습과평균 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			int[] scores = new int[5];
			st = new StringTokenizer(br.readLine());
			int sum = 0;

			for (int i = 0; i < 5; i++) {
				scores[i] = Integer.parseInt(st.nextToken());
				scores[i] = (scores[i] < 40) ? 40 : scores[i]; // 40점 미만이면 40점으로 바꿔주기
				sum += scores[i]; // 합 다 더해서 출력할 때 전체 수로 나누기
			}
			System.out.printf("#%d %d\n", tc, sum / 5);
		}
	}
}
