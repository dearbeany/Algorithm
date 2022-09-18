package swea.d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _10505_소득불균형 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine());

			st = new StringTokenizer(br.readLine());

			int[] income = new int[N];
			for (int i = 0; i < N; i++) {
				income[i] = Integer.parseInt(st.nextToken());
			}

			int avg = 0;
			for (int i : income) {
				avg += i;
			}
			avg /= N;

			int cnt = 0;
			for (int i : income) {
				if (i <= avg)
					cnt++;
			}
			System.out.printf("#%d %d\n", tc, cnt);
		}
	}

}
