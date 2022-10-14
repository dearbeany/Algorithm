package swea.d4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class _1218_괄호짝짓기 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = 10;

		for (int tc = 1; tc <= 10; tc++) {
			int n = Integer.parseInt(br.readLine());
			String str = br.readLine();

			List<Character> list = new ArrayList<>();
			for (int i = 0; i < n; i++) {
				list.add(str.charAt(i));
			}

			char[][] bracket = { { '{', '}' }, { '(', ')' }, { '[', ']' }, { '<', '>' } };
			int res = 1;

			loop: for (int i = 0; i < 4; i++) {
				int cnt1 = 0, cnt2 = 0;
				for (int j = 0; j < n; j++) {
					char c = list.get(j);
					if (c == bracket[i][0]) {
						cnt1++;
					}
					if (c == bracket[i][1]) {
						cnt2++;
					}
				}
				if (cnt1 != cnt2) {
					res = 0;
					break loop;
				}
			}
			System.out.printf("#%d %d\n", tc, res);

		}
	}
}
