package swea.d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _1289_원재의메모리복구2 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			// 원소의 처음부터 탐색하면서 i번째 원소끼리 같지않으면 !값을 거꾸로
			// 같으면 다음인덱스 탐색
			String initStr = "0000"; // 초기값
			String recovStr = br.readLine(); // 입력받은 복구해야할 원래값

			int cnt = 0; // 같아지기 위한 수정 횟수

			char[] initChar = initStr.toCharArray(); // [0,0,0,0]
			char[] recovChar = recovStr.toCharArray(); // [0,0,1,1]

			for (int i = 0; i < recovChar.length; i++) {
				if (recovChar[i] == initChar[i]) {
					continue;
				} else { // 둘이 문자 다르면 recov의 값을 i번째부터 끝까지 값을 반전시켜준다
					for (int j = i; j < recovChar.length; j++) {
						// 현재값이 1이면 0으로, 0이면 1로
						recovChar[j] = ((recovChar[j] == '1') ? '0' : '1');
					}
					cnt++;
				}
			}

			System.out.printf("#%d %d\n", tc, cnt);

		}
	}
}
