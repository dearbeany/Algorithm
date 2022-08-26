package swea.d2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _2007_마디의길이 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			String str = br.readLine();

			int idx = 0;
			int length = 0;

			for (int i = 1; i < str.length(); i++) {
				if (str.charAt(0) == str.charAt(i)) {

					for (int j = 0; j < i; j++) {
						if (str.charAt(j) != str.charAt(i + j)) { // 하나라도 다르면
//							System.out.println(str.charAt(j) + "," + str.charAt(idx + j));
							break;
						} else {
							idx = i;
						}
					}

				}
			}
			System.out.println(idx);
		}

	}
}
