package sw.d2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Base64;

public class _1928_Base64Decoder {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			String encode = br.readLine();
			String decode = new String(Base64.getDecoder().decode(encode));
			System.out.printf("#%d %s\n", tc, decode);
		}
	}
}
