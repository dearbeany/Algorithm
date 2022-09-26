package swea.d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class _7728_다양성측정 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine()); // 테케

		// 입력받은 숫자의 '중복되지 않은' 자릿수를 파악하여
		// 각 자릿수에 해당하는 숫자의 종류를 다양성이라고 한다
		// 따라서, 중복을 막기위해 Set을 사용한다

		for (int tc = 1; tc <= T; tc++) {
			Set<Integer> set = new HashSet<>();

			String input = br.readLine(); // 다양성 체크하고 싶은 숫자
			for (int i = 0; i < input.length(); i++) {
				set.add(input.charAt(i) - '0');
			}

			System.out.printf("#%d %d\n", tc, set.size());
		}
	}

}
