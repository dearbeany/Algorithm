package swea.d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class _4406_모음이보이지않는사람 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine()); // 테케

		for (int tc = 1; tc <= T; tc++) {
			String str = br.readLine();

			List<Character> slist = new ArrayList<>(); // 모음 없는 단어

			// 모음이 아니면 리스트에 추가
			for (int i = 0; i < str.length(); i++) {
				if (str.charAt(i) != 'a' && str.charAt(i) != 'e' && str.charAt(i) != 'i' && str.charAt(i) != 'o'
						&& str.charAt(i) != 'u') {
					slist.add(str.charAt(i));
				}
			}

			System.out.printf("#%d ", tc);
			for (int i = 0; i < slist.size(); i++) {
				System.out.print(slist.get(i));
			}
			System.out.println();
		}
	}
}
