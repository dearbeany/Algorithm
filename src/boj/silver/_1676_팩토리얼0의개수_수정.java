package boj.silver;

/*
 * 핵심 아이디어
 * 1. 0은 10의 배수. 즉 2*5가 생길 경우에만 생성됨
 * 2. 최종적으로 팩토리얼에 포함된 5의 개수만큼의 0이 생김 
 * 3. 구한 0의 개수를 입력 후 출력 
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _1676_팩토리얼0의개수_수정 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		int cnt = 0;
		while (n >= 5) {
			cnt += n / 5;
			n /= 5;
		}
		System.out.println(cnt);
	}
}
