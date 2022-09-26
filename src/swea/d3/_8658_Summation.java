package swea.d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _8658_Summation {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());

			int[] sum = new int[10];

			for (int i = 0; i < 10; i++) {
				String str = st.nextToken();
				for (int j = 0; j < str.length(); j++) {
					sum[i] += str.charAt(j) - '0';
				}
			}
			Arrays.sort(sum);

			System.out.printf("#%d %d %d\n", tc, sum[9], sum[0]);
		}

	}

}
