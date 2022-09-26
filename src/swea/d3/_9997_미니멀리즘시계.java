package swea.d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _9997_미니멀리즘시계 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			int h = 0, m = 0;
			int angle = Integer.parseInt(br.readLine()); // 도
			int minute = angle * 2; // 1도에 2분

			h = minute / 60;
			m = minute % 60;

			System.out.printf("#%d %d %d\n", tc, h, m);
		}
	}

}
