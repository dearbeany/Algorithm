package boj;

import java.util.Scanner;

public class _1316_그룹단어체커 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt(); // 테스트 케이스 개수
		sc.nextLine();
		int cnt = 0; // 그룹단어가 아닌 단어의 개수

		for (int i = 0; i < N; i++) {
			String str = sc.nextLine(); // 단어 입력

			boolean isCounted = false;
			for (int j = 0; j < str.length() - 1; j++) {
				if (isCounted) {
					break;
				}
				if (str.charAt(j) != str.charAt(j + 1)) {
					// j번째와 j+1 번째 글자가 다르면

					for (int k = j + 2; k < str.length(); k++) {
						// 하나라도 같으면 그룹단어 아님
						if (str.charAt(j) == str.charAt(k)) {
							cnt++;
							isCounted = true; // 앞에서 카운트 되면 그 후로 더이상 카운트 할 수 없도록
							break;

//							System.out.println(str.charAt(j));
//							System.out.println("cnt: " + cnt);
						}
					} // end of for k

				} // end of if
			} // end of for j
		} // end of for i
		System.out.println(N - cnt);
	}
}
