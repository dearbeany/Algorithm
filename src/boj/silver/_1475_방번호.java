package boj.silver;

import java.util.Scanner;

public class _1475_방번호 {
	public static void main(String[] args) {
		// 세트 한 개엔 0~9까지 담겨 있다
		// 단 6, 9는 뒤집어서 사용이 가능하다
		Scanner sc = new Scanner(System.in);
		String str = sc.next(); // 방번호

		int[] set = new int[10];
		for (int i = 0; i < str.length(); i++) {
			set[str.charAt(i) - '0']++;
		}
		int cnt = 0; // 세트의 개수
		// 가장 큰 숫자의 개수만큼 세트가 필요함 단 6,9는 빼고

		int needSetCnt = Integer.MIN_VALUE; // 6,9 제외하고 필요한 세트 개수
		for (int i = 0; i < set.length; i++) {
			if (i == 6 || i == 9) {
				continue;
			}
			needSetCnt = Math.max(needSetCnt, set[i]);
		}

		int setCnt = set[6] + set[9]; // 6,9 만들기 위한 필요 세트 개수
		setCnt = (setCnt % 2 == 1) ? (setCnt + 1) / 2 : setCnt / 2;

		int res = needSetCnt > setCnt ? needSetCnt : setCnt;
		System.out.println(res);

	}
}
