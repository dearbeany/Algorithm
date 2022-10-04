package swea.d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class _11856_반반 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		// 사이즈는 2이어야 하고,
		// 각각 등장은 두 번씩 해야 함
		for (int tc = 1; tc <= T; tc++) {
			Set<Character> set = new HashSet<>(); // 알파벳 담을 셋

			String str = br.readLine();
			for (int i = 0; i < str.length(); i++) {
				set.add(str.charAt(i));
			}

			int size = set.size(); // 셋의 크기는 2이어야 함

			char[] arr = str.toCharArray();
			char c1 = arr[0];

			int cnt = 0; // 알파벳 등장 횟수
			boolean flag = false;

			for (int i = 0; i < arr.length; i++) {
				if (c1 == arr[i]) {
					cnt++;
				}
			}
			if (size == 2 && cnt == 2) {
				flag = true;
			}

			String result = (flag) ? "Yes" : "No";

			System.out.printf("#%d %s\n", tc, result);
		}
	}

}
