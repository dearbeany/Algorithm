package boj.silver;

/*
 * 1. () 을 공백으로 바꾸고
 * 2. 공백을 제거한다.
 * 3-1. 위 과정을 반복하다보면 VPS는 문자열의 길이가 0이됨.
 * 3-2. 반면 VPS가 아니라면 남은 문자열의 길이는 무조건 1 이상.
 * 
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _9012_괄호 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine()); // 테스트 개수

		for (int i = 0; i < T; i++) {
			String str = br.readLine();
			String res;

			// 하나의 괄호 문자열의 길이는 2 이상 50 이하
			for (int j = 0; j < 30; j++) {
				str = str.replace("()", "");
			}

			if (str.length() == 0) {
				// VPS 일 때
				res = "YES";
			} else {
				// VPS 아닐 때
				res = "NO";
			}
			sb.append(res).append("\n");
		}
		System.out.println(sb);
	}
}
