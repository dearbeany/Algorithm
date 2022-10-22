package boj.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * 쇠막대기, 레이저 배치 받았을 때 
 * 잘린 쇠막대기의 개수? ()는 레이저임 
 */
public class _10799_쇠막대기 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String str = br.readLine();
		str = str.replace("()", "*"); // 레이저로 바꿔주기

		int stick = 0; // 현재 막대기 개수
		int cutStick = 0; // 잘린 막대기 개수

		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			if (c == '(') { // 막대기 시작
				stick++;
			} else if (c == '*') {
				cutStick += stick;
			} else { // ')' 만나면 막대기 끝남
				stick--;
				cutStick++;
			}
		}
		System.out.println(cutStick);
	}
}
