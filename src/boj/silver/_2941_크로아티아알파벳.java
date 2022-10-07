package boj.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _2941_크로아티아알파벳 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] clist = { "c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z=" };

		// 입력으로 주어진 단어가 몇 개의 크로아 알파벳인지?
		// 크로아 아닌 문자도 카운트
		String input = br.readLine();
		for (int i = 0; i < clist.length; i++) {
			if (input.contains(clist[i])) {
				input = input.replace(clist[i], "*");
			}
		}
		System.out.println(input.length());
	}
}
