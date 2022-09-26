package swea.d3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class _7728_다양성측정2 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			int ans = 0;

			int[] chk = new int[10];
			String s = br.readLine();
			for (int i = 0; i < s.length(); i++) {
				chk[s.charAt(i) - '0']++;
			}
			System.out.println(Arrays.toString(chk));
			for (int i = 0; i < chk.length; i++) {
				if (chk[i] != 0) {
					ans++;
				}
			}

			System.out.println("#" + tc + " " + ans);
		}
	}

}
