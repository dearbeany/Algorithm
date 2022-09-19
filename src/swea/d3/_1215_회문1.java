package swea.d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _1215_회문1 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		char[][] arr = new char[9][9];

		for (int tc = 1; tc <= 1; tc++) {
			int len = Integer.parseInt(br.readLine()); // 찾아야하는 회문의 길이

			for (int i = 0; i < 8; i++) {
				String str = br.readLine();
				for (int j = 0; j < 8; j++) {
					arr[i][j] = str.charAt(j);
				}
			}

			int cnt = 0;
			int res = 0;

			// 행우선 탐색
			for (int i = 0; i < 8; i++) {
				for (int j = 0; j < 8; j++) {
					for (int k = j; k < len / 2; k++) {
						if (arr[i][k] != arr[i][len - 1 - k]) {
							break;
						}
						cnt++;
					}
					if (cnt == len) {
						res++;
						cnt = 0;
					}
				}
			}

			System.out.printf("#%d %d\n", tc, res);
		}
	}

}
