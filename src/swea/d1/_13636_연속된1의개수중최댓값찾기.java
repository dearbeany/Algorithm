package swea.d1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _13636_연속된1의개수중최댓값찾기 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			int n = Integer.parseInt(br.readLine()); // 수열 개수

			int[] arr = new int[n];
			String str = br.readLine();
			for (int i = 0; i < str.length(); i++) {
				arr[i] = str.charAt(i) - '0';
			}

		}

	}

}
