package boj.bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 우선순위 
 * 별 > 동그라미 > 네모 > 세모 
 * 4 > 3 > 2 > 1  
 * 모두 같으면 무승부 D 
 */
public class _14696_딱지놀이 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int round = Integer.parseInt(br.readLine()); // 총 라운드 개수

		for (int tc = 0; tc < round; tc++) {
			st = new StringTokenizer(br.readLine());
			int aLen = Integer.parseInt(st.nextToken()); // a의 길이
			int[] a = new int[aLen];

			for (int i = 0; i < a.length; i++) {
				a[i] = Integer.parseInt(st.nextToken());
			}

			st = new StringTokenizer(br.readLine());
			int bLen = Integer.parseInt(st.nextToken()); // b의 길이
			int[] b = new int[bLen];

			for (int i = 0; i < b.length; i++) {
				b[i] = Integer.parseInt(st.nextToken());
			}

			// a의 값을 인덱스로 하는 배열 생성
			// a의 값은 별, 동그라미, 네모, 세모를 의미하는 4~1까지만 존재하므로 크기는 5만큼으로 생성
			// 결국 counts[0]의 값은 사용X
			int[] countsA = new int[5];
			for (int i = 0; i < a.length; i++) {
				countsA[a[i]]++;
			}

			// b의 값을 인덱스로 하는 배열 생성
			int[] countsB = new int[5];
			for (int i = 0; i < b.length; i++) {
				countsB[b[i]]++;
			}

//			System.out.println(Arrays.toString(countsA));
//			System.out.println(Arrays.toString(countsB));

			char res = 0; // 승부의 결과

			for (int i = 4; i > 0; i--) {
				if (countsA[i] > countsB[i]) {
					res = 'A';
					break;
				} else if (countsA[i] < countsB[i]) {
					res = 'B';
					break;
				} else {
					if (i == 1)
						res = 'D';
				}
			}
			System.out.println(res);
		}

	}
}
