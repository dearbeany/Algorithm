package swea.d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _11688_Calkin {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			int a = 1, b = 1;

			String cmd = br.readLine();

			for (int i = 0; i < cmd.length(); i++) {
				switch (cmd.charAt(i)) {
				case 'L':
					b = a + b;
					break;
				case 'R':
					a = a + b;
					break;
				}
			}
			System.out.printf("#%d %d %d\n", tc, a, b);
		}
	}

}
