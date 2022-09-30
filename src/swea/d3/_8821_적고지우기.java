package swea.d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class _8821_적고지우기 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			List<Integer> list = new ArrayList<>();

			String str = br.readLine();

			for (int i = 0; i < str.length(); i++) {
				int num = str.charAt(i) - '0';
				if (!list.contains(num)) { // 숫자 안 적혀 있으면
					list.add(num); // 적고
				} else { // 적혀 있으면
					list.remove(Integer.valueOf(num)); // 지우자
				}
			}
			System.out.printf("#%d %d\n", tc, list.size());
		}
	}
}
