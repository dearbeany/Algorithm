package swea.d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _1289_원재의메모리복구2 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		// 초기화는 모든 비트가 0
		for (int tc = 1; tc <= T; tc++) {

			int res = 0; // 최소 수정 횟수

			String origin = br.readLine();
			char[] init = new char[origin.length()];

			for (int i = 0; i < origin.length(); i++) {
				init[i] = '0';
			}

			for (int i = 0; i < origin.length(); i++) {
				if (init[i] != origin.charAt(i)) {
					res++;
					for (int j = i; j < origin.length(); j++) {
						init[j] = (init[j] == '0') ? '1' : '0';
					}
				}
			}
			System.out.printf("#%d %d\n", tc, res);
		}
	}

}
