package boj.silver;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/*
 * 아이스크림 N개 중 3개를 선택한다. 단, 함께 섞으면 안 되는 조합 M개가 주어진다.
 * 
 * (1) 2개를 뽑아서 섞어도 되는지 확인
 * (2) 2개 섞어도 되면 아이스크림 1개 더 선택 
 * (3) 새로 뽑은 아이스크림이랑 앞서 선택한 2개 섞어도 되면 cnt++
 */

public class _2422_한윤정아이스크림 {

	static boolean[][] iceComb;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		// N개 중 3개를 선택
		// 단, 함께 선택하면 안 되는 조합 M개

		int N = Integer.parseInt(st.nextToken()); // 아이스크림 종류의 수
		int M = Integer.parseInt(st.nextToken()); // 섞으면 안 되는 조합의 수

		iceComb = new boolean[N + 1][N + 1]; // 아이스크림 조합 n은 최대 200개

		// 아이스크림의 조합은 처음 모두 true로 세팅한다
		// 주의할 점: 아이스크림은 row = 0 col = 0 인 경우를 고려하지 않는다
		// 같은 아이스크림 섞으면 안 되므로 i==j 같으면 false로 세팅
		for (int i = 0; i < N + 1; i++) {
			for (int j = 0; j < N + 1; j++) {
				iceComb[i][j] = true;
				if (i == j) {
					iceComb[i][j] = false;
				}
			}
		}

		// 섞으면 안 되는 조합을 false로 세팅
		for (int m = 0; m < M; m++) {
			st = new StringTokenizer(br.readLine());
			int row = Integer.parseInt(st.nextToken());
			int col = Integer.parseInt(st.nextToken());
			iceComb[row][col] = false;
			iceComb[col][row] = false;
		}

//		for (int i = 0; i < N + 1; i++) {
//			for (int j = 0; j < N + 1; j++) {
//				int res = (iceComb[i][j] == true) ? 1 : 0;
//				System.out.print(res + " ");
//			}
//			System.out.println();
//		}

		int cnt = 0; // 섞어도 되는 조합의 개수

		for (int i = 1; i < N + 1; i++) {
			for (int j = i + 1; j < N + 1; j++) {
				// 2개를 먼저 뽑아서 조합이 true면
				if (iceComb[i][j]) {
//					System.out.println(i + "," + j);

					// 1개를 추가로 뽑는다
					for (int k = j + 1; k < N + 1; k++) {
						if (iceComb[i][k] && iceComb[j][k]) {
							cnt++;
//							System.out.println(i + "," + j + "," + k);
						}
					}
				} else { // 앞선 2개 조합이 false면
					continue;
				}
			}
		}
		bw.write(cnt + "");
		bw.flush();
		bw.close();

	}
}
