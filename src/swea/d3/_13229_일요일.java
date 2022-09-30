package swea.d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _13229_일요일 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] arr = { "MON", "TUE", "WED", "THU", "FRI", "SAT", "SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT",
				"SUN" };
		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			String day = br.readLine();

			int startIdx = 0, cnt = 0;

			for (int i = 0; i < arr.length; i++) {
				if (day.equals(arr[i])) {
					startIdx = i;
					break;
				}
			}
			for (int i = startIdx + 1; i < arr.length; i++) {
				if (arr[i].equals("SUN")) {
					break;
				} else {
					cnt++;
				}
			}
			System.out.printf("#%d %d\n", tc, cnt + 1);
		}
	}

}
