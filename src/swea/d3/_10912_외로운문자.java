package swea.d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class _10912_외로운문자 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			// 먼저 Set에 다 넣고
			// Set에 저장된 알파벳이 홀수번 등장하면 결과 리스트에 넣기
			String input = br.readLine();
			Set<Character> set = new HashSet<>();
			for (int i = 0; i < input.length(); i++) {
				set.add(input.charAt(i));
			}
			int cnt = 0; // 알파벳 등장횟수
			List<Character> list = new ArrayList<>(); // 결과 리스트

			for (Character c : set) {
				for (int j = 0; j < input.length(); j++) {
					if (c == input.charAt(j)) {
						cnt++;
					}
				}
				if (cnt % 2 == 1) { // 홀수번 등장하면 짝지어지지 않으니까
					list.add(c); // 남는 문자는 결과에 저장
				}
				cnt = 0;
			}
			Collections.sort(list); // 사전순 정렬

			System.out.printf("#%d ", tc);
			if (list.size() == 0) { // 어떤 문자도 남지 않으면
				System.out.println("Good");
			} else {
				for (Character c : list) {
					System.out.print(c);
				}
				System.out.println();
			}
		}
	}
}
