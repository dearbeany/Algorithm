package boj.bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class _9946_단어퍼즐 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int testNum = 0;

		char[] comList = null; // 처음 완성한 단어
		char[] dropList = null; // 떨어뜨린 단어

		String str = ""; // 단어 입력

		while (true) {
			for (int i = 0; i < 2; i++) {
				str = br.readLine();

				if (str.equals("END")) {
					String str2 = br.readLine();
					if (str2.equals("END")) {
						return; // END 두 번 입력 시 while문 종료
					}
				} else {
					if (i == 0) {
						comList = str.toCharArray();
						Arrays.sort(comList);
					} else {
						dropList = str.toCharArray();
						Arrays.sort(dropList);
						testNum++;
					}
				}

			} // end of for

			String result = (isSame(comList, dropList) == true) ? "same" : "different";
//			System.out.println(Arrays.toString(comList));
//			System.out.println(Arrays.toString(dropList));
			System.out.printf("Case %d: %s\n", testNum, result);
		}

	}

	// 완성한 단어와 떨어뜨린 단어가 같은지 체크하는 함수
	public static boolean isSame(char[] arr1, char[] arr2) {
		if (arr1.length != arr2.length) { // 배열의 길이가 다르면 무조건 different. ArrayIndexOutofError 처리
			return false;
		}

		for (int i = 0; i < arr1.length; i++) {
			if (arr1[i] != arr2[i]) {
				return false;
			}
		}
		return true;
	}

}
