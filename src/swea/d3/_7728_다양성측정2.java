package swea.d3;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class _7728_다양성측정2 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine()); // 테케

		// 입력받은 숫자의 자릿수가
		// 몇 개씩 존재하는지 digit[] 배열에 담는다
		// 만약 배열에 저장된 값이 0 이상이면 해당 자릿수는 존재한다는 뜻!

		for (int tc = 1; tc <= T; tc++) {

			int[] digit = new int[10]; // 0~9까지 자릿수 저장되는 배열
			String input = br.readLine(); // 다양성 확인하고 싶은 입력숫자

			for (int i = 0; i < input.length(); i++) {
				digit[input.charAt(i) - '0']++;
			}
//			System.out.println(Arrays.toString(digit));

			int diversity = 0;
			for (int i = 0; i < digit.length; i++) {
				if (digit[i] > 0) { // 인덱스에 해당하는 숫자가 존재하므로
					diversity++; // 다양성 +1
				}
			}
			System.out.printf("#%d %d\n", tc, diversity);
		}
	}

}
