package swea.d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _15230_알파벳공부 {
	static String alpha = "abcdefghijklmnopqrstuvwxyz";
	static int cnt;

	public static void main(String[] args) throws NumberFormatException, IOException {
		// 알파벳 순서와 일치하는 개수
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			String input = br.readLine(); // 입력 문자열

			cnt = 0; // 일치 개수
			isSameCount(input); // 몇 개 일치하는지 체크 함수

			System.out.printf("#%d %d\n", tc, cnt);
		}
	}

	private static boolean isSameCount(String input) {
		for (int i = 0; i < input.length(); i++) { // 입력문자열 처음부터 돌면서
			if (alpha.charAt(i) == input.charAt(i)) { // 알파벳과 일치하면
				cnt++; // 카운트 해주고
			} else { // 하나라도 일치하지 않으면
				return false; // 바로 리턴해버려 ... 순서대로 일치하는 게 아니니깐
			}
		}
		return true;
	}
}
