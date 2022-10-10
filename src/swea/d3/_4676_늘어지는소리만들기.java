package swea.d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class _4676_늘어지는소리만들기 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			String input = br.readLine(); // 문자열
			List<Character> list = new ArrayList<>(); // 하이픈 추가된 최종 리스트

			for (int i = 0; i < input.length(); i++) {
				list.add(input.charAt(i));
			}
			int hcnt = Integer.parseInt(br.readLine()); // 하이픈 개수

			int[] hipen = new int[hcnt]; // 하이픈 위치
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < hcnt; i++) {
				hipen[i] = Integer.parseInt(st.nextToken());
			}

			Arrays.sort(hipen); // 하이픈 위치 오름차순 정렬

			for (int i = 0; i < hcnt; i++) { // 오름차순 정렬해줬기 때문에
				list.add(hipen[i] + i, '-'); // 앞에 거 하이픈 추가한 만큼 더해주기
			}

			System.out.printf("#%d ", tc);
			for (Character c : list) {
				System.out.print(c);
			}
			System.out.println();
		}
	}
}
