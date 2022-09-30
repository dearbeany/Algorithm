package swea.d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class _8741_두문자어 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());

			List<Character> list = new ArrayList<>();
			int n = st.countTokens();
			for (int i = 0; i < n; i++) {
				list.add(st.nextToken().toUpperCase().charAt(0));
			}

			System.out.print("#" + tc + " ");
			for (Character c : list) {
				System.out.print(c);
			}
			System.out.println();
		}
	}
}
